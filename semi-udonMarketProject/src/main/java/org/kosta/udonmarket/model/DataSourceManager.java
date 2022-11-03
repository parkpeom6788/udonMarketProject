package org.kosta.udonmarket.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/*
 	DataSourceManager : DBCP 구현체(Apache-tomcat dbcp)를 표준화된 javax.sql.DataSource Interface 타입으로 생성해서 관리하는 클래스
 	
 	DBCP : DataBase Connection Pool 을 정의하는 객체
 			   DB Connection 을 생성, 소멸하는 방식이 아니라
 			   Pool 에 미리 생성해놓고
 			   빌려주고 반납받는 동작원리로
 			   시스템 성능 향상을 위해 사용하는 객체
 */
public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	
	// 다양한 DBCP 구현체들의 상위 인터페이스 : 어플리케이션과 구체적인 DBCP 구현체와의 결합도를 느슨하게 하기 위해 ( 이후 DBCP 구현체는 바뀔 수도 있기 때문에)
	// Connection Pool 은 매우 다양하게 존재하기 때문에 종속되어서는 안됨
	private DataSource dataSource;
	
	private DataSourceManager() {
		// apache tomcat DBCP 구현체를 이용한다
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@15.164.129.170:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		dataSource.setMaxTotal(30);		// 자신의 환경에 맞게 컨넥션 수를 조정할 수 있다 (default는 8개)
		
		// 인스턴스 변수 DataSource 타입으로 지역변수 BasicDataSource 객체를 참조시킨다
		this.dataSource = dataSource;	// BasicDataSource 가 DataSource 를 implements 하고 있기 때문에 할당이 가능함
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
}





























