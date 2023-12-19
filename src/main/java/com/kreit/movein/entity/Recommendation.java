package com.kreit.movein.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_card_id", referencedColumnName = "id")
    private FilterCard filterCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "recommendation")
    private Consultation consultation;

    @Column
    private String recommendationReason;
    @Column
    private String itemDiagnosisSummary;
    @Column
    private String itemNotes;
    @Column
    private String filter1Score;
    @Column
    private String filter1Comment;
    @ElementCollection
    private List<String> filter1QualifiedIssue;
    @Column
    private String filter2Score;
    @Column
    private String filter2Comment;
    @ElementCollection
    private List<String> filter2QualifiedIssue;
    @Column
    private String filter3Score;
    @Column
    private String filter3Comment;
    @ElementCollection
    private List<String> filter3QualifiedIssue;
    @Column
    private String filter4Score;
    @Column
    private String filter4Comment;
    @ElementCollection
    private List<String> filter4QualifiedIssue;
    @Column
    private String filter5Score;
    @Column
    private String filter5Comment;
    @ElementCollection
    private List<String> filter5QualifiedIssue;
}
