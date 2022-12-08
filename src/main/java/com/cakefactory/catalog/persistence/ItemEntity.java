package com.cakefactory.catalog.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "catalog")
public class ItemEntity {
    @Id
    public String sku;
    @NotBlank
    public String title;
    @NotNull
    public BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemEntity) {
            return ((ItemEntity) o).sku.equals(this.sku);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sku);
    }
}
