package com.yedam.App;

import java.util.Scanner;

import com.yedam.member.MemberDTO;
import com.yedam.member.MemberService;
import com.yedam.student.StudentDTO;
import com.yedam.student.StudentService;

public class LMSApp {

	MemberService ms = new MemberService();
	StudentService ss = new StudentService();

	Scanner sc = new Scanner(System.in);
	int menu = 0;

	MemberDTO MD = null;

	public LMSApp() {
		run();
	}

	private void run() {
		while (true) {
			menuNo();
			if (MD == null) {

				if (menu == 1) {
					MemberDTO member = new MemberDTO();
					System.out.println("아이디 입력: ");
					String id = sc.nextLine();
					System.out.println("비밀번호 입력: ");
					String pw = sc.nextLine();

					member.setMemberId(id);
					member.setMemberPw(pw);

					MD = ms.doLogin(member);
				} else if (menu == 2) {
					System.out.println("프로그램 종료");
					break;
				}
			} else {
				//학생 등록
				if (menu == 1) { //id, name, class, addr, tel
					
					StudentDTO std = new StudentDTO();
					System.out.println("ID 입력: ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.println("이름 입력: ");
					String name = sc.nextLine();
					System.out.println("강의실 입력: ");
					String lecture = sc.nextLine();
					System.out.println("주소 입력: ");
					String addr = sc.nextLine();
					System.out.println("전화번호 입력: ");
					String tel = sc.nextLine();
					
					std.setStudentId(id);
					std.setStudentName(name);
					std.setStudentClass(lecture);
					std.setStudentAddr(addr);
					std.setStudentTel(tel);
					//std set 넣을거
					ss.insertStudent(std); //ss 객체?
					
					//학생 성적 입력
				} else if (menu == 2) {
					StudentDTO std = new StudentDTO();
					System.out.println("ID 입력: ");
					int id = Integer.parseInt(sc.nextLine());
					
					std.setStudentId(id);
					if(std != null) {
						ss.insertSubject(std); //??
					}
					//학생 정보 수정
				} else if (menu == 3) {
					ss.updateTel();
					//학생 정보 조회
				} else if (menu == 4) {
					StudentDTO std = new StudentDTO();
					
					System.out.println("ID 입력: ");
					int id = Integer.parseInt(sc.nextLine());
					
					std.setStudentId(id);
					std = ss.getStudent(std);
					System.out.println(std.toString());
					
				}

			}
		}
	}

	private void menuNo() {
		if (MD == null) {

			System.out.println("1.로그인 | 2.종료");
			System.out.println("입력: ");
			menu = Integer.parseInt(sc.nextLine());
		} else {
			System.out.println("1.학생등록 | 2. 학생 성적 입력 | 3. 학생 정보 수정 | 4. 학생정보 조회");
			menu = Integer.parseInt(sc.nextLine());

		}
	}
}
