package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.UsersDao;
import edu.icet.entity.ProductsEntity;
import edu.icet.entity.UserEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class UsersDaoImpl implements UsersDao {
    @Override
    public ObservableList<UserEntity> getAll() {
        ObservableList<UserEntity> userEntityObservableList= FXCollections.observableArrayList();
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        List<UserEntity> userEntities=session.createQuery("from UserEntity", UserEntity.class).list();
        userEntityObservableList.addAll(userEntities);
        session.getTransaction().commit();
        session.close();
        return userEntityObservableList;
    }

    @Override
    public boolean save(UserEntity userEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(userEntity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public void update(UserEntity userEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.update(userEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(UserEntity userEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(userEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<UserEntity> search(String email) {
        return List.of();
    }
}
