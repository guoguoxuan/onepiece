package cn.icat.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.icat.dao.StudentDao;
import cn.icat.model.PageBean;
import cn.icat.model.Student;
import cn.icat.util.DbUtil;
import cn.icat.util.JsonUtil;
import cn.icat.util.ResponseUtil;
import cn.icat.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StudentListServlet extends HttpServlet {

	DbUtil dbUtil = new DbUtil();
	StudentDao studentDao = new StudentDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		String sex = request.getParameter("sex");
		String bbirthday = request.getParameter("bbirthday");
		String ebirthday = request.getParameter("ebirthday");
		String gradeId = request.getParameter("gradeId");
		
		Student student = new Student();
		if (stuNo != null) {
			student.setStuNo(stuNo);
			student.setStuName(stuName);
			student.setSex(sex);
			if (StringUtil.isNotEmpty(gradeId)) {
				student.setGradeId(Integer.parseInt(gradeId));
			}
		}
		
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Connection con = null;
		
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(studentDao.studentList(con, pageBean, student, bbirthday, ebirthday));
			int total = studentDao.studentCount(con, student, bbirthday, ebirthday);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
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
