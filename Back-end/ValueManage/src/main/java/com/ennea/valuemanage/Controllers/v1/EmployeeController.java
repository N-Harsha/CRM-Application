package com.ennea.valuemanage.Controllers.v1;

import com.ennea.valuemanage.API.v1.DTO.CustomerDTO;
import com.ennea.valuemanage.API.v1.DTO.ReportDTO;
import com.ennea.valuemanage.Services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"/representative/{id}/retailers","/manager/{id}/distributors"})
    //todo make controllers specific to employees along with validation of represnetative and manager
    public ResponseEntity<Page<CustomerDTO>> getCustomers(@PathVariable Long id,
                                                          @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size
                                                          ){
        return new ResponseEntity<>(employeeService.getCustomers(id, PageRequest.of(page,size)), HttpStatus.OK);
    }

    @GetMapping({"/representative/{id}/attendance","/manager/{id}/attendance"})
    public ResponseEntity<List<LocalDate>> getPresentDates(@PathVariable Long id, @RequestParam(name="month") int month, @RequestParam(name="year") int year){

        return new ResponseEntity<>(employeeService.getPresentDates(id,month,year),HttpStatus.OK);

    }

    @GetMapping({"/representative/{id}/reports", "/manager/{id}/reports"})
    public ResponseEntity<List<ReportDTO>> getReports(@PathVariable Long id){

        return new ResponseEntity<>(employeeService.getReports(id),HttpStatus.OK);
    }

    @PostMapping({"/representative/{id}/attendance/new","/manager/{id}/attendance/new"})
    public ResponseEntity<Void> markAttendance(@PathVariable Long id){
        employeeService.markAttendance(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping({"/representative/{id}/report/new", "/manager/{id}/report/new"})
    public ResponseEntity<Void> submitReport(@PathVariable Long id,@RequestBody ReportDTO reportDTO){
        employeeService.submitReport(id,reportDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
