package com.example.employeeproducer.controllers;

import com.example.employeeproducer.models.Employee;
import com.example.employeeproducer.source.EmployeeRegistrationSource;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableBinding(EmployeeRegistrationSource.class)
public class TestController {
    private final EmployeeRegistrationSource employeeRegistrationSource;

    public TestController(EmployeeRegistrationSource employeeRegistrationSource) {
        this.employeeRegistrationSource = employeeRegistrationSource;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getDataFallBack")
    public Employee firstPage() {
        System.out.println("Inside firstPage");

        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);

        if (emp.getName().equalsIgnoreCase("emp1"))
            throw new RuntimeException();

        return emp;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String orderFood(@RequestBody Employee employee) {
        employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
        System.out.println(employee);
        return "Employee Registered";
    }


    private Employee getDataFallBack() {
        System.out.println("Inside fallback");

        Employee emp = new Employee();
        emp.setName("fallback-emp1");
        emp.setDesignation("fallback-manager");
        emp.setEmpId("fallback-1");
        emp.setSalary(3000);

        return emp;

    }

}
