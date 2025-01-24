package com.project.BuyRequestService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.BuyRequestService.Entity.RequestEntity;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Integer>{
	List<RequestEntity> findByCarId(int carId);

}
