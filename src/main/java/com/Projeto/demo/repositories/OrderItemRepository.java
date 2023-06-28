package com.Projeto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projeto.demo.entities.OrdemItem;

public interface OrderItemRepository extends JpaRepository<OrdemItem, Long> {

}
