package com.itoudis.alex.attribute.framework.input.rest;

import com.itoudis.alex.attribute.framework.input.rest.request.AddAttributeRequest;
import com.itoudis.alex.attribute.framework.input.rest.response.AddAttributeResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attribute")
public class AttributeRestAdapter {


    @PostMapping("/addAttribute")
    public AddAttributeResponse addAttribute(@RequestBody @Valid AddAttributeRequest addAttributeRequest) {
        return new AddAttributeResponse(addAttributeRequest.getAttributeName(), addAttributeRequest.getAttributeType(), addAttributeRequest.getOptionValues());
    }
}
