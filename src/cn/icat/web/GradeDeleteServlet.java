package cn.icat.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.icat.dao.GradeDao;
import cn.icat.dao.StudentDao;
import cn.icat.util.DbUtil;
import cn.icat.util.ResponseUtil;
import net.sf.json.JSONObject;

public class GradeDeleteServlet extends HttpServlet {
	DbUtil dbUtil = new DbUtil();
	GradeDao gradeDao = new GradeDao();
	StudentDao studentDao = new StudentDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String delIds = request.getParameter("delIds");
		Connection con = null;
		
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			
			////删除班级判断是否存在学生
			String str[] = delIds.split(",");
			for (int i=0; i<str.length; i++) {
				boolean f = studentDao.getStudentByGradeId(con, str[i]);
				if (f) {
					result.put("errorIndex", i);
					result.put("errorMsg", "班级下面有学生，不能删除！");
					ResponseUtil.write(response, result);
					return;
				}
			}
			
			
			int delNums = gradeDao.gradeDelete(con, delIds);
			
			if (delNums > 0) {
				result.put("success", "true");
				result.put("delNums", delNums);
			} else {
				result.put("errorMsg", "删除失败");
			}
			ResponseUtil.write(response, result);
			
			result.put("delNums", delNums);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
