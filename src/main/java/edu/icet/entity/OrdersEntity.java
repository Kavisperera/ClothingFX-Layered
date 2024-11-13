package edu.icet.entity;

import edu.icet.dto.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private  Integer orderId;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "email")

    private String email;
    @Column(name = "contactNumber")
    private String contactNumber;
    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY,mappedBy = "order")
    private List<CartEntity> orders;
    @Column(name = "netTotal")
    private  Double netTotal;
    @Column(name="Date")
    private LocalDate currentDate;
}
