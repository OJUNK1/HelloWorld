package co.yedam.boardpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO implements BoardService {

	Connection conn = null; // DB연결 세션
	PreparedStatement psmt;
	ResultSet rs;

	void getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle 드라이버가 없습니다.");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "1234";
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("DB 연결!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconn() {
		try {
			if (conn != null)
				conn.close();

			if (psmt != null)
				psmt.close();

			if (rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String id, String pw) {

		return false;
	}

	@Override
	public boolean addBoard(Board board) {
		String sql = "insert into boards values( ?, ?, ?, ?, ?)";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBrdNo());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.setString(4, board.getWriter());
			psmt.setString(5, board.getWriteDate());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean editBoard(Board board) {
		String sql = "update boards set board_no = ?, title = ?, content = ?, writer = ?, write_date= ?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBrdNo());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.setString(4, board.getWriter());
			psmt.setString(5, board.getWriteDate());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean delBoard(int brdNo) {
		String sql = "delete boards where board_no = ?";
		getConn();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNo);
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public List<Board> boardList() {
		String sql = "select * from boards order by board_no";
		getConn();
		List<Board> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board boards = new Board();
				boards.setBrdNo(rs.getInt("board_no"));
				boards.setTitle(rs.getString("title"));
				boards.setContent(rs.getString("content"));
				boards.setWriter(rs.getString("writer"));
				boards.setWriteDate(rs.getString("write_date"));

				list.add(boards);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return null;
	}

	@Override
	public boolean modInfo(User user) {
		return false;
	}

	@Override
	public void saveToFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		saveToFile();

	}

}
