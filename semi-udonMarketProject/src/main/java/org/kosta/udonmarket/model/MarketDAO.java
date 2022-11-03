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
	
	public void registerMarket(MarketVO marketVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		MemberVO memberVO=new MemberVO();
		try {
			con=dataSource.getConnection();
			String sql="INSERT INTO udon_market(id,market_name,market_address,market_tel,item,info,market_no) VALUES(?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
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
	
	public ArrayList<MarketBoardVO> findBoardList() throws SQLException {
		ArrayList<MarketBoardVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b.board_no, b.title, TO_CHAR(b.time_posted,'YYYY/MM/DD') AS time_posted, b.hits, m.id, m.market_name, m.market_address, m.market_tel, m.info, m.item, m.market_no ");
			sql.append("FROM udon_market_board b ");
			sql.append("INNER JOIN udon_market m ON b.id = m.id ");
			sql.append("ORDER BY b.board_no DESC");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setId(rs.getString("id"));
				marketVO.setMarketName(rs.getString("market_name"));
				marketVO.setMarketAddress(rs.getString("market_address"));
				marketVO.setMarketTel(rs.getString("market_tel"));
				marketVO.setInfo(rs.getString("info"));
				marketVO.setItem(rs.getString("item"));
				marketVO.setMarketNo(rs.getString("market_no"));
				
				MarketBoardVO marketBoardVO = new MarketBoardVO();
				marketBoardVO.setBoardNo(rs.getLong("board_no"));
				marketBoardVO.setTitle(rs.getString("title"));
				marketBoardVO.setTimePosted(rs.getString("time_posted"));
				marketBoardVO.setHits(rs.getLong("hits"));
				marketBoardVO.setMarketVO(marketVO);
				
				list.add(marketBoardVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
}


























































