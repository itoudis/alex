package com.itoudis.alex.attribute.framework.input.rest.response;

import com.itoudis.alex.attribute.domain.AttributeType;
import com.itoudis.alex.attribute.domain.option.OptionValue;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AddAttributeResponse {

    private final String attributeName;

    private final AttributeType attributeType;

    private final List<OptionValue> optionValues;
}