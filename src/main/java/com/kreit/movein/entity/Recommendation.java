package com.kreit.movein.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
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
    @Column
    private String filter1QualifiedIssue;
    @Column
    private String filter2Score;
    @Column
    private String filter2Comment;
    @Column
    private String filter2QualifiedIssue;
    @Column
    private String filter3Score;
    @Column
    private String filter3Comment;
    @Column
    private String filter3QualifiedIssue;
    @Column
    private String filter4Score;
    @Column
    private String filter4Comment;
    @Column
    private String filter4QualifiedIssue;
    @Column
    private String filter5Score;
    @Column
    private String filter5Comment;
    @Column
    private String filter5QualifiedIssue;
}
