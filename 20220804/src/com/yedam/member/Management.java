package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class Management extends DAO {

	//싱글톤
	
	public Management() {
		//전체 조회
		showInfo();
		//한건 조회
		getMember();
		//한건 입력
//		insertInfo();
//		updateInfo();
		
		deleteInfo();
	}
		//삭제
	private void deleteInfo() {
		int result = 0;
		try {
			conn();
			String sql = "delete from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "A");
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		if(result == 1) {
			System.out.println(result + "건이 삭제 되었습니다.");
		}else {
			System.out.println("삭제 되지 않았습니다.");
		}
		
	}
	
	

	// 수정
	private void updateInfo() {

		int result = 0;
		try {
			// 1. DB 연결
			conn();
			// 2. query 작성
			String sql = "update member set pw=? where id =?";
			// 3. 창구 및 query 생성
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 입력
			pstmt.setString(1, "4321");
			pstmt.setString(2, "B");
			// 5. 실행
			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			disconnect();
		}

		if (result == 1) {
			System.out.println(result + "건이 수정되었습니다.");
		} else {
			System.out.println("수정되지 않았습니다.");
		}
	}

	private void insertInfo() {

		int result = 0;
		try {
			// 1. db연결
			conn();
			// 2. query 작성
			String sql = "insert into member values(?,?,?)";
			// 3. 창구 생성
			pstmt = conn.prepareStatement(sql);
			// 4. query 데이터 입력
			pstmt.setString(1, "S");
			pstmt.setString(2, "9999");
			pstmt.setString(3, "박씨");
			// DML (insert. update, delete -> excuteUpdate()
			// Select -> executeQuery();
			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			disconnect();
		}

		if (result == 1) {
			System.out.println("정상 입력되었습니다.");
		} else {
			System.out.println("입력에 실패하였습니다.");
		}
	}

	private void getMember() {
		Member member = null;
		try {
			conn();

			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "A");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getNString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("pw"));
			}

		} catch (Exception e) {

		} finally {
			disconnect();
		}
		System.out.println("***********************");
		System.out.println(member.toString());
	}

	private void showInfo() {
		List<Member> list = new ArrayList<>();
		Member mem = null;

		try {
			// 1. conn() 메소드로 DB 연결
			conn();
			// 2. query 작성
			String sql = "select * from member";
			// 3. 연결된 DB에 query문 보낼 수 있는 창구 생성
			stmt = conn.createStatement();
			// 4. 3번에서 만든 창구로 query문을 보냄
			// ResultSet(rs) select 조회할떄만 사용
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				mem = new Member();
				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setPw(rs.getString("pw"));
				list.add(mem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		for (Member member : list) {
			System.out.println(member.toString());
		}
	}
}
