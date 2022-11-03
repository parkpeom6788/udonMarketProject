package org.kosta.udonmarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MarketBoardDAO {
	private static MarketBoardDAO instance = new MarketBoardDAO();
	private DataSource dataSource;
	private MarketBoardDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static MarketBoardDAO getInstance() {
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
				MarketBoardVO marketBoardVO = new MarketBoardVO();
				marketBoardVO.setBoardNo(rs.getLong("board_no"));
				marketBoardVO.setTitle(rs.getString("title"));
				marketBoardVO.setTimePosted(rs.getString("time_posted"));
				marketBoardVO.setHits(rs.getLong("hits"));
				
				list.add(marketBoardVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
}












