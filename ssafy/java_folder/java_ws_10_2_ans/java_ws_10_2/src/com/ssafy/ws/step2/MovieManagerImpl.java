package com.ssafy.ws.step2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class MovieManagerImpl implements IMovieManager {
	
	/**
	 * 관리할 영화 리스트
	 */
	private List<Movie> movieList = new ArrayList<Movie>();
	
	/**
	 * 싱글톤 디자인패턴을 위해 유지하는 객체 참조
	 * 클래스가 메모리에 로드될 때 객체를 1번만 생성하여 참조을 유지한다.
	 */
	private static IMovieManager instance = new MovieManagerImpl();

	/**
	 * 기본 생성자
	 * 저장된 Data가 있으면 불러온다.
	 */
	private MovieManagerImpl() {// 외부에서 객체생성을 하지 못하도록 생성자를 private 제어자로 선언
		loadData();
	}

	/**
	 * 내부에서 생성한 객체의 참조를 반환한다.
	 * @return 생성된 객체의 참조
	 */
	public static IMovieManager getInstance() {
		return instance;
	}

	/**
	 * 영화를 영화리스트에 추가한다.
	 * @param movie : 추가할 영화 정보
	 */
	public void add(Movie m) {
		movieList.add(m);
	}

	/**
	 * 등록된 영화리스트를 반환한다.
	 * @return 등록된 전체 영화리스트
	 */
	public Movie[] getList() {
		Movie[] result = new Movie[movieList.size()];
		return movieList.toArray(result);
	}

	/**
	 * 등록된 영화중에 일반영화만 반환한다.
	 * @return 등록된 전체 일반 영화리스트
	 */
	public Movie[] getMovies() {

		ArrayList<Movie> temp_list = new ArrayList<Movie>();

		for (Movie movie : movieList) {
			if (!(movie instanceof SeriesMovie)) {
				temp_list.add(movie);
			}
		}

		Movie[] result = new Movie[temp_list.size()];
		return temp_list.toArray(result);
	}

	/**
	 * 등록된 영화중에 시리즈영화만 반환한다.
	 * @return 등록된 전체 시리즈 영화리스트
	 */
	public SeriesMovie[] getSeriesMovies() {

		ArrayList<SeriesMovie> temp_list = new ArrayList<SeriesMovie>();

		for (Movie movie : movieList) {
			if (movie instanceof SeriesMovie) {
				temp_list.add((SeriesMovie) movie);
			}
		}

		SeriesMovie[] result = new SeriesMovie[temp_list.size()];
		return temp_list.toArray(result);
	}

	/**
	 * 도서 제목을 포함하고 있는 영화 리스트를 반환한다.
	 * @param title : 조회할 영화의 제목
	 * @return 제목을 포함한 영화리스트
	 */
	public Movie[] searchByTitle(String title) throws TitleNotFoundException {

		ArrayList<Movie> temp_list = new ArrayList<Movie>();

		for (Movie movie : movieList) {
			if (movie.getTitle().contains(title)) {
				temp_list.add(movie);
			}
		}
		if(temp_list.size() == 0) {
			throw new TitleNotFoundException(title);
		}

		Movie[] result = new Movie[temp_list.size()];
		return temp_list.toArray(result);
	}

	/**
	 * 영화 상영시간의 평균을 반환한다.
	 * @return 모든 영화 상영시간의 평균
	 */
	public double getRunningTimeAvg() {
		int total = 0;
		for (Movie movie : movieList) {
			total += movie.getRunningTime();
		}
		return (double) total / movieList.size();
	}
	
	/**
	 * 파일에서 영화리스트를 로드한다.
	 */
	private void loadData() {
		File file = new File("movie.dat");
		if(file.exists()) { // 파일이 존재하면 파일에서 데이터 읽기
			// 파일에서 읽어오기 위해 FileInputStream을 생성 후 저장된 영화리스트 객체를 읽어오기 위해 ObjectInputStream을 생성한다.
			// try with resources 방식
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
				movieList = (ArrayList<Movie>) ois.readObject(); // 영화리스트 객체를 파일에서 읽어오기
			} catch(Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 파일에 영화리스트를 저장한다.
	 */
	@Override
	public void saveData() {
		// 파일에 저장하기 위해 FileOutputStream을 생성 후 영화리스트 객체를 저장하기 위해 ObjectOutputStream을 생성한다.
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat"))){
			oos.writeObject(movieList); // 영화리스트 객체를 파일에 저장하기
		} catch(Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}

}
