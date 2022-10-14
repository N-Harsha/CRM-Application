package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Report;
import com.ennea.valuemanage.Repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class ReportServiceImpl implements ReportService{
    ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report save(Report report) {
//        report.setDate(LocalDate.now());
        report.getComment().setDate(report.getDate());

        return reportRepository.save(report);
    }
}
