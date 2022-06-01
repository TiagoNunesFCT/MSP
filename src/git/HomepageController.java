package git;

import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomepageController {

	
	public void logoutButtonClicked(ActionEvent event) throws IOException {
		
		FileWriter file =  null ; 


		file =  new  FileWriter ( "src/git/config.txt" );

		// Write line by line in the file 

			file.write("isLogged" + '\n' ); 
			file.write("null" + '\n' ); 

		file.close();
		
		

		Stage primaryStage =  new Stage();
		Parent mainRoot = FXMLLoader.load(getClass().getResource("prototype.fxml"));
		
		
		Scene mainPage = new Scene(mainRoot, 1000, 600);

		
		primaryStage.setTitle("Genealogika");
		primaryStage.setScene(mainPage);
		primaryStage.show();

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
