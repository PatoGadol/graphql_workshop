package nl.cinqict.workshop.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import nl.cinqict.workshop.entities.SoftwareCompany;
import nl.cinqict.workshop.services.SoftwareCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SoftwareCompanyMutation implements GraphQLMutationResolver {

    private final SoftwareCompanyService softwareCompanyService;

    @Autowired
    public SoftwareCompanyMutation(SoftwareCompanyService softwareCompanyService) {
        this.softwareCompanyService = softwareCompanyService;
    }

    public SoftwareCompany createSoftwareCompany(String name,
                                         Float companyWorth,
                                         Integer numberOfEmployees,
                                         String dateFounded,
                                         String companyHistory) {

        return this.softwareCompanyService.createSoftwareCompany(
                name,
                companyWorth,
                numberOfEmployees,
                dateFounded,
                companyHistory);
    }
}
