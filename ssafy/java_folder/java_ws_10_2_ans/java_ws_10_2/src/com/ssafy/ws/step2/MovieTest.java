package com.ssafy.ws.step2;

public class MovieTest {

	public static void main(String[] args) {
		
		IMovieManager mm = MovieManagerImpl.getInstance();
		
//		System.out.println("===========반지 라는 단어를 포함한 영화리스트 찾아서 반환===========");
		try {
			for(Movie movie : mm.searchByTitle("해리")) {
				System.out.println(movie.toString());
			}
		} catch (TitleNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//영화 정보 추가하기
//		Movie m = new Movie(0, "기생충", "봉준호", "스릴러", 131);
//		Movie m2 = new Movie(1, "이터널스", "클로이 자오", "액션", 156);
//		Movie m3 = new Movie(4, "트랜스포터", "원규" , "액션" , 92);
//		SeriesMovie sm = new SeriesMovie(2, "해리포터", "크리스 콜럼버스", "판타지", 152, 1, "마법사의 돌" );
//		SeriesMovie sm2 = new SeriesMovie(3, "해리포터", "크리스 콜럼버스", "판타지", 162, 2, "비밀의 방" );
//		
//		mm.add(m);
//		mm.add(m2);
//		mm.add(m3);
//		mm.add(sm);
//		mm.add(sm2);
//		
////		MovieManager 객체를 이용해 영화정보를 수정해보고 saveData 메소드 실행
//		mm.saveData();
		
	}
}
