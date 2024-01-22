package com.itoudis.alex.attribute.framework.mapper;


import com.itoudis.alex.attribute.domain.Attribute;
import com.itoudis.alex.attribute.domain.AttributeType;
import com.itoudis.alex.attribute.framework.input.rest.response.AddAttributeResponse;
import com.itoudis.alex.attribute.framework.output.jpa.entity.AttributeEntity;

public final class AttributeMapper {

    public static AttributeMapper INSTANCE;

    public static AttributeMapper INSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AttributeMapper();
        }
        return INSTANCE;
    }

    public Attribute entityToDomain(AttributeEntity attributeEntity) {
        return Attribute.builder()
                .attributeType(AttributeType.valueOf(attributeEntity.getAttributeType()))
                .name(attributeEntity.getName())
                .optionValues(OptionValueMapper.INSTANCE().entityListToDomainList(attributeEntity.getOptionValues()))
                .build();
    }

    public AttributeEntity domainToEntity(Attribute attribute) {
        return AttributeEntity.builder()
                .attributeType(attribute.getAttributeType().name())
                .name(attribute.getName())
                .optionValues(OptionValueMapper.INSTANCE().domainListToEntityList(attribute.getOptionValues()))
                .build();
    }

    public AddAttributeResponse domainToResponse(Attribute attribute) {
        return AddAttributeResponse.builder()
                .attributeName(attribute.getName())
                .attributeType(attribute.getAttributeType())
                .optionValues(attribute.getOptionValues())
                .build();
    }
}
