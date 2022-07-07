package com.github.zhdanok.consumer.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zhdanok.consumer.dto.FoodOrderDto;
import com.github.zhdanok.consumer.service.FoodOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final FoodOrderService foodOrderService;

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        FoodOrderDto foodOrderDto = objectMapper.readValue(message, FoodOrderDto.class);
        foodOrderService.persistFoodOrder(foodOrderDto);
    }
}
