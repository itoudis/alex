package com.itoudis.alex.attribute.framework.output.jpa;

import com.itoudis.alex.attribute.domain.Attribute;
import com.itoudis.alex.attribute.domain.port.output.AttributeDbPort;
import com.itoudis.alex.attribute.framework.mapper.AttributeMapper;
import com.itoudis.alex.attribute.framework.output.jpa.repository.AttributeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AttributeJpaAdapter implements AttributeDbPort {

    private final AttributeJpaRepository attributeJpaRepository;

    @Override
    public Attribute createAttribute(Attribute attribute) {
        return AttributeMapper.INSTANCE.entityToDomain(attributeJpaRepository.save(AttributeMapper.INSTANCE.domainToEntity(attribute)));
    }
}
