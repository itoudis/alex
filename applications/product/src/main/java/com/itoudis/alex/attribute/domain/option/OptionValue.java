package com.itoudis.alex.attribute.domain.option;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OptionValue{
    private final String value;
}
