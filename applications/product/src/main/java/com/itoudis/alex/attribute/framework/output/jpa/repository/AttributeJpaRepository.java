package com.itoudis.alex.attribute.framework.output.jpa.repository;

import com.itoudis.alex.attribute.framework.output.jpa.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeJpaRepository extends JpaRepository<AttributeEntity, Long> {

}
