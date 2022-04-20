package com.skcc.tes.settlement.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
public class Settlement {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;			// 관리 번호
	Date serviceDate;	// 서비스 일자
	Date settlementDate;// 정산일자
	String userId;		// 정산 받는 사용자 ID
	Integer amount;		// 정산 금액
}
