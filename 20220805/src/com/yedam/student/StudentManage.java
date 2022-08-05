package com.yedam.student;

import com.yedam.common.DAO;

public class StudentManage extends DAO {
	// 학생 등록
	// 학생 성적입력
	// 학생 정보 수정
	// 학생 정보 조회
	
	private static StudentManage SM = new StudentManage();
	
	private StudentManage() {
			
	}
	
	public static StudentManage getInstance() {
		return SM;
	}

	public int insertStudent(StudentDTO std) {
		int result = 0;
		try {
			
			conn();
			String sql = "insert into student (student id, student name, student class," 
					+" student addr, student tel)"
					+ "values (?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, std.getStudentId());
			pstmt.setString(2, std.getStudentName());
			pstmt.setString(3, std.getStudentClass());
			pstmt.setString(4, std.getStudentAddr());
			pstmt.setString(5, std.getStudentTel());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	//학생 성적 입력(국어)
	public int insertKor(StudentDTO std) {
		int result = 0;
		try {
			conn();
			String sql = "update student set kor = ? where student id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std.getStudentKor());
			pstmt.setInt(2, std.getStudentId());
			
			result = pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	//영어
	public int insertEng(StudentDTO std) {
		int result = 0;
		try {
			conn();
			String sql = "update student set eng = ? where student id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std.getStudentEng());
			pstmt.setInt(2, std.getStudentId());
			
			result = pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	//수학
	public int insertMath(StudentDTO std) {
		int result = 0;
		try {
			conn();
			String sql = "update student set math = ? where student id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std.getStudentKor());
			pstmt.setInt(2, std.getStudentId());
			
			result = pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	public int updateTel(StudentDTO std) {
		int result = 0;
		try {
			conn();
			String sql = "update student set student tel = ? where student id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getStudentTel());
			pstmt.setInt(2, std.getStudentId());
			
			result = pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	public StudentDTO getStudent(int id) {
		StudentDTO std = null;
		try {
			
			conn();
			String sql = "select * from sutdent where student id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				std = new StudentDTO();
				std.setStudentId(rs.getInt("student id"));
				std.setStudentName(rs.getString("student name"));
				std.setStudentName(rs.getString("student tel"));
				std.setStudentName(rs.getString("student addr"));
				std.setStudentName(rs.getString("student class"));
			}
			
		} catch (Exception e) {
		
		} finally {
			disconnect();
		}
		return std;
	}
}
