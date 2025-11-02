package com.maocq.virtualthreads.infrastructure.drivenadapter.database.account.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class AccountData {
    @Id
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    private String account;
    private String name;
    private String number;
    private BigDecimal balance;
    private String currency;
    private String type;
    private String bank;
}