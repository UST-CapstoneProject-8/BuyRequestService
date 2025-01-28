package com.project.BuyRequestService.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.project.BuyRequestService.dto.CarDto;
import com.project.BuyRequestService.exception.CarNotFoundException;

import feign.FeignException;

@FeignClient(name = "car-management-service", url = "http://localhost:6969/cars")
public interface CarServiceClient {

    @GetMapping("/{carId}")
    default ResponseEntity<CarDto> getCarById(@PathVariable Long carId) {
        try {
            return ResponseEntity.ok(new RestTemplate().getForObject("http://localhost:6969/cars/" + carId, CarDto.class));
        } catch (FeignException.NotFound e) {
            throw new CarNotFoundException("Car with ID " + carId + " not found");
        }
    }
}
