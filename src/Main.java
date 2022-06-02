

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import git.*;


public class Main extends Application{

	public void start(Stage primaryStage) throws Exception {
		
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
		if(username.toLowerCase().trim().equals( "null")) {
		
		Parent mainRoot = FXMLLoader.load(getClass().getResource("/git/prototype.fxml"));
		
		
		Scene mainPage = new Scene(mainRoot, 1000, 600);

		
		primaryStage.setTitle("Genealogika");
		primaryStage.setScene(mainPage);
		primaryStage.show();
		}else {
			Parent homeRoot = FXMLLoader.load(getClass().getResource("/git/homepage.fxml"));
			
			
			Scene homePage = new Scene(homeRoot, 1000, 600);

			
			primaryStage.setTitle(username+"'s HomePage");
			primaryStage.setScene(homePage);
			primaryStage.show();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);

	}

}
