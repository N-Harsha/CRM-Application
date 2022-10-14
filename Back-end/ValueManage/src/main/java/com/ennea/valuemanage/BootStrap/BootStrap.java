package com.ennea.valuemanage.BootStrap;

import com.ennea.valuemanage.Model.*;
import com.ennea.valuemanage.Repositories.*;
import com.ennea.valuemanage.Services.CustomerService;
import com.ennea.valuemanage.Services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BootStrap implements CommandLineRunner {

    EmployeeService employeeService;
    CustomerService customerService;

    public BootStrap(EmployeeService employeeService, CustomerService customerService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer dist1=Customer.builder().name("Distributor1")
                .customerType(CustomerType.DISTRIBUTOR)
                .phoneNo("9855135777").build();
        Customer dist2=Customer.builder().name("Distributor2")
                .customerType(CustomerType.DISTRIBUTOR)
                .phoneNo("9855135777").build();
        Customer dist3=Customer.builder().name("Distributor3")
                .customerType(CustomerType.DISTRIBUTOR)
                .phoneNo("9855135777").build();
        Customer dist4=Customer.builder().name("Distributor4")
                .customerType(CustomerType.DISTRIBUTOR)
                .phoneNo("9855135777").build();
        Customer dist5=Customer.builder().name("Distributor5")
                .customerType(CustomerType.DISTRIBUTOR)
                .phoneNo("9855135777").build();
        Customer dist6=Customer.builder().name("Distributor6")
                .customerType(CustomerType.DISTRIBUTOR)
                .phoneNo("9855135777").build();

        Employee m1=Employee.builder().employeeRole(EmployeeRole.MANAGER).name("Manager1").phoneNo("9848033221").customer(dist1).customer(dist2)
                .attendance(Attendance.builder().presenceDate(LocalDate.of(2022,10,1)).build())
                .attendance(Attendance.builder().presenceDate(LocalDate.of(2022,11,1)).build())
                .attendance(Attendance.builder().presenceDate(LocalDate.of(2022,3,12)).build()).build();
        Employee m2=Employee.builder().employeeRole(EmployeeRole.MANAGER).name("Manager2").phoneNo("9848033221").customer(dist3).customer(dist4).build();
        Employee m3=Employee.builder().employeeRole(EmployeeRole.MANAGER).name("Manager3").phoneNo("9848033221").customer(dist5).customer(dist6).build();



        Customer retailer1 = Customer.builder().name("Retailer1")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();
        Customer retailer2 = Customer.builder().name("Retailer2")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();
        Customer retailer3 = Customer.builder().name("Retailer3")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();
        Customer retailer4 = Customer.builder().name("Retailer4")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();
        Customer retailer5 = Customer.builder().name("Retailer5")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();
        Customer retailer6 = Customer.builder().name("Retailer6")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();
        Customer retailer7 = Customer.builder().name("Retailer7")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();
        Customer retailer8 = Customer.builder().name("Retailer8")
                .customerType(CustomerType.RETAILER)
                .phoneNo("9000800268").build();


        Employee re1=Employee.builder().name("Representative1").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m1).customer(retailer1).build();
        Employee re2=Employee.builder().name("Representative2").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m1).customer(retailer2).build();
        Employee re3=Employee.builder().name("Representative3").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m2).customer(retailer3).build();
        Employee re4=Employee.builder().name("Representative4").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m2).customer(retailer4).build();
        Employee re5=Employee.builder().name("Representative5").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m3).customer(retailer5).build();
        Employee re6=Employee.builder().name("Representative6").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m3).customer(retailer6).build();
        Employee re7=Employee.builder().name("Representative7").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m1).customer(retailer7).build();
        Employee re8=Employee.builder().name("Representative8").employeeRole(EmployeeRole.REPRESENTATIVE).supervisor(m2).customer(retailer8).build();

        employeeService.save(re1);
        employeeService.save(re2);
        employeeService.save(re3);
        employeeService.save(re4);
        employeeService.save(re5);
        employeeService.save(re6);
        employeeService.save(re7);
        employeeService.save(re8);


    }
}
