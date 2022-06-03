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

public class TreeManagementSiblingController {
	
	@FXML
	private Label usernameString;
	@FXML
	private Label userFirstNameString;
	
	@FXML
	private Label siblingString;
	
	private String username;
	private String userFirstName;
	private String siblingName;
	
	public TreeManagementSiblingController() throws Exception {
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
		siblingName = getSibling();
		
		
		
		usernameString = new Label(username);
		userFirstNameString = new Label(userFirstName);
		siblingString = new Label(siblingName);
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
	
	private String getSibling() throws Exception {
		File file = new File("src/git/trees.txt");
		Scanner s = null;

		s = new Scanner(file);
		ArrayList<String> fileLines = new ArrayList<String>();

		while (s.hasNextLine()) {
			String line = s.nextLine(); // We keep the line on a String
			fileLines.add(line);
		}
		s.close();
		int indexS = listGet.get(fileLines, "hasTree");
		for (int i = indexS + 1; i < fileLines.size(); i++) {
			String[] current = fileLines.get(i).split("@@");
			if (current[0].toLowerCase().equals(username.toLowerCase())) {
				return current[1];
			}
		}
		return "John";
	}
	
	
	public void initialize() throws FileNotFoundException {

		usernameString.setText(username);
		userFirstNameString.setText(userFirstName);
		siblingString.setText(siblingName);

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
	

	

	
	public void searchButtonClicked(ActionEvent event) throws IOException {
		Parent searchRoot = FXMLLoader.load(getClass().getResource("search.fxml"));
		Scene Search = new Scene(searchRoot, 1000, 600);
		Stage searchStage =  new Stage();
		
		searchStage.setTitle("Search Relatives");
		searchStage.setScene(Search);
		searchStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	
	public void famousButtonClicked(ActionEvent event) throws IOException {
		Parent famousRoot = FXMLLoader.load(getClass().getResource("famousPerson.fxml"));
		Scene Famous = new Scene(famousRoot, 1000, 600);
		Stage famousStage =  new Stage();
		
		famousStage.setTitle("Find Famous People");
		famousStage.setScene(Famous);
		famousStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	
	public void parishButtonClicked(ActionEvent event) throws IOException {
		Parent parishRoot = FXMLLoader.load(getClass().getResource("parishSearch.fxml"));
		Scene Parish = new Scene(parishRoot, 1000, 600);
		Stage parishStage =  new Stage();
		
		parishStage.setTitle("Search Parish Records");
		parishStage.setScene(Parish);
		parishStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}

	public void passportButtonClicked(ActionEvent event) throws IOException {
		Parent passportRoot = FXMLLoader.load(getClass().getResource("passportSearch.fxml"));
		Scene Passport = new Scene(passportRoot, 1000, 600);
		Stage passportStage =  new Stage();
		
		passportStage.setTitle("Search Passports");
		passportStage.setScene(Passport);
		passportStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	
	public void dnaAlertButtonClicked(ActionEvent event) throws IOException {
		Parent alertRoot = FXMLLoader.load(getClass().getResource("DNA Alert.fxml"));
		Scene Alert = new Scene(alertRoot, 1000, 600);
		Stage alertStage =  new Stage();
		
		alertStage.setTitle("Find Famous People");
		alertStage.setScene(Alert);
		alertStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	
}
