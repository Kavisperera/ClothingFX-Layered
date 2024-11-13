package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.OrdersDao;
import edu.icet.entity.CartEntity;
import edu.icet.entity.OrdersEntity;
import edu.icet.entity.ProductsEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    @Override
    public ObservableList<OrdersEntity> getAll() {
        return null;
    }

    @Override
    public boolean save(OrdersEntity ordersEntity) {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
         session.persist(ordersEntity);
        for (CartEntity cartEntity : ordersEntity.getOrders()) {
            Integer productId = getProductIdByName(cartEntity.getItemName());
            if (productId != null) {
                ProductsEntity product = session.get(ProductsEntity.class, productId);
                product.setQty(product.getQty() - cartEntity.getQty());
                session.update(product);
            }
        }
         session.getTransaction().commit();
        session.close();
        return false;
    }
    private Integer getProductIdByName(String itemName) {
        Session session = HibernateUtil.getSession();
        try {
            ProductsEntity product = session.createQuery("FROM ProductsEntity WHERE itemName = :itemName", ProductsEntity.class)
                    .setParameter("itemName", itemName)
                    .uniqueResult();
            return product != null ? product.getItemCode() : null;
        } finally {
            session.close();

        }
    }

    @Override
    public void update(OrdersEntity ordersEntity) {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        OrdersEntity persistentOrder = session.get(OrdersEntity.class, ordersEntity.getOrderId());

        if (persistentOrder != null) {

            for (CartEntity cartEntity : persistentOrder.getOrders()) {
                session.update(cartEntity);
            }
            session.update(persistentOrder);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(OrdersEntity ordersEntity) {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        OrdersEntity persistentOrder = session.get(OrdersEntity.class, ordersEntity.getOrderId());

        if (persistentOrder != null) {

            for (CartEntity cartEntity : persistentOrder.getOrders()) {
                session.delete(cartEntity);
            }


            session.delete(persistentOrder);
        }

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<OrdersEntity>  search(String email) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        return session.createQuery("FROM OrdersEntity WHERE email=:email", OrdersEntity.class)
                .setParameter("email", email)
                .getResultList();
    }


}
