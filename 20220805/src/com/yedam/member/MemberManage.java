package com.yedam.member;

import com.yedam.common.DAO;

//member 관련 sql(database)를 다 작성
public class MemberManage extends DAO {

	// 싱글톤
	private static MemberManage mm = null;

	// 생성자 생성 막기
	private MemberManage() {

	}

	public static MemberManage getInstance() {
		if (mm == null) {
			mm = new MemberManage();
			return mm;
		} else {
			return mm;
		}
	}

	public MemberDTO login(MemberDTO member) {
		MemberDTO mem = null;
		try {
			// 1. DB연결
			conn();
			// 2. sql 작성
			String sql = "select * from member WHERE member_id = ? "
					+ "AND member_pw = ?";
			// 3. 창구 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				mem = new MemberDTO();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberPw(rs.getString("member_name"));
				mem.setMemberPw(rs.getString("member_belong"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mem;
	}
}