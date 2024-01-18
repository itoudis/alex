package com.itoudis.alex.attribute.framework.input.rest;

import com.itoudis.alex.attribute.framework.input.rest.request.AddAttributeRequest;
import com.itoudis.alex.attribute.framework.input.rest.response.AddAttributeResponse;
import com.itoudis.alex.attribute.framework.output.jpa.AttributeJpaAdapter;
import com.itoudis.alex.attribute.framework.output.jpa.entity.AttributeEntity;
import com.itoudis.alex.attribute.framework.output.jpa.entity.OptionValueEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attribute")
public class AttributeRestAdapter {

    // TODO port implementasyonu yaz
    @Autowired
    private AttributeJpaAdapter attributeJpaAdapter;

    @PostMapping("/addAttribute")
    public AddAttributeResponse addAttribute(@RequestBody @Valid AddAttributeRequest addAttributeRequest) {

        AttributeEntity entity = new AttributeEntity(addAttributeRequest.getAttributeType().name(), addAttributeRequest.getAttributeName(), addAttributeRequest.getOptionValues().stream().map(it -> new OptionValueEntity(it.value())).toList());

        AttributeEntity jpaEntity = attributeJpaAdapter.save(entity);

        return new AddAttributeResponse(addAttributeRequest.getAttributeName(), addAttributeRequest.getAttributeType(), addAttributeRequest.getOptionValues());
    }
}
