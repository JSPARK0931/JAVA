package com.study.spring.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Payment {

}
