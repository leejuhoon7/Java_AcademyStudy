package BookInformation;

import java.util.Scanner;

public class BookDataService {

	Scanner sc = new Scanner(System.in);
	

	
	// 4. 도서 대출, 반납

	public void lendBook() {
		
		System.out.println("빌려갈 책 이름: ");
		String lendbook = sc.nextLine();
		
		int result = BookDataDAO.getInstance().lendBook(lendbook);
		if(result == 1) {
			System.out.println("빌려감!");
		}else {
			System.out.println("빌리기 실패!");
		}

	}
	public void returnBook() {
		
		System.out.println("반납할 책 이름: ");
		String lendbook = sc.nextLine();
		
		int result = BookDataDAO.getInstance().returnBook(lendbook);
		if(result == 1) {
			System.out.println("반납함!");
		}else {
			System.out.println("반납 실패!");
		}
	}
	
}
