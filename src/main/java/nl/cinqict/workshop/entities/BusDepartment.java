package nl.cinqict.workshop.entities;

import org.springframework.stereotype.Component;

@Component
public class BusDepartment implements Department {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
