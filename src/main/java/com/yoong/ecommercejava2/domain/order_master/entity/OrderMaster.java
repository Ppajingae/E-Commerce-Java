package com.yoong.ecommercejava2.domain.order_master.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_master")
public class OrderMaster {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reg_dt")
    private LocalDateTime regDate;
}
