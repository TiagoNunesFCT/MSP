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

public class SearchListController {
	

	
	public SearchListController() throws FileNotFoundException {

	}

	
	
	public void initialize() throws FileNotFoundException {



	}
	

	

	
	public void backButtonClicked(ActionEvent event) throws IOException {
		Parent searchRoot = FXMLLoader.load(getClass().getResource("search.fxml"));
		Scene Search = new Scene(searchRoot, 1000, 600);
		Stage searchStage =  new Stage();
		
		searchStage.setTitle("Search Relatives");
		searchStage.setScene(Search);
		searchStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
	}
	



	
}
