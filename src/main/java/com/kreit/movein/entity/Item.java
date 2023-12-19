package com.kreit.movein.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "agent_id")
    private Agent agent;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Recommendation> recommendations = new HashSet<>();

    @Column
    private String houseType;
    @Column
    private String name;
    @Column
    private String region;
    @Column
    private String address;
    @Lob
    private Blob photo;
    @Column
    private Float dedicatedArea;
    @Column
    private Float supplyArea;
    @Column
    private Integer roomCount;
    @Column
    private Integer toiletCount;
    @Column
    private Integer floor;
    @Column
    private Integer buildingFloor;
    @Column
    private String mainSpaceDirection;
    @Column
    private LocalDate approvalDate;
    @Column
    private LocalDate registrationDate;
    @Column
    private Long deposit;
    @Column
    private Long monthlyRent;
    @Column
    private Long maintenanceCost;
    @Column
    private Long monthlyCost;
    @Column
    private Boolean costAdjustability;
    @Column
    private LocalDate minimumMoveInDate;
    @Column
    private LocalDate maximumMoveInDate;
    @Column
    @CreatedDate
    private LocalDateTime createdAt;
}
