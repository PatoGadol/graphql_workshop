package nl.cinqict.workshop.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class SoftwareCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "company_worth", nullable = false)
    private Float companyWorth;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;

    @Column(name = "date_founded")
    private LocalDate dateFounded;

    @Column(name = "company_history")
    private String companyHistory;

    private transient  String formattedDate;

    public String getFormattedDate() {
        return getDateFounded().toString();
    }

}
