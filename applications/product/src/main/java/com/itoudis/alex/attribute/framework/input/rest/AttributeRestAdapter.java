package com.itoudis.alex.attribute.framework.input.rest;

import com.itoudis.alex.attribute.application.usecase.AttributeUseCaseHandler;
import com.itoudis.alex.attribute.framework.input.rest.request.AddAttributeRequest;
import com.itoudis.alex.attribute.framework.input.rest.response.AddAttributeResponse;
import com.itoudis.alex.attribute.framework.mapper.AttributeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attribute")
@RequiredArgsConstructor
public class AttributeRestAdapter {

    private final AttributeUseCaseHandler attributeUsecaseHandler;

    @PostMapping("/addAttribute")

    public AddAttributeResponse addAttribute(@RequestBody @Valid AddAttributeRequest addAttributeRequest) {
        return AttributeMapper.INSTANCE().domainToResponse(attributeUsecaseHandler.createAttribute(addAttributeRequest.mapToDomainObject()));
    }
}
