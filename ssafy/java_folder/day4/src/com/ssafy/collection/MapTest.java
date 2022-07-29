package com.ssafy.collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		//List가 index로 데이터를 식별했다면
		//Map은 Key 값으로 데이터를 식별한다.
		
		Map<String, String> map = new HashMap<>();
		
		map.put("654", "안태윤");
		map.put("970", "김형균");
		map.put("234", "김인중");
		
		System.out.println(map);
		//키를 이용해서 값을 가지고 올수 있다.
		System.out.println(map.get("654"));
		//없는 키를 가져오려고 한다면 null이 나온다.
		System.out.println(map.get("111"));
		//해당 키가 있는지 없는지 검사를 해준다.
		System.out.println(map.containsKey("234"));
		
		map.put("234", "이해건");
		
		System.out.println(map);
		
	}
}
