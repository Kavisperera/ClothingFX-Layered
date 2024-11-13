package edu.icet.dao;




import javafx.collections.ObservableList;

import java.util.List;

public interface CrudDao <T> extends SuperDao{

    ObservableList<T> getAll();
    boolean save(T t);
    void update(T t);
    void delete(T t);
    List<T> search(String email);
}
