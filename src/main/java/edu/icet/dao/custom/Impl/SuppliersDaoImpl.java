package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.SuppliersDao;
import edu.icet.entity.ProductsEntity;
import edu.icet.entity.SuppliersEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class SuppliersDaoImpl implements SuppliersDao {

    @Override
    public ObservableList<SuppliersEntity> getAll() {
        ObservableList<SuppliersEntity> suppliersEntityObservableList= FXCollections.observableArrayList();
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        List<SuppliersEntity> suppliersEntities=session.createQuery("from SuppliersEntity", SuppliersEntity.class).list();
        suppliersEntityObservableList.addAll(suppliersEntities);
        session.getTransaction().commit();
        session.close();
        return suppliersEntityObservableList;
    }

    @Override
    public boolean save(SuppliersEntity suppliersEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(suppliersEntity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public void update(SuppliersEntity suppliersEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.update(suppliersEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(SuppliersEntity entity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<SuppliersEntity> search(String email) {
return null;
    }
}
