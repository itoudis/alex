package com.itoudis.alex.attribute.framework.output.jpa;

import com.itoudis.alex.attribute.domain.Attribute;
import com.itoudis.alex.attribute.domain.port.output.AttributeDbPort;
import com.itoudis.alex.attribute.framework.mapper.AttributeMapper;
import com.itoudis.alex.attribute.framework.output.jpa.entity.AttributeEntity;
import com.itoudis.alex.attribute.framework.output.jpa.repository.AttributeJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AttributeJpaAdapter implements AttributeDbPort {

    private final AttributeJpaRepository attributeJpaRepository;

    @Override
    public Attribute saveAttribute(Attribute attribute) {
        return AttributeMapper.INSTANCE.entityToDomain(attributeJpaRepository.save(AttributeMapper.INSTANCE.domainToEntity(attribute)));
    }

    @Override
    public Attribute getAttribute(Long id) {
        return AttributeMapper.INSTANCE.entityToDomain(attributeJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public Attribute updateAttribute(Attribute attribute) {
        AttributeEntity attributeEntity = attributeJpaRepository.findById(attribute.getId()).orElseThrow(EntityNotFoundException::new);
        AttributeEntity attributeEntityUpdated = new AttributeEntity(attribute);
        attributeEntityUpdated.copyFrom(attributeEntity);
        return AttributeMapper.INSTANCE.entityToDomain(attributeJpaRepository.save(attributeEntityUpdated));
    }
}
