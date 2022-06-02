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

public class ParishSearchController {
	

	
	public ParishSearchController() throws FileNotFoundException {

	}

	
	
	public void initialize() throws FileNotFoundException {



	}
	

	

	
	public void backButtonClicked(ActionEvent event) throws IOException {
		
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
		String username = fileLines.get(isLogged+1);
		
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
		Parent searchParishRoot = FXMLLoader.load(getClass().getResource("parishList.fxml"));
		Scene SearchParish = new Scene(searchParishRoot, 1000, 600);
		Stage searchParishStage =  new Stage();
		
		searchParishStage.setTitle("Parish Search Results");
		searchParishStage.setScene(SearchParish);
		searchParishStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}


	
}
