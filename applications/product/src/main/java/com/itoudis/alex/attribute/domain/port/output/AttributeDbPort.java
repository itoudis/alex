package com.itoudis.alex.attribute.domain.port.output;

import com.itoudis.alex.attribute.domain.Attribute;

public interface AttributeDbPort {

    Attribute saveAttribute(Attribute attribute);

    Attribute getAttribute(Long id);

    Attribute updateAttribute(Attribute attribute);
}
