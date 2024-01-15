package com.itoudis.alex.attribute.framework.input.rest.request;

import com.itoudis.alex.attribute.domain.AttributeType;
import com.itoudis.alex.attribute.domain.option.OptionValue;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AddAttributeRequest {

    @NotNull
    private final String attributeName;

    @NotNull
    private final AttributeType attributeType;

    private List<OptionValue> optionValues;

    @AssertTrue(message = "Option values can not be null for list type")
    public boolean isAttributeNameNotNull() {
        return !attributeType.equals(AttributeType.LIST) || (optionValues != null && !optionValues.isEmpty());
    }


}
