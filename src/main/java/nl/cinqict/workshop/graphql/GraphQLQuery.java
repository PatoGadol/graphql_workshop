package nl.cinqict.workshop.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import nl.cinqict.workshop.entities.Employee;
import nl.cinqict.workshop.entities.SoftwareCompany;
import nl.cinqict.workshop.services.EmployeeService;
import nl.cinqict.workshop.services.SoftwareCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GraphQLQuery implements GraphQLQueryResolver {

    private SoftwareCompanyService softwareCompanyService;
    private EmployeeService employeeService;

    @Autowired
    public GraphQLQuery(SoftwareCompanyService softwareCompanyService,
                        EmployeeService employeeService) {
        this.softwareCompanyService = softwareCompanyService;
        this.employeeService = employeeService;
    }

    public Optional<SoftwareCompany> getSoftwareCompany(final String name) {
        return Optional.ofNullable(this.softwareCompanyService.getSoftwareCompanyByName(name));
    }

    public List<SoftwareCompany> getSoftwareCompanies(int count) {
        return softwareCompanyService.getSoftwareCompanies(count);
    }

    public List<Employee> getEmployee(String firstName) {
        return employeeService.getEmployeeByName(firstName);
    }

}
