package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class loginCon {
			
	@FXML
	private void login(ActionEvent event) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("../view/home.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Home");
		stage.setScene(new Scene(root));
		stage.show();
		
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
}
