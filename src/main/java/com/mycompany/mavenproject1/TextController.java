/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import shareable.Shareable;

/**
 *
 * @author Kamil
 */
public class TextController implements Initializable{
    @FXML
    public void importText(){
        sh = new Shareable();
        sh.setText(text.getText());
        try {
            App.setRoot("window2");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private Shareable sh;
    
    @FXML
    private TextField text;
    @FXML
    private Button button;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert text != null : "Fail to inject ";
        assert button != null : "Fail to inject ";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
