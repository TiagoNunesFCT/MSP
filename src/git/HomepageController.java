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
	
	
	private boolean hasSibling() throws Exception {
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
				return true;
			}
		}
		return false;
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
		
		alertStage.setTitle("Show DNA Alerts");
		alertStage.setScene(Alert);
		alertStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	
	
	public void treeManageButtonClicked(ActionEvent event) throws Exception {

		Parent treeManageRoot = hasSibling()? FXMLLoader.load(getClass().getResource("treeManagementSibling.fxml")):FXMLLoader.load(getClass().getResource("treeManagement.fxml"));

		Scene TreeManage = new Scene(treeManageRoot, 1000, 600);
		Stage treeManageStage =  new Stage();
		
		treeManageStage.setTitle("Tree Management");
		treeManageStage.setScene(TreeManage);
		treeManageStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
}
