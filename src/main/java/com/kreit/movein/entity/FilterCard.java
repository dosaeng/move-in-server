package com.kreit.movein.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

    @OneToMany(mappedBy = "filterCard", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Recommendation> recommendations = new HashSet<>();

    @Column
    private String name;
    @Column
    private String familyType;
    @Column
    private Boolean petPresence;
    @Column
    private String minimumSize;
    @Column
    private Integer minimumRoomCount;
    @Column
    private LocalDate minimumMoveInDate;
    @Column
    private LocalDate maximumMoveInDate;
    @Column
    private Long maximumDeposit;
    @Column
    private Long maximumMonthlyCost;
    @Column
    private Long minimumMonthlyCost;
    @Column
    private String costPreferenceType;
    @Column
    private String preferredRegion;
    @Column
    private String preferredVillage;
    @Column
    private String favoritePlace1;
    @Column
    private String favoritePlace2;
    @Column
    private String favoritePlace3;
    @Column
    private String itemHouseType;
    @Column
    private String itemHouseCondition;
    @Column
    private String itemWishList;
    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private Boolean isDone;
}
