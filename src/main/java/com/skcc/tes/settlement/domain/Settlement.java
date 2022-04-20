package com.skcc.tes.settlement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcc.tes.settlement.dto.SettlementDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Settlement {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;			// 관리 번호
	String userId;		// 정산 받는 사용자 ID
	Integer amount;		// 정산 금액

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime serviceDate;	// 서비스 일자

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime settlementDate;// 정산일자

	public SettlementDto toDto() {
		return SettlementDto.builder()
				.id(id)
				.serviceDate(serviceDate)
				.settlementDate(settlementDate)
				.userId(userId)
				.amount(amount)
				.build();
	}

}
