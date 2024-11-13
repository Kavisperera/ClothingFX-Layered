package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.OrdersBo;
import edu.icet.bo.custom.ProductsBo;
import edu.icet.bo.custom.SuppliersBo;
import edu.icet.bo.custom.UsersBo;
import edu.icet.dto.*;
import edu.icet.entity.*;
import edu.icet.util.BoType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class UserDashBoardController implements Initializable {


    private  AnchorPane loadPage;

    @FXML
    private AnchorPane ordersPage;

    @FXML
    private AnchorPane dashBoardPage;

    @FXML
    private JFXComboBox<String> cmbCategory;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colUserAddress;

    @FXML
    private TableColumn<?, ?> colCartItemName;

    @FXML
    private TableColumn<?, ?> colCartQty;

    @FXML
    private TableColumn<?, ?> colCartTotal;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colISupplierID;

    @FXML
    private TableColumn<?, ?> colISupplierName;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colNetTotOrder;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colPlaceOrderCategory;

    @FXML
    private TableColumn<?, ?> colPlaceOrderItemCode;

    @FXML
    private TableColumn<?, ?> colPlaceOrderItemName;

    @FXML
    private TableColumn<?, ?> colPlaceOrderPrice;

    @FXML
    private TableColumn<?, ?> colPlaceOrderQty;

    @FXML
    private TableColumn<?, ?> colPlaceOrderSize;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colProduct;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private Label lblItemName;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblnetTotal;

    @FXML
    private AnchorPane placeOrderPage;

    @FXML
    private AnchorPane productsPage;

    @FXML
    private Spinner<Integer> spinQty;

    @FXML
    private AnchorPane suppliersPage;

    @FXML
    private TableView<Cart> tblCartView;

    @FXML
    private TableView<OrdersEntity> tblOrders;

    @FXML
    private TableView<ProductsEntity> tblPlaceOrderView;

    @FXML
    private TableView<ProductsEntity> tblProductView;

    @FXML
    private TableView<SuppliersEntity> tblSupplierView;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtCustomerContact;

    @FXML
    private JFXTextField txtCustomerEmail;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemName;


    @FXML
    private JFXTextField txtUserContact;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtUserAddress;


    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private TextField txtSearchOrderEmail;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtSupplierId;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtUpdateCustomer;

    @FXML
    private JFXTextField txtUpdateCustomerContact;

    @FXML
    private JFXTextField txtUpdateCustomerEmail;

    @FXML
    private TableView<UserEntity> tblDashboardView;




    @FXML
    void btnAddProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.addProducts(products);
        loadTable();


    }

    @FXML
    void btnAddUserOnAction(ActionEvent event) {
        User user= new User(
             null,
             txtUserName.getText(),
             txtPassword.getText(),
             txtUserContact.getText(),
             txtUserAddress.getText()
        );

        UsersBo usersBo=BoFactory.getInstance().getBoType(BoType.USERS);
        usersBo.addUsers(user);
        loadDashBoardTable();
    }

    @FXML
    void btnDeleteUserOnAction(ActionEvent event) {
//        User user= new User(
//                null,
//                txtUserName.getText(),
//                txtPassword.getText(),
//                txtUserContact.getText(),
//                txtUserAddress.getText()
//        );
//        UsersBo usersBo=BoFactory.getInstance().getBoType(BoType.USERS);
//        usersBo.deleteUsers(user);
//        loadDashBoardTable();
    }
    @FXML
    void btnUpdateUserOnAction(ActionEvent event) {
//        User user= new User(
//                null,
//                txtUserName.getText(),
//                txtPassword.getText(),
//                txtUserContact.getText(),
//                txtUserAddress.getText()
//        );
//        UsersBo usersBo=BoFactory.getInstance().getBoType(BoType.USERS);
//        usersBo.updateUsers(user);
//        loadDashBoardTable();
    }


    @FXML
    void btnUpdateProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.updateProducts(products);
        loadTable();

    }

    @FXML
    void btnDeleteProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.deleteProducts(products);
        loadTable();
    }
    @FXML
    void btnAddSupplierOnAction(ActionEvent event) {
        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
                );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.addSupplier(suppliers);
        loadSupplierTable();
    }

    @FXML
    void btnUpdateSupplierOnAction(ActionEvent event) {
        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
        );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.updateSupplier(suppliers);
        loadSupplierTable();
    }
    @FXML
    void btnDeleteSupplierOnAction(ActionEvent event) {

        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
        );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.deleteSuppliers(suppliers);
        loadSupplierTable();
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
        loadPage.setVisible(false);
        loadPage=dashBoardPage;
        loadPage.setVisible(true);


        loadDashBoardTable();
    }

    private void loadDashBoardTable() {
        UsersBo usersBo=BoFactory.getInstance().getBoType(BoType.USERS);
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colUserAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblDashboardView.setItems(usersBo.getAll());
    }


    @FXML
    void btnMangeEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {
        loadPage.setVisible(false);
        loadPage=ordersPage;
        loadPage.setVisible(true);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws MessagingException {
        LocalDate currentDate=LocalDate.now();
          String recieptEmail=txtCustomerEmail.getText();
        sendEmail(recieptEmail);
        List<CartEntity> orderList = new ArrayList<>();
              OrdersEntity order = new OrdersEntity(
            null,
                txtCustomerName.getText(),
                txtCustomerEmail.getText(),
                txtCustomerContact.getText(),
                orderList,
                Double.parseDouble(lblnetTotal.getText()),
                currentDate
        );
           carts.forEach(cart -> {
            CartEntity cartEntity = new CartEntity();
            cartEntity.setItemName(cart.getItemName());
            cartEntity.setQty(cart.getQty());
            cartEntity.setTotal(cart.getTotal());
            cartEntity.setOrder(order);
            orderList.add(cartEntity);
        });

        OrdersBo ordersBo = BoFactory.getInstance().getBoType(BoType.ORDERS);
        ordersBo.createOrders(order);
    }

    private void sendEmail(String recieptEmail) throws MessagingException {

        Properties properties=new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myEmail="tumiraduli@gmail.com";
        String password="yqrm tjue dogq qsqg";
        javax.mail.Session session = javax.mail.Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(myEmail, password);
                    }
                }
        );

        Message message=prepareMessage(session,myEmail,recieptEmail,carts);
        if(message!=null){
            Alert emailSentSuccessfully = new Alert(Alert.AlertType.INFORMATION, "Email Sent Successfully");
            emailSentSuccessfully.showAndWait();
        }else{
            Alert pleaseTryAgain = new Alert(Alert.AlertType.ERROR, "Please Try Again");
            pleaseTryAgain.showAndWait();
        }
        Transport.send(message);
    }

    private Message prepareMessage(Session session, String myEmail, String recieptEmail, ObservableList<Cart> carts) throws MessagingException{
        Message message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO,new InternetAddress[]{
                    new InternetAddress(recieptEmail)
            });
            message.setSubject(" Your Bill");
            String name=txtCustomerName.getText();
            StringBuilder emailBody=new StringBuilder();
            emailBody.append("Dear Cutomer"+name+",\n\n");
            emailBody.append("Thank You For Your Order.here Your Bill Details:\n\n");
            emailBody.append(String.format("%-20s %-10s %-10s\n", "Item Name", "Quantity", "Total"));


            emailBody.append("-------------------------------------------------------------\n");
            for(Cart item:carts){
                emailBody.append(String.format("%-20s %-10d %-10.2f\n", item.getItemName(), item.getQty(), item.getTotal()));

            }

            emailBody.append("-----------------------------------------------------\n");
            emailBody.append(String.format("Total Amount: %.2f\n",netTot));
            emailBody.append("\nThank you for your business!\n");
            message.setText(emailBody.toString());

            return  message;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }


    @FXML
    void btnPlaceOrderPageOnAction(ActionEvent event) {
        loadPage.setVisible(false);
        loadPage=placeOrderPage;
        loadPage.setVisible(true);
        ProductsBo productsBo= BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        colPlaceOrderItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colPlaceOrderItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colPlaceOrderSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colPlaceOrderQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPlaceOrderPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colPlaceOrderCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tblPlaceOrderView.setItems(productsBo.getAll());

    }

    ObservableList<Cart> carts=FXCollections.observableArrayList();
    Double netTot=0.0;
    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        Cart cart=new Cart(lblItemName.getText(),spinQty.getValue(),Double.parseDouble(lblTotal.getText()));
        carts.add(cart);
        colCartItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colCartQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCartTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        tblCartView.setItems(carts);
        netTot+=Double.parseDouble(lblTotal.getText());
        lblnetTotal.setText(netTot.toString());

    }


    @FXML
    void btnProductsPageOnAction(ActionEvent event) {
            loadPage.setVisible(false);
            loadPage=productsPage;
            loadPage.setVisible(true);
            loadTable();



    }

    private void loadTable() {
        ProductsBo productsBo= BoFactory.getInstance().getBoType(BoType.PRODUCTS);


        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tblProductView.setItems(productsBo.getAll());
    }


    @FXML
    void btnSuppliersPageOnAction(ActionEvent event) {
            loadPage.setVisible(false);
            loadPage=suppliersPage;
            loadPage.setVisible(true);
            loadSupplierTable();

    }

    private void loadSupplierTable() {
        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        colISupplierID.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colISupplierName.setCellValueFactory(new PropertyValueFactory<>("suppliersName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("suppliersContact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("suppliersAddress"));
        colProduct.setCellValueFactory(new PropertyValueFactory<>("suppliersProductName"));
        tblSupplierView.setItems(suppliersBo.getAll());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage=productsPage;
        loadPage.setVisible(true);

        ObservableList<String> category= FXCollections.observableArrayList();
        category.add("Gents");
        category.add("Ladies");
        category.add("Kids");
        cmbCategory.setItems(category);
        SpinnerValueFactory<Integer> valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50);
        valueFactory.setValue(1);
        spinQty.setValueFactory(valueFactory);

        spinQty.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer oldValue, Integer newValue) {
                updateCartTot();
            }
        });

        tblProductView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        });
        tblSupplierView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToSuppliersValue(newValue);
            }
        });
        tblPlaceOrderView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToPlaceOrderValue(newValue);
            }
        });
    }
        Double price=0.0;
    private void updateCartTot() {
        Integer qty=spinQty.getValue();
        Double tot=price*qty;
        lblTotal.setText(tot.toString());
    }

    private void setTextToPlaceOrderValue(ProductsEntity newValue) {
            lblItemName.setText(newValue.getItemName());
            lblTotal.setText(newValue.getPrice().toString());
            price= newValue.getPrice();
    }

    private void setTextToSuppliersValue(SuppliersEntity newValue) {
        txtSupplierId.setText(newValue.getSupplierId().toString());
        txtSupplierName.setText(newValue.getSuppliersName());
        txtContact.setText(newValue.getSuppliersContact());
        txtAddress.setText(newValue.getSuppliersAddress());
        txtProductName.setText(newValue.getSuppliersProductName());
    }

    private void setTextToValues(ProductsEntity newValue) {

         txtItemCode.setText(newValue.getItemCode().toString());
         txtItemName.setText(newValue.getItemName());
         txtSize.setText(newValue.getSize());
         txtPrice.setText(newValue.getPrice().toString());
         txtQuantity.setText(newValue.getQty().toString());
         cmbCategory.setValue(newValue.getCategory());
    }

    public void btnOrderSearch(ActionEvent actionEvent) {
      String email= txtSearchOrderEmail.getText();
      OrdersBo ordersBo=BoFactory.getInstance().getBoType(BoType.ORDERS);
      List<OrdersEntity> list=ordersBo.changeOrderDetails(email);
      ObservableList<OrdersEntity> ordersEntities=FXCollections.observableArrayList();
      ordersEntities.addAll(list);
      colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
      colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
      colNetTotOrder.setCellValueFactory(new PropertyValueFactory<>("netTotal"));
      colDate.setCellValueFactory(new PropertyValueFactory<>("currentDate"));
        tblOrders.setItems(ordersEntities);
      list.forEach(ordersEntity -> {
          txtUpdateCustomer.setText(ordersEntity.getCustomerName());
          txtUpdateCustomerEmail.setText(ordersEntity.getEmail());
          txtUpdateCustomerContact.setText(ordersEntity.getContactNumber());
           });

    }



    public void btnReturnOrderOnAction(ActionEvent actionEvent) {
        String email= txtSearchOrderEmail.getText();
        OrdersBo ordersBo=BoFactory.getInstance().getBoType(BoType.ORDERS);
        List<OrdersEntity> list=ordersBo.changeOrderDetails(email);
        ordersBo.returnOrders(list);
    }



}
