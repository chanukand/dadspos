package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import plugin.ViewManager;

public class login extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	private Button btnLog;
	
	@Override
	public synchronized void init(){
		load("view", "category");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Login Now");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	 private void load(String module, String name){
	    try {
	        ViewManager.getInstance().put(
	                    name,
	                    FXMLLoader.load(getClass().getResource("../"+module+"/"+name+".fxml"))
	            );
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	  }
}
