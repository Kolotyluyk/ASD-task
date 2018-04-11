package com.sk;

import com.sk.service.Report;
import com.sk.service.impl.ReportImpl;

public class Main {
    public static void main(String[] args) {
        Report report=new ReportImpl();
        report.createReport("serhii.kolotyliuk@gmail.com","","docx");
  //      report.createReport("serhii.kolotyliuk@gmail.com","","xlsx");
    }
}
