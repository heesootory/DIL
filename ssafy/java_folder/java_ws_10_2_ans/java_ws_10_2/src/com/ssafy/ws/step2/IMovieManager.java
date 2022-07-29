package com.ssafy.ws.step2;

public interface IMovieManager {
	//메서드는 기본적으로 public abstract가 제어자로 붙는다.(생략됨)
	
	/**
	 * 영화를 영화리스트에 추가한다.
	 * @param movie : 추가할 영화 정보
	 */
	void add(Movie movie);
	
	/**
	 * 등록된 영화리스트를 반환한다.
	 * @return 등록된 전체 영화 리스트
	 */
	Movie[] getList();
	
	/**
	 * 도서 제목을 포함하고 있는 영화 리스트를 반환한다.
	 * @param title : 조회할 영화의 제목
	 * @return 제목을 포함한 영화 리스트
	 * @throws TitleNotFoundException 
	 */
	Movie[] searchByTitle(String title) throws TitleNotFoundException;
	
	/**
	 * 등록된 영화중에 일반영화만 반환한다.
	 * @return 등록된 전체 일반 영화 리스트
	 */
	Movie[] getMovies();
	
	/**
	 * 등록된 영화중에 시리즈영화만 반환한다.
	 * @return 등록된 전체 시리즈 영화 리스트
	 */
	SeriesMovie[] getSeriesMovies();
	
	/**
	 * 영화 상영시간의 평균을 반환한다.
	 * @return 모든 영화 상영시간의 평균
	 */
	double getRunningTimeAvg();
	
	/**
	 * 영화 리스트를 파일에 저장한다.
	 */
	void saveData();
}
