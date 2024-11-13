package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import javafx.collections.ObservableList;

public interface UsersBo extends SuperBo {
    ObservableList<UserEntity> getAll();

    void addUsers(User user);

    void updateUsers(User user);

    void deleteUsers(User user);
}
