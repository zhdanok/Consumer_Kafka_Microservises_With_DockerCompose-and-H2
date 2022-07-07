package com.github.zhdanok.consumer.repository;

import com.github.zhdanok.consumer.entitie.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
