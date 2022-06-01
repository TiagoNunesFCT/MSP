package git;

import java.io.File;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	
	private boolean checkNameAndPass(String name, String pass) throws Exception{
		File file = new File ("src/git/users.txt"); 
		Scanner s = null ;
		
		s = new Scanner(file);
		ArrayList<String> fileLines = new ArrayList<String>();

		while  ( s.hasNextLine())  { 
			String line = s.nextLine();  	// We keep the line on a String 
			fileLines.add(line);
		}
		s.close ();
		int indexS = listGet.get(fileLines, "startUsers");
		int indexE = listGet.get(fileLines, "endUsers");
		for(int i = indexS+1; i < indexE; i++) {
			String[] current = fileLines.get(i).split("@@");
			if(current[0].toLowerCase().equals(usernameField.getText().toLowerCase())) {
				if(current[1].equals(passwordField.getText())) return true; else return false;
			}
		}
		return false;
	}
	
	
	public void loginButtonClicked(ActionEvent event) throws Exception {
		
		
		boolean i = checkNameAndPass(usernameField.getText(), passwordField.getText());
		if(i) {
			
			FileWriter file =  null ; 


			file =  new  FileWriter ( "src/git/config.txt" );

			// Write line by line in the file 

				file.write("isLogged" + '\n' ); 
				file.write(usernameField.getText().toLowerCase()+ '\n' ); 

			file.close();
			
			Parent homeRoot = FXMLLoader.load(getClass().getResource("homepage.fxml"));
			
			
			Scene homePage = new Scene(homeRoot, 1000, 600);

			Stage homeStage =  new Stage();
			homeStage.setTitle(usernameField.getText().toLowerCase()+"'s HomePage");
			homeStage.setScene(homePage);
			homeStage.show();
			

			
		}else {
		
		Parent loginRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene Login = new Scene(loginRoot, 400, 600);
		Stage loginStage =  new Stage();
		
		loginStage.setTitle("Log In");
		loginStage.setScene(Login);
		loginStage.show();
		}
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
		
	}
	
	public void registerButtonClicked(ActionEvent event) throws IOException {
		Parent registerRoot = FXMLLoader.load(getClass().getResource("register.fxml"));
		Scene Register = new Scene(registerRoot, 400, 600);
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
