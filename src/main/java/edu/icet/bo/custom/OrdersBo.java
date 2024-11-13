package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.entity.OrdersEntity;

import java.util.List;

public interface OrdersBo extends SuperBo {
    void createOrders(OrdersEntity order);
    List<OrdersEntity> changeOrderDetails(String email);


    void returnOrders(List<OrdersEntity> list);
}
