package com.sk.Servlet;

import com.sk.domain.RequestParameter;
import com.sk.service.Report;
import com.sk.service.impl.ReportImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ASD")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = null, docFormat = null, filter = null;
		if (req.getParameter(RequestParameter.EMAIL.getName()) == null)
			email = "example@gmail.com";
		else
			email = req.getParameter(RequestParameter.EMAIL.getName());

		if (req.getParameter(RequestParameter.FILTER.getName()) == null)
			filter = "";
		else
			filter = req.getParameter(RequestParameter.FILTER.getName());

		if (req.getParameter(RequestParameter.FORMAT.getName()) == null)
			docFormat = "xlsx";
		else
			docFormat = req.getParameter(RequestParameter.FORMAT.getName());

		Report report = new ReportImpl();
		report.createReport(email, filter, docFormat);
		resp.getWriter().write("We sent report about each users in" + req.getParameter(RequestParameter.EMAIL.getName()));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

	}

}
