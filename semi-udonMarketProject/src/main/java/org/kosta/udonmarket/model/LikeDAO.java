package org.kosta.udonmarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class LikeDAO {
	private static LikeDAO instance = new LikeDAO();
	private DataSource dataSource;
	private LikeDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static LikeDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}
	
	// 좋아요 했는지 확인 -> boolean
	public boolean select(String id,Long board_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = dataSource.getConnection();
			String sql = "select id , board_no from udon_like where id = ? and  board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2,board_no);
			
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				// 있으면 true 
				flag = true;
			}
		} finally {
			closeAll(pstmt, con);
		}
		return flag;
	}
	// 좋아요 추가
	public void insert(String id,Long board_no) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO udon_like(id,board_no) VALUES(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2,board_no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	// 좋아요 삭제
	public void delete(String id,Long board_no) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from udon_like where id = ? and board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2,board_no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	// 좋아요 개수 조회
	public int count(Long board_no) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from udon_like where board_no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,board_no );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			closeAll(pstmt, con);
		}
		return count;
	}
}
