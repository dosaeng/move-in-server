package com.kreit.movein.entity;

import com.kreit.movein.enumeration.ConsultationStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommendation_id", referencedColumnName = "id")
    private Recommendation recommendation;

    @Enumerated(EnumType.STRING)
    private ConsultationStatusEnum status;

    @Column
    private LocalDate appointmentDate;
}
