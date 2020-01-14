package nl.cinqict.workshop.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import nl.cinqict.workshop.entities.SoftwareCompany;
import nl.cinqict.workshop.services.SoftwareCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SoftwareCompanyQuery implements GraphQLQueryResolver {

    private SoftwareCompanyService softwareCompanyService;

    @Autowired
    public SoftwareCompanyQuery(SoftwareCompanyService softwareCompanyService) {
        this.softwareCompanyService = softwareCompanyService;
    }

    public Optional<SoftwareCompany> getSoftwareCompany(final String name) {
        return Optional.ofNullable(this.softwareCompanyService.getSoftwareCompanyByName(name));
    }

    public List<SoftwareCompany> getSoftwareCompanies(int count) {
        return softwareCompanyService.getSoftwareCompanies(count);
    }

}
