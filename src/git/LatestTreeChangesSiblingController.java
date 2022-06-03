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

public class LatestTreeChangesSiblingController {
	
	private String username;
	@FXML
	private Label siblingString;
	
	private String siblingName;
	
	public LatestTreeChangesSiblingController() throws Exception {
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
		siblingName = getSibling();
		
		siblingString = new Label(siblingName);
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

		siblingString.setText(siblingName);

	}
	

	

	
	public void backButtonClicked(ActionEvent event) throws Exception {

		Parent treeManageRoot = FXMLLoader.load(getClass().getResource("treeManagementSibling.fxml"));

		Scene TreeManage = new Scene(treeManageRoot, 1000, 600);
		Stage treeManageStage =  new Stage();
		
		treeManageStage.setTitle("Tree Management");
		treeManageStage.setScene(TreeManage);
		treeManageStage.show();
		Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		currentStage.close();
		

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

	
}
