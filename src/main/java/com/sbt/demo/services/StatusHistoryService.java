package com.sbt.demo.services;

import com.sbt.demo.repositories.StatusHistoryRepositoryImpl;
import com.sbt.demo.services.dto.OrderDTO;
import com.sbt.demo.services.dto.StatusHistoryDTO;
import com.sbt.demo.services.mappers.StatusHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusHistoryService {
    private final StatusHistoryMapper statusHistoryMapper;
    private final StatusHistoryRepositoryImpl statusHistoryRepository;

    @Autowired
    public StatusHistoryService(
            StatusHistoryMapper statusHistoryMapper,
            StatusHistoryRepositoryImpl statusHistoryRepository
    ) {
        this.statusHistoryMapper = statusHistoryMapper;
        this.statusHistoryRepository = statusHistoryRepository;
    }

    public void save(StatusHistoryDTO statusHistory, OrderDTO order) {
        statusHistoryRepository.save(statusHistoryMapper.toModel(statusHistory, order));
    }
}
