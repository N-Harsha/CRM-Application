package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Attendance;
import com.ennea.valuemanage.Repositories.AttendanceRepository;
import com.ennea.valuemanage.Repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Attendance save(Attendance attendance){
//        attendance.setPresenceDate(LocalDate.now());
        return attendanceRepository.save(attendance);
    }
}
