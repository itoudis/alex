package com.itoudis.alex.attribute.framework.input.rest.request.dto;


import com.itoudis.alex.attribute.domain.option.OptionValue;
import com.itoudis.alex.infra.in.rest.InboundRequest;

public record OptionValueRequest(String value) implements InboundRequest<OptionValue> {
    @Override
    public OptionValue mapToDomainObject() {
        return OptionValue.builder().value(value).build();
    }
}
