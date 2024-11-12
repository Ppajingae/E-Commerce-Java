package com.yoong.ecommercejava2.domain.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name="black_list")
public class BlackList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "sanctions_count")
    private int sanctionsCount = 1;

    @Column(name = "is_sanctioned")
    private boolean isSanctioned = false;
}


