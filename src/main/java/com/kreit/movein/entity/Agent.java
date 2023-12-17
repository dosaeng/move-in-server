package com.kreit.movein.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Blob;

@Entity
@Getter
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String loginId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column
    private String title;
    @Lob
    private Blob profileImage;
    @Column
    private String mainTradeRegion;
    @Column
    private String introduction;
}
