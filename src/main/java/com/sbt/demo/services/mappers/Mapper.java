package com.sbt.demo.services.mappers;

public interface Mapper<M, D> {
    M toModel(D dto);
    D toDto(M model);
}
