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
	
	// 게시글 수정 - 찾기 조회 findMarketBoardByBoardNo(no);
	public MarketBoardVO findMarketBoardByBoardNo(long no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MarketBoardVO marketBoardVO = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" select b.board_no , b.title , b.content,b.image_name, to_char(b.time_posted,'yyyy.MM.DD HH24.MI:SS') as time_posted  , b.hits , m.id ");
			sb.append(" from udon_market_board b , udon_market m  ");
			sb.append(" where b.id = m.id and b.board_no = ? ");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setId(rs.getString("id"));
				marketBoardVO= new MarketBoardVO(rs.getLong("board_no"),rs.getString("title"),rs.getString("content"),rs.getString("image_name"),rs.getString("time_posted"),rs.getLong("hits") , marketVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return marketBoardVO;
	}
	// 글쓰기 페이지
	public void posting(String title, String content, String imageName, String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "insert into udon_market_board(board_no,title,content,image_name,time_posted,id) values(undon_market_board_seq.nextval,?,?,?,SYSDATE,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, imageName);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	// 조회수
	public void hit(long no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = this.dataSource.getConnection();
			String query = "update udon_market_board set hits = hits + 1 where board_no = ? ";
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	// 글 상세 페이지
	public MarketBoardVO boardDetail(long no) throws SQLException {
		MarketBoardVO marketBoardVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = this.dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(
					"select b.board_no,b.title,b.content,b.image_name,to_char(b.time_posted,'YYYY.MM.DD HH24.MI.SS') as time_posted , b.hits , m.id  ");
			sb.append(" from  udon_market_board b inner join  udon_market m on  b.id = m.id  where  ");
			sb.append(" b.board_no = ? ");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				MarketVO marketVO = new MarketVO();
				marketVO.setId("java4");
				marketBoardVO = new MarketBoardVO(rs.getLong("board_no"), rs.getString("title"),
						rs.getString("content"),rs.getString("image_name") ,rs.getString("time_posted"), rs.getLong("hits"), marketVO);
			  }
		} finally {
			closeAll(rs, pstmt, con);
		}
		return marketBoardVO;
	}
	// 게시물 리스트 출력
	public ArrayList<MarketBoardVO> findBoardList(String id, Pagination pagination) throws SQLException {
		ArrayList<MarketBoardVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT board_no, title, time_posted, hits ");
			sql.append("FROM( ");
			sql.append("SELECT ROW_NUMBER() OVER(ORDER BY board_no DESC) AS rnum, board_no, title, TO_CHAR(time_posted,'YYYY/MM/DD') AS time_posted,hits ,id ");
			sql.append("FROM udon_market_board ");
			sql.append("WHERE id=? ");
			sql.append(") ");
			sql.append("WHERE rnum BETWEEN ? AND ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setInt(2, pagination.getStartRowNumber());
			pstmt.setInt(3, pagination.getEndRowNumber());
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
	// 게시글 삭제
	public void deleteMarket(Long marketNo ) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "delete from udon_market_board where board_no = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, marketNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	// 게시글 수정
	public void updateMarket(String title,String content,long board_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = " update udon_market_board set title = ? , content = ? where board_no = ? ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content );
			pstmt.setLong(3, board_no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt,con);
		}
	}
	
	// 좋아요  조인 3개 . MemberVO의  id 와 udon_market_board의  board_no 
	public void bGood(int idx) {
		
	}

	public int getTotalPostCount(String id) throws SQLException {
		int totalPostCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM udon_market_board WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
				totalPostCount = rs.getInt(1);
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return totalPostCount;
	}
}












