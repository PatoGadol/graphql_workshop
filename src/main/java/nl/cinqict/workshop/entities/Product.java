package nl.cinqict.workshop.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import nl.cinqict.workshop.entities.enums.ProductType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column
    @JsonFormat
    private String name;

    @Column
    @JsonFormat
    private String specs;
}
