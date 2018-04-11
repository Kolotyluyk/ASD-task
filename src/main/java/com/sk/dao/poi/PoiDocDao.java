package com.sk.dao.poi;

import com.sk.entity.Request;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PoiDocDao {

	public static final String FILE_NAME = "file.doc";

	public String writeToFile(List<Request> requests) {

		try {
			XWPFDocument document = new XWPFDocument();
			FileOutputStream outputStream = new FileOutputStream(new File(FILE_NAME));
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			StringBuilder row = new StringBuilder();

			row.append("#   " + "User_name    " + "Group    " + "Location     " + "Latitude    " + "Longitude     " + "Country     " + "Language     "
					+ "Session_date_opened   " + "Session_date_closed  " + "Method   " + "Params  " + "Url \n");
			int colNum = 0;
			for (Request request : requests) {
				row.append(++colNum);

				row.append("  ").append(request.getSession().getUser().getUserName());
				row.append("  ").append(request.getSession().getUser().getUserGroupId().getGroupName());
				row.append("  ").append(request.getSession().getUser().getLocation().getLocationName());
				row.append("  ").append(request.getSession().getUser().getLocation().getLatitude());
				row.append("  ").append(request.getSession().getUser().getLocation().getLongitude());
				row.append("  ").append(request.getSession().getUser().getLocation().getCountry().getCountryName());
				row.append("  ").append(request.getSession().getUser().getLocation().getCountry().getLanguage());
				row.append("  ").append(request.getSession().getDateOpened());
				row.append("  ").append(request.getSession().getDateClosed());
				row.append("  ").append(request.getMethod());
				row.append("  ").append(request.getParams());
				row.append("  ").append(request.getUrl());
				row.append(" \n");
			}
			run.setText(row.toString());
			document.write(outputStream);
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("create file.doc");
		return FILE_NAME;
	}
}
