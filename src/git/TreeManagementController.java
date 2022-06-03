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

public class TreeManagementController {
	
	@FXML
	private Label usernameString;
	@FXML
	private Label userFirstNameString;

	
	private String username;
	private String userFirstName;
	
	public TreeManagementController() throws Exception {
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
		userFirstName = getName();
		
		
		
		
		usernameString = new Label(username);
		userFirstNameString = new Label(userFirstName);
		
	}

	
	
	private String getName() throws Exception {
		File file = new File("src/git/users.txt");
		Scanner s = null;

		s = new Scanner(file);
		ArrayList<String> fileLines = new ArrayList<String>();

		while (s.hasNextLine()) {
			String line = s.nextLine(); // We keep the line on a String
			fileLines.add(line);
		}
		s.close();
		int indexS = listGet.get(fileLines, "startUsers");
		int indexE = listGet.get(fileLines, "endUsers");
		for (int i = indexS + 1; i < indexE; i++) {
			String[] current = fileLines.get(i).split("@@");
			if (current[0].toLowerCase().equals(username.toLowerCase())) {
				return current[2];
			}
		}
		return "John";
	}
	
	
	public void initialize() throws FileNotFoundException {

		usernameString.setText(username);
		userFirstNameString.setText(userFirstName);

	}
	
	public void backButtonClicked(ActionEvent event) throws IOException {
		
		
		Parent homeRoot = FXMLLoader.load(getClass().getResource("homepage.fxml"));
		
		
		Scene homePage = new Scene(homeRoot, 1000, 600);

		Stage homeStage =  new Stage();
		homeStage.setTitle(username+"'s HomePage");
		homeStage.setScene(homePage);
		homeStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
		
	}
	

	

	
	public void addButtonClicked(ActionEvent event) throws IOException {
		Parent addRoot = FXMLLoader.load(getClass().getResource("addRelationship.fxml"));
		Scene Add = new Scene(addRoot, 1000, 600);
		Stage addStage =  new Stage();
		
		addStage.setTitle("AddRelationship");
		addStage.setScene(Add);
		addStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	
	public void latestButtonClicked(ActionEvent event) throws IOException {
		Parent latestRoot = FXMLLoader.load(getClass().getResource("LatestTreeChanges.fxml"));
		Scene Latest = new Scene(latestRoot, 1000, 600);
		Stage latestStage =  new Stage();
		
		latestStage.setTitle("Latest Tree Changes");
		latestStage.setScene(Latest);
		latestStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}


	
}
