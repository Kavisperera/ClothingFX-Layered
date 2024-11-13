package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Suppliers {

    private Integer supplierId;
    private  String suppliersName;
    private String suppliersContact;
    private  String suppliersAddress;
    private  String suppliersProductName;


}
