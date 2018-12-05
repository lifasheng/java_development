package com.fashengli;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/add",
initParams =
{
    @WebInitParam(name = "name", value = "FashengLi"),
})
public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		System.out.println("result is: " + k);
		
		
		
		// same session, request dispatching
		req.setAttribute("k", k);
		RequestDispatcher rd = req.getRequestDispatcher("square");
		rd.forward(req, res);
		
		
		// res.sendRedirect("square?k="+k); // URL Rewriting
		
		/*
		// for session management
		HttpSession session = req.getSession();
		session.setAttribute("k", k);
		res.sendRedirect("square");
		*/
		
		
		/*
		// using cookie to pass parameter between servlets
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);
		res.sendRedirect("square");
		*/
	}
}
