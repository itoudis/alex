package com.itoudis.alex.attribute.framework.input.rest;

import com.itoudis.alex.attribute.application.usecase.AttributeUseCaseHandler;
import com.itoudis.alex.attribute.framework.input.rest.request.AddAttributeRequest;
import com.itoudis.alex.attribute.framework.input.rest.request.UpdateAttributeRequest;
import com.itoudis.alex.attribute.framework.input.rest.response.AttributeResponse;
import com.itoudis.alex.attribute.framework.mapper.AttributeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attribute")
@RequiredArgsConstructor
public class AttributeRestAdapter {

    private final AttributeUseCaseHandler attributeUsecaseHandler;

    @PostMapping
    public AttributeResponse attribute(@RequestBody @Valid AddAttributeRequest addAttributeRequest) {
        return AttributeMapper.INSTANCE().domainToResponse(attributeUsecaseHandler.createAttribute(addAttributeRequest.mapToDomainObject()));
    }

    @PutMapping
    public AttributeResponse attribute(@RequestBody @Valid UpdateAttributeRequest updateAttributeRequest) {
        return AttributeMapper.INSTANCE().domainToResponse(attributeUsecaseHandler.updateAttribute(updateAttributeRequest.mapToDomainObject()));
    }
}
