package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.ProductsBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.ProductsDao;
import edu.icet.dto.Products;
import edu.icet.entity.ProductsEntity;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class ProductsBoImpl implements ProductsBo {


    @Override
    public ObservableList<ProductsEntity> getAll() {
        ProductsDao productsDao= DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        return productsDao.getAll();
    }

    @Override
    public boolean addProducts(Products products) {
    ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
    ProductsDao productsDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
    productsDao.save(entity);
     return false;
    }

    @Override
    public boolean updateProducts(Products products) {
        ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
        ProductsDao productsDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        productsDao.update(entity);
        return false;
    }

    @Override
    public void deleteProducts(Products products) {
        ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
        ProductsDao productsDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        productsDao.delete(entity);

    }
}
