package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "picture")
public class PictureMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection
    @Column(name = "tag")
    @CollectionTable(name = "picture_tags", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<String> tags = new LinkedHashSet<>();

}