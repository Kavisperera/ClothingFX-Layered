package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ProductsEntity {
   @Id
    private  Integer itemCode;
    private  String itemName;
    private  String size;
    private  Integer qty;
    private  Double price;
    private  String category;
}
