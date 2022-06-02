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

public class ParishListController {
	

	
	public ParishListController() throws FileNotFoundException {

	}

	
	
	public void initialize() throws FileNotFoundException {



	}
	

	

	
	public void backButtonClicked(ActionEvent event) throws IOException {
		Parent parishRoot = FXMLLoader.load(getClass().getResource("parishSearch.fxml"));
		Scene Parish = new Scene(parishRoot, 1000, 600);
		Stage parishStage =  new Stage();
		
		parishStage.setTitle("Search Parish Records");
		parishStage.setScene(Parish);
		parishStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
		

	}
	



	
}
