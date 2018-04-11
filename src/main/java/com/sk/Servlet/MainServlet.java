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
        req.getParameter(RequestParameter.EMAIL.getName());
        Report report= new ReportImpl();
        report.createReport(req.getParameter(RequestParameter.EMAIL.getName()),
                            req.getParameter(RequestParameter.FILTER.getName()),
                            req.getParameter(RequestParameter.FORMAT.getName()));
        resp.getWriter().write("");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");


    }


}
