package com.itoudis.alex.attribute.framework.output.jpa;

import com.itoudis.alex.attribute.framework.output.jpa.entity.AttributeEntity;
import com.itoudis.alex.attribute.framework.output.jpa.repository.AttributeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributeJpaAdapter {

    @Autowired
    private AttributeJpaRepository attributeJpaRepository;

    public AttributeEntity save(AttributeEntity attributeEntity){
        return attributeJpaRepository.save(attributeEntity);
    }

}
