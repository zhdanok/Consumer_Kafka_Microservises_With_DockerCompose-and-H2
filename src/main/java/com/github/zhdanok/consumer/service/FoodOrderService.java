package com.github.zhdanok.consumer.service;

import com.github.zhdanok.consumer.dto.FoodOrderDto;
import com.github.zhdanok.consumer.entitie.FoodOrder;
import com.github.zhdanok.consumer.repository.FoodOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;
    private final ModelMapper modelMapper;

    public void persistFoodOrder(FoodOrderDto foodOrderDto){
        FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);

        log.info("food order persisted {}", persistedFoodOrder);
    }


}