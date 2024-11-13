package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.UsersBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.UsersDao;
import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class UsersBoImpl implements UsersBo {
    @Override
    public ObservableList<UserEntity> getAll() {
        UsersDao usersDao= DaoFactory.getInstance().getDaoType(DaoType.USERS);
         return usersDao.getAll();
    }

    @Override
    public void addUsers(User user) {
        UserEntity userEntity=new ModelMapper().map(user, UserEntity.class);
        UsersDao usersDao=DaoFactory.getInstance().getDaoType(DaoType.USERS);
        usersDao.save(userEntity);
    }

    @Override
    public void updateUsers(User user) {
        UserEntity userEntity=new ModelMapper().map(user, UserEntity.class);
        UsersDao usersDao=DaoFactory.getInstance().getDaoType(DaoType.USERS);
        usersDao.update(userEntity);
    }

    @Override
    public void deleteUsers(User user) {
        UserEntity userEntity=new ModelMapper().map(user, UserEntity.class);
        UsersDao usersDao=DaoFactory.getInstance().getDaoType(DaoType.USERS);
        usersDao.delete(userEntity);
    }
}
