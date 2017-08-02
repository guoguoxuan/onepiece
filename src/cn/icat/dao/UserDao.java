package cn.icat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.icat.model.User;

public class UserDao {
	/**
	 * µÇÂ¼ÑéÖ¤
	 * */
	public User login(Connection con, User user) throws Exception{
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassWord());
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			resultUser = new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassWord(rs.getString("password"));
		}
		
		return resultUser;
		
	}

}
