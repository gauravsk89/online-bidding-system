package com.online.bidding.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")

@Data
@NoArgsConstructor
@ToString(exclude = {"items"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_SEQ")
    @SequenceGenerator(name= "CATEGORY_ID_SEQ",
            sequenceName="CATEGORY_ID_SEQ",
            allocationSize = 1)
    @Column(name = "ID")
    @JsonIgnore
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    private Set<Item> items;


}
