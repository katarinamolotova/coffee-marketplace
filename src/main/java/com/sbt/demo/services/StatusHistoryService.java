package com.sbt.demo.services;

import com.sbt.demo.repositories.StatusHistoryRepository;
import com.sbt.demo.repositories.entities.StatusHistory;
import com.sbt.demo.services.dto.StatusHistoryDTO;
import com.sbt.demo.services.mappers.StatusHistoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class StatusHistoryService {
    private final StatusHistoryMapper statusHistoryMapper;
    private final StatusHistoryRepository statusHistoryRepository;

    public void saveMapOrderIdAndStatusHistory(final Map<Long, List<StatusHistoryDTO>> orderIdAndStatusHistory) {
        orderIdAndStatusHistory.forEach(
                (id, statusesHistory) -> statusesHistory.forEach(
                        statusHistory -> {
                            final StatusHistory entity = statusHistoryMapper.toModel(statusHistory, id);
                            statusHistoryRepository.create(
                                    entity.getId(),
                                    entity.getOrderId(),
                                    entity.getOrderStatus().toString(),
                                    entity.getOperationTime()
                            );
                        }
                )
        );
    }
}
