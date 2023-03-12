# annotation 종류




## @builder

* 생성자를 들어오는 input에 맞게 알아서 만들어주는 빌드 어노테이션.


<br>
<br>


## @RequiredArgsConstructor

* 이 어노테이션은 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성함.

* 주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용됨.

* @ConstructorProperties어노테이션을 사용해서, final이나 @NonNull 변수들로 구성된 생성자를 자동으로 생성하므로, @Autowired없이 의존성 주입이 이루어짐.

<br>
<br>

## @postConstruct

* 호출시기  
    - 생성자 호출
    - 의존성 주입 완료 (@Autowired | @RequiredArgsConstructor )
    - @postConstruct

* 사용 이유
    - bean lifeCycle 에서 오직 한 번만 수행됨.(여러번 초기화 방지)
    - WAS 가 뜬 이후로 딱 한번만 수행됨.

<Br>
<Br>

## @PreDestroy

* 사용 이유
    - spring 어플리케이션 컨텍스트에서 bean 을 제거하기 직전에 단 한 번만 수행됨.






