package com.succulents.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Succulent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "SPECIES")
    String species;

    @Column(name = "GENRE")
    String genre;

    @Column(name = "PECULIARITY")
    String peculiarity;

    @Column(name = "POPULAR_NAME")
    String popularName;

    @Column(name = "REFERENCE_IMAGE")
    String referenceImage;

    @Column(name = "EXTRA")
    String extra;
}
