package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.ProductsDao;
import edu.icet.entity.ProductsEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;


import java.util.List;

public class ProductsDaoImpl implements ProductsDao {


    @Override
    public ObservableList<ProductsEntity> getAll() {
    ObservableList<ProductsEntity> productsEntityObservableList= FXCollections.observableArrayList();
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        List<ProductsEntity> productsEntities=session.createQuery("from ProductsEntity", ProductsEntity.class).list();
        productsEntityObservableList.addAll(productsEntities);
        session.getTransaction().commit();
        session.close();
        return productsEntityObservableList;
     }

    @Override
    public boolean save(ProductsEntity entity) {
         Session session=HibernateUtil.getSession();
         session.beginTransaction();
         session.persist(entity);
          session.getTransaction().commit();
          session.close();
        return false;
    }

    @Override
    public void update(ProductsEntity productsEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.update(productsEntity);
        session.getTransaction().commit();
        session.close();
       }

    @Override
    public void delete(ProductsEntity entity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<ProductsEntity> search(String email) {
        return null;
    }
}
