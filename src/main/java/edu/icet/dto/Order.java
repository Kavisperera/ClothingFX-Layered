package edu.icet.dto;

import edu.icet.entity.CartEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private  Integer orderId;
    private String customerName;
    private String email;
    private String contactNumber;
    private List<CartEntity> orders;
    private  Double netTotal;
    private LocalDate currentDate;

}
