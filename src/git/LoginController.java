package git;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

	
	public void loginButtonClicked(ActionEvent event) throws IOException {
		Parent loginRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene Login = new Scene(loginRoot, 200, 600);
		Stage loginStage =  new Stage();
		
		loginStage.setTitle("Log In");
		loginStage.setScene(Login);
		loginStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
		
	}
	
	public void registerButtonClicked(ActionEvent event) throws IOException {
		Parent registerRoot = FXMLLoader.load(getClass().getResource("prototype.fxml"));
		Scene Register = new Scene(registerRoot, 600, 600);
		Stage registerStage =  new Stage();
		
		registerStage.setTitle("Register");
		registerStage.setScene(Register);
		registerStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	
	public void backButtonClicked(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("prototype.fxml"));
		Scene scene = new Scene(root, 1000, 600);
		Stage stage =  new Stage();
		
		stage.setTitle("Genealogika");
		stage.setScene(scene);
		stage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
		
	}
}
