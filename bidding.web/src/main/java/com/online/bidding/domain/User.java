package com.online.bidding.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USR")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString//(exclude = {"address", "phoneSet"})
@EqualsAndHashCode(exclude = {"phoneSet"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USR_ID_SEQ")
    @SequenceGenerator(name = "USR_ID_SEQ",
            sequenceName="USR_ID_SEQ",
            allocationSize = 1)
    @Column(name = "ID")
    @JsonIgnore
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ID")
    private String emailId;

    // one to one
    // unidirectional ( user -> address)
    // parent/child relationship with cascade all (existence of address object does not make sense without its user object)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDR_ID")
    private Address address;

    // one to many (a user can have one or more phone numbers)
    // bi-directional
    // parent/child (and Phone side is responsible to update the relationship)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Phone> phoneSet = new HashSet<>();

}
