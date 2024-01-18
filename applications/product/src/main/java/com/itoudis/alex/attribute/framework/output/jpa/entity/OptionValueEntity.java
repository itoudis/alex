package com.itoudis.alex.attribute.framework.output.jpa.entity;

import com.itoudis.alex.infra.out.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "option_value")
@NoArgsConstructor
public class OptionValueEntity extends BaseEntity {

    private String value;

    public OptionValueEntity(String value) {
        this.value = value;
    }
}
