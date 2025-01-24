package com.project.BuyRequestService.dto;

import java.time.LocalDate;

import com.project.BuyRequestService.Entity.RequestEntity.RequestStatus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDto {
	private int requestId;
	
	
	private int carId;
	

	private int userId;
	

	private LocalDate requestDate;
	

	private RequestStatus status;

}
