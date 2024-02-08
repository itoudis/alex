package com.itoudis.alex.attribute.framework.output.jpa.entity;

import com.itoudis.alex.attribute.domain.Attribute;
import com.itoudis.alex.attribute.framework.mapper.OptionValueMapper;
import com.itoudis.alex.infra.out.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "attribute")
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = true)//TODO :callSuper = true araştırılacak
public class AttributeEntity extends BaseEntity {

    private String attributeType;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "attribute_id")
    private List<OptionValueEntity> optionValues;

    public AttributeEntity(String attributeType, String name, List<OptionValueEntity> optionValues) {
        this.attributeType = attributeType;
        this.name = name;
        this.optionValues = optionValues;
    }

    public AttributeEntity(Attribute attribute) {
        this.attributeType = attribute.getAttributeType().name();
        this.name = attribute.getName();
        this.optionValues = OptionValueMapper.INSTANCE().domainListToEntityList(attribute.getOptionValues());
    }
}

