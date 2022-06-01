package git;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomepageController {
	
	@FXML
	private Label usernameString;
	
	private String username;
	
	public HomepageController() throws FileNotFoundException {
		File file = new File ("src/git/config.txt"); 
		Scanner s = null ;
		
		s = new Scanner(file);
		ArrayList<String> fileLines = new ArrayList<String>();

		while  ( s.hasNextLine())  { 
			String line = s.nextLine();  	// We keep the line on a String 
			fileLines.add(line);
		}
		s.close ();
		
		
		int isLogged = listGet.get(fileLines, "isLogged");
		if (isLogged < 0) throw new NullPointerException();
		username = fileLines.get(isLogged+1);
		
		usernameString = new Label(username);
	}

	
	
	public void initialize() throws FileNotFoundException {

		usernameString.setText(username);

	}
	
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
