package com.example.employeeconsumer.adaptor.feign;


import com.example.employeeconsumer.config.OpenFeignConfiguration;
import com.example.employeeconsumer.models.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "employee-producer", configuration = OpenFeignConfiguration.class)
public interface EmployeeProducerAdaptor {
    @RequestMapping(method = RequestMethod.GET, value = "/employee")
    public Employee getData();

}
