package com.jpapractice01.byreference.export;

import com.jpapractice01.byreference.order.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Export {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String exportDocumentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Item item;

    private long amount;
}
