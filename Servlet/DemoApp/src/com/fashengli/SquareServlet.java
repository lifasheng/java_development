package com.fashengli;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/square",
initParams =
{
    @WebInitParam(name = "name", value = "FashengLi"),
})
public class SquareServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		// for same session, request dispatching
		int k = (int)req.getAttribute("k");
		System.out.println("k is from request dispatching");
		
		System.out.println("verify that parameter is shared in same request");
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		System.out.println("i=" + i + ", j= " + j);
		
		// for URL rewriting
		// int k = Integer.parseInt(req.getParameter("k"));
		
		/*
		// for session management
		HttpSession session = req.getSession();
		int k = (int)session.getAttribute("k");
		*/
		
		/*
		// for cookie
		Cookie[] cookies = req.getCookies();
		int k = 0;
		for (Cookie c : cookies) {
			if (c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
				System.out.println("get k from cookie: " + k);
			}
		}
		*/

		
		int square = k * k;
		System.out.println("square of " + k + " is: " + square);
		
		/*
		PrintWriter out = res.getWriter();
		out.println("<html><body bgcolor='cyan'>");
		
		// servlet context is shared by all servlets
		ServletContext ctx = getServletContext();
		out.println("Hi " + ctx.getInitParameter("name") + ", you did a greate job!<br/>");
		
		// servlet config is for specific sevelet
		ServletConfig cfg = getServletConfig();
		out.println("Hi " + cfg.getInitParameter("name") + ", you did a greate job!<br/>");
		
		out.println("square is: " + k);
		
		out.println("</body></html>");
		*/
		
		req.setAttribute("square", square);
		
		List<Student> students = Arrays.asList(new Student(1, "FashengLi"), new Student(2, "jadon"), new Student(3, "yuangang"));
		req.setAttribute("students", students);
		
		RequestDispatcher rd = req.getRequestDispatcher("square.jsp");
		rd.forward(req, res);
		
	}

}
