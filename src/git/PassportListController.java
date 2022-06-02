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

public class PassportListController {
	

	
	public PassportListController() throws FileNotFoundException {

	}

	
	
	public void initialize() throws FileNotFoundException {



	}
	

	

	
	public void backButtonClicked(ActionEvent event) throws IOException {
		Parent passportRoot = FXMLLoader.load(getClass().getResource("passportSearch.fxml"));
		Scene Passport = new Scene(passportRoot, 1000, 600);
		Stage passportStage =  new Stage();
		
		passportStage.setTitle("Search Passports");
		passportStage.setScene(Passport);
		passportStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();

	}
	



	
}
