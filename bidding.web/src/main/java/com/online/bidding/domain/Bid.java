package com.online.bidding.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM_BIDS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "item")
@Builder
@EqualsAndHashCode(of = {"bidAmount, item"}, callSuper = false)
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BID_ID_SEQ")
    @SequenceGenerator(name= "BID_ID_SEQ",
            sequenceName="BID_ID_SEQ",
            allocationSize = 1)
    @Column(name = "BID_ID")
    private Long bidId;

    @Column(name = "BID_AMOUNT")
    private BigDecimal bidAmount;

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;


}
