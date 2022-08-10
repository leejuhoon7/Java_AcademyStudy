package BookInformation;

import java.util.Scanner;

import common.DAO;

public class BookDataDAO extends DAO {

	private static BookDataDAO bdd = null;
	Scanner sc = new Scanner(System.in);
	
	private BookDataDAO() {
		
	}
	
	public static BookDataDAO getInstance() {
		
		return bdd == null ? new BookDataDAO() : bdd;
	}
	
	
	// 4. 도서 대출
	
	public int lendBook(BookData bd) {
		int result = 0;
		
		try {
			
			conn();
			String sql = "update bookinformation set booklend where booknumber";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bd.getBookLend());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return 0;
	}
	
	// 5. 도서 반납

	public int returnBook(BookData bd) {
		int result = 0;
		
		try {
			
			conn();
			String sql = "update bookinformation set bookreturn where booknumber";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bd.getBookReturn());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return 0;
	}
	
	// 6. 도서 연체
	
	
	public int delayBook(BookData bd) {
		int result = 0;
		
		try {
			
			conn();
			String sql = "update bookinformation set bookdelay where booknumber";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bd.getBookDelay());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return 0;
	}
}
