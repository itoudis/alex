package com.itoudis.alex.attribute.framework.input.rest.response;

import com.itoudis.alex.attribute.domain.AttributeType;
import com.itoudis.alex.attribute.domain.option.OptionValue;
import lombok.Builder;

import java.util.List;

@Builder
public record AttributeResponse(String attributeName, AttributeType attributeType, List<OptionValue> optionValues) {
}