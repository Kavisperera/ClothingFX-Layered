package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemCode;
    @Column(name="itemName")
    private String itemName;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name="orderId",nullable = false)
    private OrdersEntity order;
}
