package com.itoudis.alex.attribute.framework.input.rest.request;

import com.itoudis.alex.attribute.domain.Attribute;
import com.itoudis.alex.attribute.domain.AttributeType;
import com.itoudis.alex.attribute.framework.input.rest.request.dto.OptionValueRequest;
import com.itoudis.alex.infra.in.rest.InboundRequest;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AddAttributeRequest implements InboundRequest<Attribute> {

    @NotNull
    private final String name;

    @NotNull
    private final AttributeType attributeType;

    private List<OptionValueRequest> optionValues;

    @AssertTrue(message = "Option values can not be null for list type")
    public boolean isAttributeNameNotNull() {
        return !attributeType.equals(AttributeType.LIST) || (optionValues != null && !optionValues.isEmpty());
    }

    @Override
    public Attribute mapToDomainObject() {
        return Attribute.builder().
                attributeType(attributeType)
                .name(name)
                .optionValues(optionValues.stream().map(OptionValueRequest::mapToDomainObject).toList())
                .build();
    }
}
