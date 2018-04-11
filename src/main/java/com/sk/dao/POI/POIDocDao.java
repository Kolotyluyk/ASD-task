package com.sk.dao.POI;

import com.sk.entity.Request;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class POIDocDao {

    public static final String FILE_NAME="file.doc";

    public String writeToFile(List<Request> requests){

        try {
        XWPFDocument document= new XWPFDocument();
        FileOutputStream outputStream = new FileOutputStream(new File(FILE_NAME));
            XWPFParagraph paragraph=document.createParagraph();
            XWPFRun run= paragraph.createRun();
         String row ="";

         row +="#   "+"User_name    "+"Group    "+"Location     "+"Latitude    "+"Longitude     "+"Country     "+
                 "Language     "+"Session_date_opened   "+"Session_date_closed  "+"Method   "+"Params  "+"Url \n";
            int colNum=0 ;
            for (Request  request : requests) {
            row+=++colNum;

            row+="  "+(request.getSession().getUser().getUserName());
            row+="  "+(request.getSession().getUser().getUserGroupId().getGroupName());
            row+="  "+(request.getSession().getUser().getLocation().getLocationName());
            row+="  "+(request.getSession().getUser().getLocation().getLatitude());
            row+="  "+(request.getSession().getUser().getLocation().getLongitude());
            row+="  "+(request.getSession().getUser().getLocation().getCountry().getCountryName());
            row+="  "+(request.getSession().getUser().getLocation().getCountry().getLanguage());
            row+="  "+(request.getSession().getDateOpened());
            row+="  "+(request.getSession().getDateClosed());
            row+="  "+(request.getMethod());
            row+="  "+(request.getParams());
            row+="  "+(request.getUrl());
            row+=" \n";
        }
            run.setText(row);
            document.write(outputStream);
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("create file.doc");
        return FILE_NAME;
    }
}
