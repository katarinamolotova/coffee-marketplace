package com.sbt.demo.services;

import com.sbt.demo.repositories.StatusHistoryRepositoryImpl;
import com.sbt.demo.services.dto.StatusHistoryDTO;
import com.sbt.demo.services.mappers.StatusHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public void saveMapOrderIdAndStatusHistory(Map<Long, List<StatusHistoryDTO>> orderIdAndStatusHistory) {
        orderIdAndStatusHistory.forEach(
                (id, statusesHistory) -> statusesHistory.forEach(
                        statusHistory -> statusHistoryRepository.save(statusHistoryMapper.toModel(statusHistory, id))
                )
        );
    }
}
