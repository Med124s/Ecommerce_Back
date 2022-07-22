package com.start.ecom.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double currentPrice;
    private String description;
    private boolean available;
    private boolean promotion;
    @Transient
    private int quantity = 1;
    private boolean selected;
    private String productImage;
    @ManyToOne
    private Categories cate;

}
