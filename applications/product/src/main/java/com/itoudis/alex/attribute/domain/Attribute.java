package com.itoudis.alex.attribute.domain;

import com.itoudis.alex.attribute.domain.option.OptionValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Attribute {

    private Long id;
    private AttributeType attributeType;
    private String name;
    private List<OptionValue> optionValues;
}
