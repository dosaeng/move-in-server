package com.kreit.movein.entity;

import com.kreit.movein.dto.FilterCardDto;
import com.kreit.movein.enumeration.FilterCardStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @ElementCollection
    private List<String> favoritePlace1;
    @ElementCollection
    private List<String> favoritePlace2;
    @ElementCollection
    private List<String> favoritePlace3;
    @ElementCollection
    private List<String> itemHouseType;
    @ElementCollection
    private List<String> itemHouseCondition;
    @ElementCollection
    private List<String> itemWishList;
    @Enumerated(EnumType.STRING)
    private FilterCardStatusEnum status;
    @Column
    private LocalDate recommendationDueDate;
    @Column
    private String toBusStopMinutes;
    @Column
    private String toTrainStationMinutes;
    @Column
    private String toTerminalMinutes;
    @Column
    private String parking;
    @ElementCollection
    private List<String> livingOptions;
    @ElementCollection
    private List<String> communityLife;
    @ElementCollection
    private List<String> livingInfra;
    @ElementCollection
    private List<String> educationLife;
    @ElementCollection
    private List<String> deliveryLife;

    public void update(FilterCardDto dto) {
        this.name = dto.name();
        this.familyType = dto.familyType();
        this.petPresence = dto.petPresence();
        this.minimumSize = dto.minimumSize();
        this.minimumRoomCount = dto.minimumRoomCount();
        this.minimumMoveInDate = dto.minimumMoveInDate();
        this.maximumMoveInDate = dto.maximumMoveInDate();
        this.maximumDeposit = dto.maximumDeposit();
        this.maximumMonthlyCost = dto.maximumMonthlyCost();
        this.minimumMonthlyCost = dto.minimumMonthlyCost();
        this.costPreferenceType = dto.costPreferenceType();
        this.preferredRegion = dto.preferredRegion();
        this.preferredVillage = dto.preferredVillage();
        this.favoritePlace1 = dto.favoritePlace1();
        this.favoritePlace2 = dto.favoritePlace2();
        this.favoritePlace3 = dto.favoritePlace3();
        this.itemHouseType = dto.itemHouseType();
        this.itemHouseCondition = dto.itemHouseCondition();
        this.itemWishList = dto.itemWishList();
        this.recommendationDueDate = dto.recommendationDueDate();
        this.toBusStopMinutes = dto.toBusStopMinutes();
        this.toTrainStationMinutes = dto.toTrainStationMinutes();
        this.toTerminalMinutes = dto.toTerminalMinutes();
        this.parking = dto.parking();
        this.livingOptions = dto.livingOptions();
        this.communityLife = dto.communityLife();
        this.livingInfra = dto.livingInfra();
        this.educationLife = dto.educationLife();
        this.deliveryLife = dto.deliveryLife();
    }

    public void open() {
        this.status = FilterCardStatusEnum.OPEN;
        this.recommendationDueDate = LocalDate.now(ZoneId.of("Asia/Seoul")).plusDays(7);
    }

    public void close() {
        this.status = FilterCardStatusEnum.CLOSE;
    }
}