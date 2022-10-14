package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Report;
import com.ennea.valuemanage.Repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReportServiceImpl implements ReportService{
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report save(Report report) {
        report.getComment().setDate(report.getDate());
        try{
        report.setDate(formatter.parse(formatter.format(new Date())));}
        catch (ParseException e){
            report.setDate(null);
        }
        return reportRepository.save(report);
    }
}
