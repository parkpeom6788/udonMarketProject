package org.kosta.udonmarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MarketDAO {
	private static MarketDAO instance = new MarketDAO();
	private DataSource dataSource;
	private MarketDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static MarketDAO getInstance() {
		return instance;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public ArrayList<MarketVO> findMarketAllList() throws SQLException {
		ArrayList<MarketVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT market_name, info FROM udon_market";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setMarketName(rs.getString(1));
				marketVO.setInfo(rs.getString(2));
				list.add(marketVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	public ArrayList<MarketVO> findMarketListSortByItem(String item) throws SQLException {
		ArrayList<MarketVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT market_name, info FROM udon_market WHERE item=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setMarketName(rs.getString(1));
				marketVO.setInfo(rs.getString(2));
				list.add(marketVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public ArrayList<MarketVO> findMarketListByName(String searchInfo) throws SQLException {
		ArrayList<MarketVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT market_name, info FROM udon_market WHERE market_name LIKE '%'||"+"?"+"||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchInfo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setMarketName(rs.getString(1));
				marketVO.setInfo(rs.getString(2));
				list.add(marketVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}






































