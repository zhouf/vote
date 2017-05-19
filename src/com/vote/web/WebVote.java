/**
 * 
 */
package com.vote.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import com.jufeng.database.DBManage;

/**
 * @author Lenovo
 * 2014-5-4
 */
@WebServlet("/WebVote")
public class WebVote extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WebVote() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String voteStr = request.getParameter("r");
		Connection conn = DBManage.getConnection();
		
		WebRowSet rs = DBManage.getWRS(conn,"SELECT LABEL FROM OPTIONS WHERE ID=" + voteStr);
		try {
			if(rs!=null && rs.next()){
				voteStr = rs.getString(1);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO VOTES(RESULT) VALUES('"+voteStr+"')";
		System.out.println("sql:" + sql);
		
		DBManage.doUpdate(conn,sql);
		DBManage.closeConnection(conn);
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
