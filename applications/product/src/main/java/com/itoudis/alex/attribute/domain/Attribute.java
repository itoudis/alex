package com.itoudis.alex.attribute.domain;

import com.itoudis.alex.attribute.domain.option.OptionValue;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Attribute {

    private final AttributeType attributeType;
    private final String name;
    private final OptionValue[] options;
}
