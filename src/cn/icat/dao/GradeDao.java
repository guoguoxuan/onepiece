package cn.icat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.icat.model.PageBean;
import cn.icat.util.DbUtil;

public class GradeDao {
	
	public ResultSet gradeList(Connection con, PageBean pageBean) throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_grade");
		if (pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	public int gradeCount(Connection con) throws Exception{
		String sql = "select count(*) as total from t_grade";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}

}
