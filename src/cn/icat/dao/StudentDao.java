package cn.icat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.icat.model.PageBean;

public class StudentDao {

	public ResultSet studentList(Connection con, PageBean pageBean) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_student s, t_grade g where s.gradeId=g.id");
		if (pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int studentCount(Connection con) throws Exception{
		StringBuffer sb = new StringBuffer("select count(*) as total from t_student s, t_grade g where s.gradeId = g.id");
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
}
