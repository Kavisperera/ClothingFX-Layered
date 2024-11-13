package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.Suppliers;
import edu.icet.entity.SuppliersEntity;
import javafx.collections.ObservableList;

public interface SuppliersBo extends SuperBo {

    ObservableList<SuppliersEntity> getAll();

    void addSupplier(Suppliers suppliers);

    void updateSupplier(Suppliers suppliers);

    void deleteSuppliers(Suppliers suppliers);
}
