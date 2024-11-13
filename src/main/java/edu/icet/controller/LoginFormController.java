package edu.icet.controller;

import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.UsersBo;
import edu.icet.entity.UserEntity;
import edu.icet.util.BoType;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    boolean  isAuthenticated = false;
    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String username=txtUserName.getText();
        String password=txtPassword.getText();
        Stage stage=new Stage();
        UsersBo usersBo= BoFactory.getInstance().getBoType(BoType.USERS);
        ObservableList<UserEntity> all = usersBo.getAll();
        all.forEach(userEntity ->{
                    String dbUserName=userEntity.getUserName();
                    String dbUserPassword=userEntity.getPassword();
                        if(username.equals(dbUserName) && password.equals(dbUserPassword)){
                           isAuthenticated=true;
                    }
                }
             );
        try {
            if (username.equals("Admin") && password.equals("Admin1234")){
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/user_dashboard.fxml"))));
                stage.show();
            } else if (isAuthenticated) {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/user_dashboard.fxml"))));
                stage.show();
            } else {
                Alert incorrectUserNameOrPassword = new Alert(Alert.AlertType.ERROR, "Incorrect UserName or Password");
                incorrectUserNameOrPassword.show();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
