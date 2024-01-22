package com.itoudis.alex.attribute.framework.mapper;


import com.itoudis.alex.attribute.domain.option.OptionValue;
import com.itoudis.alex.attribute.framework.output.jpa.entity.OptionValueEntity;

import java.util.List;

public final class OptionValueMapper {

    public static OptionValueMapper INSTANCE;

    public static OptionValueMapper INSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new OptionValueMapper();
        }
        return INSTANCE;
    }

    public OptionValue entityToDomain(OptionValueEntity optionValueEntity) {
        return OptionValue.builder()
                .value(optionValueEntity.getValue())
                .build();
    }

    public OptionValueEntity domainToEntity(OptionValue optionValue) {
        return OptionValueEntity.builder()
                .value(optionValue.getValue())
                .build();
    }

    public List<OptionValue> entityListToDomainList(List<OptionValueEntity> optionValueEntities) {
        return optionValueEntities.stream()
                .map(this::entityToDomain)
                .toList();
    }

    public List<OptionValueEntity> domainListToEntityList(List<OptionValue> optionValues) {
        return optionValues.stream()
                .map(this::domainToEntity)
                .toList();
    }

}
