package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageManager extends Application
{
	
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("My First JavaFx Programm");
		primaryStage.setMaximized(true);
		primaryStage.setWidth(1920);
		primaryStage.setHeight(1080);
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		
		primaryStage.setScene(Menu.erstelleSzene(primaryStage));
		//Audio mainAudio = new Audio();   
		Audio.erstelleAudio("src/songs/main_backgroundsong.mp3");
		
		primaryStage.show();
		
	}
	
	public void erstelle(String[] args)
	{
		launch(args);
	}

	
	
	
	

}
