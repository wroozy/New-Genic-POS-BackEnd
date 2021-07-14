package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/thisMonth")
    public ResponseEntity<?> getThisMonthReport(Principal principal){
        LOGGER.info("request - report | getThisMonthReport | adminId: {}", principal.getName());
        ResponseEntity<?> response = reportService.getThisMonthSaleReport();
        LOGGER.info("response - report | getThisMonthReport | response: {}", response);
        return response;
    }

    @GetMapping("/monthReport")
    public ResponseEntity<?> getMonthReport(@RequestParam int month,@RequestParam int year, Principal principal){
        LOGGER.info("request - report | getThisMonthReport | month: {} | year: {} | adminId: {}",month,year, principal.getName());
        ResponseEntity<?> response = reportService.getSaleReport(month, year);
        LOGGER.info("response - report | getThisMonthReport | response: {}", response);
        return response;
    }
}
