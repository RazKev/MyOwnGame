package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageManager extends Application
{
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("My First JavaFx Programm");
		primaryStage.setResizable(false);
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(Menu.erstelleSzene(scene));
		//Audio mainAudio = new Audio();   
		Audio.erstelleAudio("src/songs/main_backgroundsong.mp3");
		primaryStage.show();
		
	}
	
	public void erstelle(String[] args)
	{
		launch(args);
	}

	
	
	
	

}
