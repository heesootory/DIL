package com.ssafy.ws.step2;

import java.io.Serializable;

// 객체 직렬화 가능하도록 Serializable 인터페이스를 구현한다.
public class Movie implements Serializable {
	// 임의의 고유 정수값
	private int id;
	// 제목
	private String title;
	// 감독
	private String director;
	// 장르
	private String genre;
	// 상영 시간
	private int runningTime;

	// 기본 생성자
	public Movie() {
	}

	// 필드 값을 인자로 받는 생성자를 선언한다.
	public Movie(int id, String title, String director, String genre, int runningTime) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	/**
	 * 고유 id를 반환한다.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 아이디를 저장한다.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 영화 제목을 반환한다.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 영화 제목을 저장한다.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 감독을 반환한다.
	 * 
	 * @return director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * 감독을 저장한다.
	 * 
	 * @param director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * 영화 장르를 반환한다.
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * 영화 장르를 저장한다.
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * 상영 시간을 반환한다.
	 * 
	 * @return runningTime
	 */
	public int getRunningTime() {
		return runningTime;
	}

	/**
	 * 상영 시간을 저장한다.
	 * 
	 * @param runningTime
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "Movie [영화id = " + id + ", 영화 제목 = " + title + ", 감독 = " + director + ", 장르 = " + genre + ", 상영시간 = "
				+ runningTime + "]";
	}
	
}
