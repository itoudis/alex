package com.itoudis.alex.infra.in.rest;

public interface InboundRequest <T>{

    T mapToDomainObject();
}
