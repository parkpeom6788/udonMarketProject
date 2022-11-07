package org.kosta.udonmarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class HeartDAO {
	private static HeartDAO instance = new HeartDAO();
	private DataSource dataSource;

	private HeartDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static HeartDAO getInstance() {
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

	public void upHeartCount(String id, long boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update udon_like set heart = heart +1 where board_no = ? and id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2, boardNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}

	}
	
	public void downHeartCount(String id, long boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update udon_like set heart = heart - 1 where board_no = ? and id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2, boardNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
		
	}

	public long totalHeartCount(long boardNo) throws SQLException {
		int totalHeartCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("Select heart_count from udon_like l,udon_market_board b ");
			sql.append("where l.board_no = b.board_no ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next())
				totalHeartCount = rs.getInt(1);
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return totalHeartCount;
		
	}
	
}






















