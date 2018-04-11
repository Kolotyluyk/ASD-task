package com.sk.service;

import com.sk.entity.Request;

import java.util.List;

public interface Report {
	void createReport(String email, String filter, String docformat);

	public void writeReportInDoc(String docType, List<Request> requests, String email);

	void sendReportInEmail(String email, String docName);
}
