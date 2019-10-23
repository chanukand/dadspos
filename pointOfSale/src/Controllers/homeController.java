package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import plugin.ViewManager;

public class homeController implements Initializable {
	
	@FXML public ScrollPane body;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void addCategory(ActionEvent event) throws IOException {
		body.setContent(FXMLLoader.load(getClass().getResource("../view/category.fxml")));
	}
	
	public void item(ActionEvent event) throws IOException {
		body.setContent(FXMLLoader.load(getClass().getResource("../view/login.fxml")));
	}
	
}
