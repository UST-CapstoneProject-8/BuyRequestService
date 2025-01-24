package com.project.BuyRequestService.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.project.BuyRequestService.Entity.RequestEntity;
import com.project.BuyRequestService.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	RequestRepository repository;
	
	public RequestEntity createBuyRequest(RequestEntity buyRequest) {
		buyRequest.setRequestDate(LocalDate.now());
		buyRequest.setStatus(RequestEntity.RequestStatus.PENDING);
		return repository.save(buyRequest);
	}
	
	public List<RequestEntity> getAllBuyRequests(){
		return repository.findAll(Sort.by(Sort.Direction.DESC,"requestDate"));
	}
	
	public List<RequestEntity> getBuyRequestsByCarId(int carId){
		return repository.findByCarId(carId);
	}
	
	public RequestEntity updateRequestStatus(int requestId, RequestEntity.RequestStatus status) {
		RequestEntity buyRequest=repository.findById(requestId).orElseThrow(()->new IllegalArgumentException("BuyRequest not found"));
		buyRequest.setStatus(status);
		return repository.save(buyRequest);
	}
	
	public void deleteBuyRequest(int requestId) {
		repository.deleteById(requestId);
	}
	
	
	
}
