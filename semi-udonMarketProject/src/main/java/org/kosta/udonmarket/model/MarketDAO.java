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

	public void registerMarket(MarketVO marketVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO udon_market(id,market_name,market_address,market_tel,item,info,market_no) VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, marketVO.getId());
			pstmt.setString(2, marketVO.getMarketName());
			pstmt.setString(3, marketVO.getMarketAddress());
			pstmt.setString(4, marketVO.getMarketTel());
			pstmt.setString(5, marketVO.getInfo());
			pstmt.setString(6, marketVO.getItem());
			pstmt.setString(7, marketVO.getMarketNo());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public ArrayList<MarketVO> findMarketAllList() throws SQLException {
		ArrayList<MarketVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id, market_name, info FROM udon_market";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setId(rs.getString(1));
				marketVO.setMarketName(rs.getString(2));
				marketVO.setInfo(rs.getString(3));
				list.add(marketVO);
			}
		} finally {
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
			String sql = "SELECT id, market_name, info FROM udon_market WHERE item=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setId(rs.getString(1));
				marketVO.setMarketName(rs.getString(2));
				marketVO.setInfo(rs.getString(3));
				list.add(marketVO);
			}
		} finally {
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
			String sql = "SELECT id, market_name, info FROM udon_market WHERE market_name LIKE '%'||"+"?"+"||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchInfo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setId(rs.getString(1));
				marketVO.setMarketName(rs.getString(2));
				marketVO.setInfo(rs.getString(3));
				list.add(marketVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}

		return list;
	}
	
	public MarketVO findMarketInfo(String id) throws SQLException {
		MarketVO marketVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT market_name, market_address, market_tel, item, info, market_no FROM udon_market WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				marketVO = new MarketVO();
				marketVO.setMarketName(rs.getString("market_name"));
				marketVO.setMarketAddress(rs.getString("market_address"));
				marketVO.setMarketTel(rs.getString("market_tel"));
				marketVO.setItem(rs.getString("item"));
				marketVO.setInfo(rs.getString("info"));
				marketVO.setMarketNo(rs.getString("market_no"));
			}

		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return marketVO;
	}

	public boolean checkMarketNo(String marketNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = dataSource.getConnection();
			String sql = "Select count(*) from udon_market where market_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, marketNo);
			rs = pstmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				result = true;
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
	
}
