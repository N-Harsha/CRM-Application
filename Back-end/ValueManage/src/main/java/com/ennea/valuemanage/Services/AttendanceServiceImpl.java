package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Attendance;
import com.ennea.valuemanage.Repositories.AttendanceRepository;
import com.ennea.valuemanage.Repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Attendance save(Attendance attendance){
        try {
        attendance.setPresenceDate(formatter.parse(formatter.format(new Date())));
        }
        catch (ParseException pe){
            System.out.println(pe.getMessage());
            attendance.setPresenceDate(null);
        }
        return attendanceRepository.save(attendance);
    }
}
