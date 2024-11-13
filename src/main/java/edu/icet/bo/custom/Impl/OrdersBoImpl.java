package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.OrdersBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.OrdersDao;
import edu.icet.entity.OrdersEntity;
import edu.icet.util.DaoType;

import java.util.List;


public class OrdersBoImpl implements OrdersBo {
    @Override
    public void createOrders(OrdersEntity order) {
        OrdersDao ordersDao= DaoFactory.getInstance().getDaoType(DaoType.ORDERS);
        ordersDao.save(order);
    }

    @Override
    public  List<OrdersEntity> changeOrderDetails(String email) {
        OrdersDao ordersDao=DaoFactory.getInstance().getDaoType(DaoType.ORDERS);
        List<OrdersEntity> searchList = ordersDao.search(email);
        return searchList;
    }


    @Override
    public void returnOrders(List<OrdersEntity> list) {
        OrdersDao ordersDao= DaoFactory.getInstance().getDaoType(DaoType.ORDERS);
        list.forEach(ordersEntity -> {
                  ordersDao.delete(ordersEntity);
                }
                );
    }
}
