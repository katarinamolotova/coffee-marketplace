package com.sbt.demo.services.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public abstract class AbstractMapper<M, D> implements Mapper<M, D> {

    @Autowired
    private ModelMapper mapper;

    private final Class<M> modelClass;
    private final Class<D> dtoClass;


    AbstractMapper(
            Class<M> modelClass,
            Class<D> dtoClass
    ) {
        this.modelClass = modelClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public M toModel(D dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, modelClass);
    }

    @Override
    public D toDto(M model) {
        return Objects.isNull(model)
                ? null
                : mapper.map(model, dtoClass);
    }
}
