package com.example.project02.entity;

import com.example.project02.exception.OutOfStockException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String img1;

    private String img2;

    private String img3;

    private double price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private LocalDateTime registerDate;

    private LocalDateTime fieldPredictedSaleEndDate;

//    조회수
    private int click;


    public void removeStock(int quantity) {
        int stock = stockQuantity - quantity;
        if (stock < 0) {
            throw new OutOfStockException("재고가 부족합니다.");
        } else {
            stockQuantity = stock;
        }
    }



}
