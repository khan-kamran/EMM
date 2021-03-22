package com.example.EMM.service;

import com.example.EMM.dto.EmployeeDto;
import com.example.EMM.entity.Address;
import com.example.EMM.entity.City;
import com.example.EMM.entity.Employee;
import com.example.EMM.entity.OfficeAddress;
import com.example.EMM.repository.AddressRepository;
import com.example.EMM.repository.CityRepository;
import com.example.EMM.repository.EmployeeRepository;
import com.example.EMM.repository.OfficeAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EMMService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    OfficeAddressRepository officeAddressRepository;

    public Integer getTotalEmployeeCount() {
        return employeeRepository.getCountOfEmployee();
    }

    public Integer getEnableCount() {
        return employeeRepository.getEnableCount();
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public Employee save(EmployeeDto employee) {
        Employee employee1 = getEmployeeFromDto(employee);
        City city = cityRepository.findByName(employee.getCity());
        employee1 = employeeRepository.save(employee1);
        Address address = getAddressFromDto(employee,employee1,city);
        address = addressRepository.save(address);
       return address.getEmployee();
    }


    private Address getAddressFromDto(EmployeeDto employee, Employee employee1, City city) {
        Address address = new Address();
        address.setAddress(employee.getAddress());
        address.setCity(city);
        address.setDepartmentId(employee.getDepartment());
        address.setEmployee(employee1);
        return address;
    }

    private Employee getEmployeeFromDto(EmployeeDto employee) {
        Employee employee1 = new Employee();
        employee1.setPhone(employee.getPhone());
        employee1.setEmail(employee.getEmail());
        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setGender(employee.getGender());
        employee1.setStatus(false);
        return employee1;
    }

    public List<OfficeAddress> getDepartmentAddress(String dname) {
       return officeAddressRepository.findBydName(dname);
    }

    public List<EmployeeDto> getAllEmployeesData() {
        List<EmployeeDto> employeeDtoList;
        List<Address> addresses = addressRepository.findAll();
        employeeDtoList = addresses.stream().map(this::setEmpDto).collect(Collectors.toList());
        return employeeDtoList;
    }

    private EmployeeDto setEmpDto(Address address) {
        Employee employee = address.getEmployee();
        City city = address.getCity();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        employeeDto.setPhone(employee.getPhone());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setGender(employee.getGender());
        if(employee.getStatus())
        employeeDto.setStatus("Enable");
        else employeeDto.setStatus("Disable");
        employeeDto.setCity(city.getName());
        employeeDto.setAddress(address.getAddress());
        employeeDto.setDepartment(address.getDepartmentId());
        return employeeDto;
    }

    public Employee changeStatus(Integer id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        emp.ifPresent(employee -> employee.setStatus(!employee.getStatus()));
        return employeeRepository.save(emp.get());
    }
}
