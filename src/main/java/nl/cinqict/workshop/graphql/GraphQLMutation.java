package nl.cinqict.workshop.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import nl.cinqict.workshop.entities.Employee;
import nl.cinqict.workshop.entities.Product;
import nl.cinqict.workshop.entities.SoftwareCompany;
import nl.cinqict.workshop.services.EmployeeService;
import nl.cinqict.workshop.services.SoftwareCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class GraphQLMutation implements GraphQLMutationResolver {

    private final SoftwareCompanyService softwareCompanyService;
    private final EmployeeService employeeService;

    @Autowired
    public GraphQLMutation(SoftwareCompanyService softwareCompanyService,
                           EmployeeService employeeService) {
        this.softwareCompanyService = softwareCompanyService;
        this.employeeService = employeeService;
    }

    public SoftwareCompany createSoftwareCompany(String name,
                                                 Float companyWorth,
                                                 Integer numberOfEmployees,
                                                 String dateFounded,
                                                 String companyHistory,
                                                 List<Product> products) {

        return this.softwareCompanyService.createSoftwareCompany(
                name,
                companyWorth,
                numberOfEmployees,
                dateFounded,
                companyHistory,
                products);
    }

    public Employee createEmployee(String firstName,
                                   String lastName,
                                   String function,
                                   Float annualSalary,
                                   Integer seniority,
                                   LocalDate dateOfBirth) {

        return this.employeeService.createEmployee(
                firstName,
                lastName,
                function,
                annualSalary,
                seniority,
                dateOfBirth);
    }
}
