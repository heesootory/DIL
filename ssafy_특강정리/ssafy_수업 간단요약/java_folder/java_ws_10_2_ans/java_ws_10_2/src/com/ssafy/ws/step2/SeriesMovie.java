package com.ssafy.ws.step2;

public class SeriesMovie extends Movie {

	// 해당 시리즈 영화가 시리즈 중 몇번째 인지
	private int seriesNum;

	// 해당 시리즈 영화의 부제목
	private String episode;

	// 기본 생성자
	public SeriesMovie() {
	}
	
	// 영화 정보 모두를 받아 생성하는 생성자
	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum,
			String episode) {
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
	}
	/**
	 * 시리즈 번호를 반환한다.
	 * @return seriesNum
	 */
	public int getSeriesNum() {
		return seriesNum;
	}
	/**
	 * 시리즈 번호를 저장한다.
	 * @param seriesNum
	 */
	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}
	/**
	 * 영화 에피소드를 반환한다.
	 * @return episode
	 */
	public String getEpisode() {
		return episode;
	}
	/**
	 * 영화 에피소드를 저장한다.
	 * @param episode
	 */
	public void setEpisode(String episode) {
		this.episode = episode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" 시리즈 번호 = " + this.seriesNum);
		sb.append(" 시리즈 부제목 = " + this.episode);
		return sb.toString();
	}

}
