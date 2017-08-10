package cn.icat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.icat.model.PageBean;
import cn.icat.model.Student;
import cn.icat.util.StringUtil;

public class StudentDao {

	public ResultSet studentList(Connection con, PageBean pageBean, Student student, String bbirthday, String ebirthday) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_student s, t_grade g where s.gradeId=g.id");
		
		if (StringUtil.isNotEmpty(student.getStuNo())) {
			sb.append(" and s.stuNo like '%"+ student.getStuNo() +"%'");
		}
		if (StringUtil.isNotEmpty(student.getStuName())) {
			sb.append(" and s.stuName like '%"+ student.getStuName() +"%'");
		}
		if (StringUtil.isNotEmpty(student.getSex())) {
			sb.append(" and s.sex = '" + student.getSex() +"'");
		}
		//不传值，默认-1
		if (student.getGradeId() != -1) {
			sb.append(" and s.gradeId = '"+ student.getGradeId() +"'");
		}
		//时间日期限制条件  TO_DAYS()转换为天数（mysql）
		if (StringUtil.isNotEmpty(bbirthday)) {
			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+ bbirthday +"')");
		}
		if (StringUtil.isNotEmpty(ebirthday)) {
			sb.append(" and TO_DAYS(s.birthday)<=TO_DAYS('"+ ebirthday +"')");
		}
		
		if (pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int studentCount(Connection con, Student student, String bbirthday, String ebirthday) throws Exception{
		StringBuffer sb = new StringBuffer("select count(*) as total from t_student s, t_grade g where s.gradeId = g.id");
	
		if (StringUtil.isNotEmpty(student.getStuNo())) {
			sb.append(" and s.stuNo like '%"+ student.getStuNo() +"%'");
		}
		if (StringUtil.isNotEmpty(student.getGradeName())) {
			sb.append(" and s.stuName like '%"+ student.getStuName() +"%'");
		}
		if (StringUtil.isNotEmpty(student.getSex())) {
			sb.append(" and s.sex='"+ student.getSex() +"'");
		}
		if (student.getGradeId() != -1) {
			sb.append(" and s.gradeId='"+ student.getGradeId() +"'");
		}
		if (StringUtil.isNotEmpty(bbirthday)) {
			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+ bbirthday +"')");
		}
		if (StringUtil.isNotEmpty(ebirthday)) {
			sb.append(" and TO_DAYS(s.birthday)<=TO_DAYS('"+ ebirthday +"')");
		}
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
	public int studentDelete(Connection con, String delIds) throws Exception {
		String sql="delete from t_student where stuId in ("+ delIds +")";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
}
