package org.kosta.udonmarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
