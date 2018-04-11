package com.sk.dao.POI;

import com.sk.entity.Request;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class POIXlsxDao {
    public static final String FILE_NAME="file.xlsx";

   public String writeToFile(List<Request> requests){
       XSSFWorkbook workbook = new XSSFWorkbook();
       XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
       int rowNum = 1;


       System.out.println("Creating excel");
       createHut(sheet);

       for (Request  request : requests) {
           Row row = sheet.createRow(rowNum++);
           int colNum = 0;
           Cell cell = row.createCell(colNum++);
           cell.setCellValue(rowNum-1);
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getUser().getUserName());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getUser().getUserGroupId().getGroupName());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getUser().getLocation().getLocationName());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getUser().getLocation().getLatitude());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getUser().getLocation().getLongitude());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getUser().getLocation().getCountry().getCountryName());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getUser().getLocation().getCountry().getLanguage());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getDateOpened());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getSession().getDateClosed());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getMethod());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getParams());
           cell = row.createCell(colNum++);
           cell.setCellValue(request.getUrl());
       }

       try {

           FileOutputStream outputStream = new FileOutputStream(new File(FILE_NAME));
           workbook.write(outputStream);
           workbook.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

       System.out.println("create file.xlsx");
       return FILE_NAME;
    }


    Row createHut(Sheet sheet){

        Row row = sheet.createRow(0);
        int colNum = 0;
        Cell cell = row.createCell(colNum++);
        cell.setCellValue("#");
        cell = row.createCell(colNum++);
        cell.setCellValue("UserName");
        cell = row.createCell(colNum++);
        cell.setCellValue("Group");
        cell = row.createCell(colNum++);
        cell.setCellValue("Location");
        cell = row.createCell(colNum++);
        cell.setCellValue("Latitude");
        cell = row.createCell(colNum++);
        cell.setCellValue("Longitude");
        cell = row.createCell(colNum++);
        cell.setCellValue("Country");
        cell = row.createCell(colNum++);
        cell.setCellValue("Language");
        cell = row.createCell(colNum++);
        cell.setCellValue("session Date opened");
        cell = row.createCell(colNum++);
        cell.setCellValue("session Date closed");
        cell = row.createCell(colNum++);
        cell.setCellValue("Method");
        cell = row.createCell(colNum++);
        cell.setCellValue("Params");
        cell = row.createCell(colNum++);
        cell.setCellValue("Url");
        return row;
    }
}
