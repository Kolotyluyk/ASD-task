package com.sk.service.impl;

import com.sk.dao.mybatis.CountryDao;
import com.sk.dao.mybatis.LocationDao;
import com.sk.dao.mybatis.RequestDao;
import com.sk.dao.mybatis.SessionDao;
import com.sk.dao.mybatis.UserDao;
import com.sk.dao.mybatis.UserGroupDao;
import com.sk.entity.Request;
import com.sk.service.Report;
import com.sk.service.RequestService;
import com.sk.service.poi.PoiService;
import com.sk.service.poi.impl.PoiServiceDocImpl;
import com.sk.service.poi.impl.PoiServiceXlsxImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class ReportImpl implements Report {

	private static SqlSessionFactory sessionFactory;
	public static SqlSession session;

	{
		Reader rdr = null;
		try {
			rdr = Resources.getResourceAsReader("mybatis-config.xml");

			sessionFactory = new SqlSessionFactoryBuilder().build(rdr);
			rdr.close();
			sessionFactory.getConfiguration().addMapper(UserDao.class);
			sessionFactory.getConfiguration().addMapper(RequestDao.class);
			sessionFactory.getConfiguration().addMapper(SessionDao.class);
			sessionFactory.getConfiguration().addMapper(CountryDao.class);
			sessionFactory.getConfiguration().addMapper(LocationDao.class);
			sessionFactory.getConfiguration().addMapper(UserGroupDao.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createReport(String email, String filter, String docFormat) {
		session = sessionFactory.openSession();
		RequestService requestService = new RequestServiceImpl();
		List<Request> requests = requestService.findAll();
		writeReportInDoc(docFormat, requests, email);

		//     request.get(0).getSession().getUser().

	}

	@Override
	public void writeReportInDoc(String docType, List<Request> requests, String email) {
		PoiService poiService = null;
		if (docType.equals("docx"))
			poiService = new PoiServiceDocImpl();
		if (docType.equals("xlsx"))
			poiService = new PoiServiceXlsxImpl();

		sendReportInEmail(email, poiService.writeDocument(requests));

	}

	@Override
	public void sendReportInEmail(String email, String docName) {
		final String username = "**********"; // enter your mail id
		final String password = "**********";// enter ur password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username)); // same email id
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			// Fill the message
			messageBodyPart.setText("Report about all users");

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(docName);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(docName);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
