package com.study.spring.wallet.entity;

import java.time.LocalDateTime;

import com.study.spring.member.entity.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "point_history")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class PointHistory {

}
