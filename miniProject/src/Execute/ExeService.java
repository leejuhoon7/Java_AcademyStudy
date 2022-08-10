package Execute;

import java.util.Scanner;

import book.BookService;
import loginManage.loginService;

public class ExeService {

	Scanner sc = new Scanner(System.in);

	BookService bs = new BookService();
	loginService ls = new loginService();

	int menuNo;
	boolean isTrue = true;

	public ExeService() {
		login();
		run();
	}

	// 로그인
	private void login() {
		System.out.println("1.로그인 2.종료");

		menuNo = Integer.parseInt(sc.nextLine());

		switch (menuNo) {
		case 1:
			ls.doLogin();
			if (loginService.memberInfo != null) {
				new loginService();
			}
			break;
		case 2:
			break;
		}
	}

	private void run() {
		while (isTrue) {
			System.out.println("|1|고객 등록 |2|도서 등록 |3|도서 정보수정 |4|도서 대출 |5|도서 반납" + " |6|도서 연체 |7|도서 검색 |8|도서 삭제 |9|종료");
			menuNo = Integer.parseInt(sc.nextLine());
			if (menuNo == 1) {
				bs.registration();
			} else if (menuNo == 2) {
				bs.registrationBook();
			} else if (menuNo == 3) {
				bs.updateBook();
			} else if (menuNo == 4) {

			} else if (menuNo == 5) {

			} else if (menuNo == 6) {

			} else if (menuNo == 7) {
				bs.searchBook();
			} else if (menuNo == 8) {
				bs.delBook();
			} else if (menuNo == 9) {
				System.out.println("종료");
				isTrue = false;
			}
		}

	}

}
