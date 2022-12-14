package com.ssafy.json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

class Message {
	private String sendId;
	private String recvId;

	public Message(String sendId, String recvId) {
		this.sendId = sendId;
		this.recvId = recvId;
	}

	@Override
	public String toString() {
		return "Message [sendId=" + sendId + ", recvId=" + recvId + "]";
	}
	

}

public class Test {
	// 라이브러리를 인식시키기.
	// 방법 1. JRE System Library 에 끼워 넣기
	// 방법 2. 외부에 존재하는 jar 파일을 인식시켜주기. //프로젝트 이사시 인식 안될지도..)
	// 방법 3. 프로젝트 내부에 jar 파일을 복사를 해두고 인식시키기. (우리가 하려고 하는것)
	// 방법 4. Maven을 이용하여 넣기
	public static void main(String[] args) {
		Message msg = new Message("Kim", "Lee");
		
		Gson gson = new Gson();
		//객체 -> JSON 문자열
		String jsonMsg = gson.toJson(msg);
		System.out.println(jsonMsg);
		//JSON 문자열 -> 객체
		Message msg2 = gson.fromJson(jsonMsg, Message.class);
		System.out.println(msg2);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", "heng2926");
		map.put("age", 65);
		//map -> JSON 문자열
		String jsonMap = gson.toJson(map);
		System.out.println(jsonMap);
		
		//JSON 문자열 -> map
		Map<String, Object> map2 = gson.fromJson(jsonMap, Map.class);
		System.out.println(map2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
