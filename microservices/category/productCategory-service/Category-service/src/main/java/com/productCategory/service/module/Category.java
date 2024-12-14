package com.productCategory.service.module;

import lombok.Data;
import javax.persistence.*;



@Entity
@Data
@Table(name = "product_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;



}
