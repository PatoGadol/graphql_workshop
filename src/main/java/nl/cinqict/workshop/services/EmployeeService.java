package nl.cinqict.workshop.services;

import nl.cinqict.workshop.entities.Employee;
import nl.cinqict.workshop.entities.SoftwareCompany;
import nl.cinqict.workshop.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeeByName(String firstName) {
        return this.employeeRepository.findByName(firstName);
    }

    public Employee createEmployee(String firstName, String lastName, String function, Float annualSalary, Integer seniority) {
        /*Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setFunction(function);
        employee.setAnnualSalary(annualSalary);
        employee.setSeniority(seniority);*/
        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .function(function)
                .annualSalary(annualSalary)
                .seniority(seniority)
                .build();
        return this.employeeRepository.save(employee);
    }
}
