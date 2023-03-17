# spring cache 




## 🌈 spring cache 구조


<br>
<br>
<br>
<br>
<br>


## 🌈 예제코드 

<br>

> 캐시데이터를 이용한 회원 CRUD 구현.

<br>

### 🐳 버젼 & 환경설정

<br>

* java - 11
* gradle
* springboot - 2.7.9
* dependencies
    - web, dev, lombok, jpa, H2
    - 추가(내장캐시를 위해)
    ```yml
    implementation 'org.springframework.boot:spring-boot-starter-cache'
    ```


<br>
<br>
<br>

### 🐳 entity

<br>

```java
package com.example.spring_cache_test.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private Integer age;

}

```



<br>
<br>
<br>

### 🐳 controller

```java
package com.example.spring_cache_test.controller;

import com.example.spring_cache_test.dto.MemberDeleteDto;
import com.example.spring_cache_test.dto.MemberDto;
import com.example.spring_cache_test.entity.Member;
import com.example.spring_cache_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity join(@RequestBody MemberDto memberDto){
        memberService.saveMember(memberDto);
        log.info("회원 가입");
        return new ResponseEntity<>("성공", HttpStatus.OK);
    }

    @GetMapping("/find/{memberId}")
    public ResponseEntity<MemberDto> findMember(@PathVariable(name = "memberId") Long memberId){
        MemberDto memberDto = new MemberDto();
        log.info("회원service - 전");
        Member findedMember = memberService.findMemberById(memberId);
        log.info("회원service - 후");
        memberDto.setUsername(findedMember.getUsername());
        memberDto.setAge(findedMember.getAge());
        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

    // 회원 수정
    @PutMapping("/update/{memberId}")
    public ResponseEntity<String> changeMember(@PathVariable(name = "memberId") Long memberId,
                                                @RequestBody MemberDto memberDto){
        Member updatedMember = memberService.update(memberId, memberDto);
        log.info("check 결과 : {}" , updatedMember);
        if(updatedMember == null){
            return new ResponseEntity("실패",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("성공",HttpStatus.OK);
    }

    // 회원 삭제
    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable(name = "memberId") Long memberId){
        Member findedMember = memberService.findMemberById(memberId);
        MemberDeleteDto memberDeleteDto = new MemberDeleteDto();
        memberDeleteDto.setId(findedMember.getId());
        memberDeleteDto.setUsername(findedMember.getUsername());
        memberDeleteDto.setAge(findedMember.getAge());
        memberService.deleteMember(memberDeleteDto);
        log.info("controller - 삭제 성공");
        return new ResponseEntity<>("성공", HttpStatus.OK);
    }

}

```


<br>
<br>
<br>

### 🐳 dto

<br>

* MemberDto

```java
package com.example.spring_cache_test.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private String username;
    private Integer age;

}

```


* MemberDeleteDto
    - 캐시어노테이션의 value이외의 key를 사용하기 위해 굳이 만듬.

```java
package com.example.spring_cache_test.dto;

import lombok.Data;

@Data
public class MemberDeleteDto {

    private Long id;
    private String username;
    private Integer age;

}

```



<br>
<br>
<br>

### 🐳  service

* Cacheable : 조회에 사용
    - 캐시데이터를 먼저 조회하는 역할.
    - 캐시데이터가 존재하지 않을때만 어노테이션 아래의 메서드를 실행시킴.


* CachePut : 수정에 사용
    - 말그대로 RDB에 수정쿼리가 나간 뒤, 객체 자체를 캐시데이터로 저장시킴(put)


* CacheEvict : 삭제에 사용.
    - RDB에 삭제 쿼리가 나간 뒤, 캐시데이터도 삭제함.


* value
    - 캐시데이터 저장소안에서 table과 같은 역할.

* key
    - 트랜잭션에서 타는 객체의 키값을 등록.
    - 객체안의 변수로도 설정가능.

<br>

```java
package com.example.spring_cache_test.service;

import com.example.spring_cache_test.dto.MemberDeleteDto;
import com.example.spring_cache_test.dto.MemberDto;
import com.example.spring_cache_test.entity.Member;
import com.example.spring_cache_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberDto memberDto){
        Member newMember = new Member();
        newMember.setUsername(memberDto.getUsername());
        newMember.setAge(memberDto.getAge());
        log.info("회원 서비스");
        memberRepository.save(newMember);
    }
    
    // 회원 조회
    @Transactional(readOnly = true)
    @Cacheable("member")
    public Member findMemberById(Long memberId){
        log.info("회원 레포지토리");
        Optional<Member> memberById = memberRepository.findById(memberId);
        if(!memberById.isPresent()) {
            log.info("해당하는 회원이 없습니다.");
            return null;
        }else{
            log.info("해당하는 멤버는 : {}", memberById);
        }

        return memberById.get();
    }
    
    // 회원 수정
    @CachePut(value = "member", key="#id")
    public Member update(Long id, MemberDto memberDto){
        Member uMember = memberRepository.findById(id).get();
        System.out.println(uMember);
        // 존재 하지 않을때
        if(uMember == null) return uMember;

        log.info("변경!");
        // 존재하는 경우 ->  변경
        uMember.setUsername(memberDto.getUsername());
        uMember.setAge(memberDto.getAge());
        memberRepository.save(uMember);
        return uMember;     // 수정된 객체를 return해야 갱신이 됨.
    }

    // 회원 삭제
    @CacheEvict(value = "member", key="#memberDeleteDto.id")
    public Member deleteMember(MemberDeleteDto memberDeleteDto){
        Member dMember = memberRepository.findById(memberDeleteDto.getId()).get();
        // 존재하지 않는 경우.
        if(dMember == null) return dMember;

        // 존재 ->  삭제
        memberRepository.delete(dMember);
        log.info("service - 정상 삭제됨");
        return dMember;
    }

}

```



<br>
<br>
<br>

### 🐳 repository

<br>

```java
package com.example.spring_cache_test.repository;

import com.example.spring_cache_test.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}

```




<br>
<br>
<br>

### 🐳 application.yml

<br>

```java
server:
  port: 8081

spring:
  datasource:
    url: jdbc:h2:tcp://localhost/~/cache_test
    username: sa
    password:
    driver-class-name: org.h2.Driver

  jpa:
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
#        show_sql: true
        format_sql: true

logging:
  level:
    org.hibernate.SQL: debug



```


