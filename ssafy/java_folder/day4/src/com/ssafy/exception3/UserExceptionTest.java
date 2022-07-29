package com.ssafy.exception3;

public class UserExceptionTest {
	private static String[] fruits = { "딸기", "당근", "수박", "참외", "멜론" };

	public static void main(String[] args) {
		boolean result = getFruit1("딸기");		//true
		if(!result) {		//X
			System.out.println("딸기가 없없습니다.");
		}		
		result = getFruit1("딸기");		//false
		if(!result) {		//성립
			System.out.println("딸기가 먹었쥥....");
		}
		//당근 소비해보자.
		
		try {
			getFruit2("당근");
			System.out.println("당근을 먹었다.");
			getFruit2("당근");
		} catch (FruitNotFoundException e) {
			e.printStackTrace();
			System.out.println("당근을 못먹었다.");
		}
		
		
	}

	// name 과일이 있다면 true를 반환하고 해당 위치의 과일을 null
	public static boolean getFruit1(String name) {
		for(int i = 0 ; i<fruits.length; i++) {
			if(fruits[i] != null && fruits[i].equals(name)) {
				fruits[i] = null;
				return true;
			}
		}
		return false;
	}
	//예외를 만들어서 발생시켜보자.
	public static void getFruit2(String name) throws FruitNotFoundException {
		for(int i = 0 ; i<fruits.length; i++) {
			if(fruits[i] != null && fruits[i].equals(name)) {
				fruits[i] = null;
				return;
			}
		}
		throw new FruitNotFoundException(name);
	}

	//배열에 null인 지점에 과일을 저장하도록 작성하시구요. 없으면 NoSpaceException 작성해보세요.
	public static void setFruit(String name) {
		//웹엑스 시간에 해결해 보세용~~
	}
}
