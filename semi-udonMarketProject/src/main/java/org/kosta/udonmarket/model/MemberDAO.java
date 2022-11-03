package org.kosta.udonmarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DataSource dataSource;
	private MemberDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance() {
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

	public void registerMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into udon_member (id,password,name,member_no,address,tel,member_type) ");
			sql.append("values (?,?,?,?,?,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getMemberNo());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getTel());
			pstmt.setInt(7, vo.getMemberType());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public boolean checkId(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT count(*) from udon_member where id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				result = true;
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}
	
	public MemberVO login(String id, String password) throws SQLException {
		MemberVO memberVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder("SELECT member_type,name,member_no,address,tel ");
			sql.append("FROM udon_member WHERE id=? and password=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memberVO=new MemberVO(id, password, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return memberVO;
	}
	public boolean updateMemberType(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "update udon_member set member_type = member_type + 1 where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
		return false;
		
	}
}













