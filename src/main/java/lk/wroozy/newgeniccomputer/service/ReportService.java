package lk.wroozy.newgeniccomputer.service;

import org.springframework.http.ResponseEntity;

public interface ReportService {

    ResponseEntity<?> getThisMonthSaleReport();

    ResponseEntity<?> getSaleReport(int month, int year);
}
