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
	
//	public RequestEntity updateRequestStatus(int requestId, RequestEntity.RequestStatus status) {
//		RequestEntity buyRequest=repository.findById(requestId).orElseThrow(()->new IllegalArgumentException("BuyRequest not found"));
//		buyRequest.setStatus(status);
//		return repository.save(buyRequest);
//	}
	
	public void deleteBuyRequest(int requestId) {
		repository.deleteById(requestId);
	}
	
	public RequestEntity updateRequestStatus(int requestId, RequestEntity.RequestStatus status) {
	    // Find the request to update
	    RequestEntity buyRequest = repository.findById(requestId)
	            .orElseThrow(() -> new IllegalArgumentException("BuyRequest not found"));

	    // Update the status of the current request
	    buyRequest.setStatus(status);
	    RequestEntity updatedRequest = repository.save(buyRequest);

	    // If the request is accepted, reject other requests for the same car
	    if (status == RequestEntity.RequestStatus.ACCEPTING) {
	        rejectOtherRequestsForCar(buyRequest.getCarId(), requestId);
	    }

	    return updatedRequest;
	}

	// Helper method to reject other requests for the same car
	private void rejectOtherRequestsForCar(int carId, int acceptedRequestId) {
	    // Fetch all requests for the car
	    List<RequestEntity> requests = repository.findByCarId(carId);

	    // Filter out the accepted request and reject others
	    for (RequestEntity request : requests) {
	        if (request.getRequestId() != acceptedRequestId && request.getStatus() != RequestEntity.RequestStatus.REJECTED) {
	            request.setStatus(RequestEntity.RequestStatus.REJECTED);
	            repository.save(request);
	        }
	    }
	}

	
	
}
