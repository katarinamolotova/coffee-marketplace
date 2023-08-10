package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.StatusHistory;
import com.sbt.demo.services.dto.OrderDTO;
import com.sbt.demo.services.dto.StatusHistoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusHistoryMapper extends AbstractMapper<StatusHistory, StatusHistoryDTO> {

    @Autowired
    StatusHistoryMapper(ModelMapper mapper) {
        super(StatusHistory.class, StatusHistoryDTO.class);
    }

    public StatusHistory toModel(StatusHistoryDTO dto, OrderDTO parent) {
        StatusHistory statusHistory = super.toModel(dto);
        if (statusHistory != null) {
            statusHistory.setOrderId(parent.getOrderId());
        }
        return statusHistory;
    }
}
