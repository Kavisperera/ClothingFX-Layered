package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Products {

    private  Integer itemCode;
    private  String itemName;
    private  String size;
    private  Integer qty;
    private  Double price;
    private  String category;


}
