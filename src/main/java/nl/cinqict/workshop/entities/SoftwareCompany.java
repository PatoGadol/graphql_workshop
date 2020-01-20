package nl.cinqict.workshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("name ASC")
    private List<Product> products;

    private transient  String formattedDate;

    public String getFormattedDate() {
        return getDateFounded().toString();
    }

}
