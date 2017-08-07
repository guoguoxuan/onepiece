package cn.icat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.icat.model.Grade;
import cn.icat.model.PageBean;
import cn.icat.util.StringUtil;

public class GradeDao {
	
	public ResultSet gradeList(Connection con, PageBean pageBean, Grade grade) throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_grade");
		
		if (StringUtil.isNotEmpty(grade.getGradeName())) {
			sb.append(" and gradeName like '%"+grade.getGradeName()+"%'");
		}
		
		if (pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	public int gradeCount(Connection con, Grade grade) throws Exception{
		StringBuffer sb = new StringBuffer("select count(*) as total from t_grade");
		if (StringUtil.isNotEmpty(grade.getGradeName())) {
			sb.append(" and gradeName like '%"+grade.getGradeName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
	
	/**
	 * delete from tableName where field in (1,2,4)
	 * @throws SQLException 
	 * */
	public int gradeDelete(Connection con, String delIds) throws SQLException {
		String sql = "delete from t_grade where id in ("+delIds+")";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

}
