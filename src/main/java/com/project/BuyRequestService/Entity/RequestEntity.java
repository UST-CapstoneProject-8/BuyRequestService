package com.project.BuyRequestService.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="buy_request_details")
public class RequestEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	
	@Column(nullable = false)
	private int carId;
	
	@Column(nullable = false)
	private int userId;
	
	@Column(nullable = false)
	private LocalDate requestDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RequestStatus status;
	
	public enum RequestStatus{
		PENDING,ACCEPTING,REJECTED
	}

}
