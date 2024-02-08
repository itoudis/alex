package com.itoudis.alex.attribute.application.usecase;

import com.itoudis.alex.attribute.domain.Attribute;
import com.itoudis.alex.attribute.domain.port.output.AttributeDbPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttributeUseCaseHandler {

    private final AttributeDbPort attributeDbPort;

    public Attribute createAttribute(Attribute attribute){
        //TODO : isimle attribute var mı kontrolü yapılacak
        return attributeDbPort.saveAttribute(attribute);
    }

    public Attribute updateAttribute(Attribute attribute){
        //TODO : id ile attribute var mı kontrolü
        //TODO : isimle attribute var mı kontrolü

        return attributeDbPort.updateAttribute(attribute);
    }
}
