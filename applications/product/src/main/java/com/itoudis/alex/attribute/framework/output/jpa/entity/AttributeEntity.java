package com.itoudis.alex.attribute.framework.output.jpa.entity;

import com.itoudis.alex.infra.out.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "attribute")
@NoArgsConstructor
public class AttributeEntity extends BaseEntity {

    private String attributeType;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "attribute_id")
    private List<OptionValueEntity> options;

    public AttributeEntity(String attributeType, String name, List<OptionValueEntity> options) {
        this.attributeType = attributeType;
        this.name = name;
        this.options = options;
    }
}

