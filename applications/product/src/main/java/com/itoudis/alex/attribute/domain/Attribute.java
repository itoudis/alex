package com.itoudis.alex.attribute.domain;

import com.itoudis.alex.attribute.domain.option.OptionValue;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Builder
public class Attribute {

    private final AttributeType attributeType;
    private final String name;
    private final List<OptionValue> optionValues;
}
