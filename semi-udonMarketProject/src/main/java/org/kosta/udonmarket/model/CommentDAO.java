package org.kosta.udonmarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class CommentDAO {
	private static CommentDAO instance = new CommentDAO();
	private DataSource dataSource;
	private CommentDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static CommentDAO getInstance() {
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
	
	public ArrayList<CommentVO> findCommentList(long boardNo) throws SQLException {
		ArrayList<CommentVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, comment_content, TO_CHAR(comment_time_posted, 'YYYY.MM.DD. HH24:MI') AS comment_time_posted, board_no ");
			sql.append("FROM udon_comment ");
			sql.append("WHERE board_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentVO commentVO = new CommentVO();
				commentVO.setId(rs.getString("id"));
				commentVO.setCommentContent(rs.getString("comment_content"));
				commentVO.setCommentTimePosted(rs.getString("comment_time_posted"));
				commentVO.setBoardNo(rs.getLong("board_no"));
				list.add(commentVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}























