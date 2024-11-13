package edu.icet.bo;

import edu.icet.bo.custom.Impl.OrdersBoImpl;
import edu.icet.bo.custom.Impl.ProductsBoImpl;
import edu.icet.bo.custom.Impl.SuppliersBoImpl;
import edu.icet.bo.custom.Impl.UsersBoImpl;
import edu.icet.util.BoType;

public class BoFactory {

    private static BoFactory instance;

    private BoFactory(){}


    public static BoFactory getInstance() {
        return null==instance?new BoFactory():instance;
    }
    public <T extends SuperBo>T getBoType(BoType type){
        switch (type){
            case  PRODUCTS : return (T) new ProductsBoImpl();
            case SUPPLIERS:return  (T) new SuppliersBoImpl();
            case  ORDERS:return  (T)new OrdersBoImpl();
            case USERS: return  (T) new UsersBoImpl();
        }

        return null;
    }
}
