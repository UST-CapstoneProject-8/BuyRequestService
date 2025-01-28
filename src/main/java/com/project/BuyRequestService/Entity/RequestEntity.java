package com.project.BuyRequestService.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.BuyRequestService.Entity.RequestEntity.RequestStatus;

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
	private Long requestId;
	
	@Column(nullable = false)
	private Long carId;
	
	@Column(nullable = false)
	private Long userId;
	
	@Column(nullable = false)
	private LocalDate requestDate;
	
	@Enumerated(EnumType.STRING)
//	@JsonIgnore
	private RequestStatus status = RequestStatus.PENDING;
	
	public enum RequestStatus{
		PENDING,ACCEPTING,REJECTED
	}

}
