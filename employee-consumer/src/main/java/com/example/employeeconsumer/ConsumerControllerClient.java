package com.example.employeeconsumer;

import com.example.employeeconsumer.adaptor.feign.EmployeeProducerAdaptor;
import com.example.employeeconsumer.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

@Controller
public class ConsumerControllerClient {

    @Autowired
    private EmployeeProducerAdaptor employeeProducerAdaptor;


    public void getEmployee() throws RestClientException {
        try {
            Employee emp = employeeProducerAdaptor.getData();
            System.out.println(emp.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
