package org.formation.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends PanacheEntityBase {

    @Id
    public String refProduct;

    private String name;
    private String description;
    private double price;
}
