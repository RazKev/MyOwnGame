package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Settings 
{
	public static Scene erstelleSzene(Stage primaryStage)
	{
		
		StackPane titlepane = new StackPane();
		VBox menuBox = new VBox();
		menuBox.setAlignment(Pos.CENTER);
		
		//Titel oder Uberschrift
		
		Text textTitle = new Text("Settings");
		textTitle.setFill(Color.WHITE);
		textTitle.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD,50));
		textTitle.setTranslateY(-150);
		titlepane.getChildren().addAll(textTitle);
		
		StackPane gamma = erstelleMenuPunkt("Gamma: ");
		StackPane credits = erstelleMenuPunkt("Credits");
		StackPane back = erstelleMenuPunkt("Back");
		
		gamma.setOnMouseClicked(event -> System.out.println("Gamma Setting Clicked!"));
		credits.setOnMouseClicked(event -> System.out.println("Creates By Me"));
		
		back.setOnMouseClicked(event -> 
		{
			primaryStage.setScene(Menu.erstelleSzene(primaryStage));
			Audio.stop();
			Audio.erstelleAudio("src/songs/main_backgroundsong.mp3");
			
		});
		
		
		fuegeTitelHinzu(menuBox, titlepane);
		
		fuegeZumMenuHinzu(menuBox, gamma, credits, back);
		
		Scene settingsScene = new Scene(menuBox,0,0);
		settingsScene.getStylesheets().add(Menu.class.getResource("Menu.css").toExternalForm());
		
		return settingsScene;
		
	}
	
	private static StackPane erstelleMenuPunkt(String name)
	{		
		StackPane stackpane = new StackPane();
		
		Stop[] stops = new Stop[4];
		stops[0] = new Stop(0,Color.DARKVIOLET);
		stops[1] = new Stop(0.1,Color.BLACK);
		stops[2] = new Stop(0.9,Color.BLACK);
		stops[3] = new Stop(1,Color.DARKVIOLET);
		
		LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		
		Rectangle bg = new Rectangle(200,30);
		bg.setOpacity(0.4);
		
		Text text = new Text(name);
		
		text.setFill(Color.DARKGRAY);
		text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD,22));
	
		
		stackpane.setAlignment(Pos.CENTER);
		
		bg.setOnMouseEntered(event -> 
		{
			bg.setFill(gradient);
			text.setFill(Color.WHITE);
		});
		
		bg.setOnMouseExited(event ->
		{
			bg.setFill(Color.BLACK);
			text.setFill(Color.DARKGRAY);
		
		});
		
		bg.setOnMousePressed(event ->
		{
			bg.setFill(Color.DARKVIOLET);
			
		});
		
		bg.setOnMouseReleased(event ->
		{
			bg.setFill(gradient);
		});
		
		stackpane.getChildren().addAll(bg,text);
		
		return stackpane;
	}
	 	
	private static Line erstelleLinie()
	{
		Line sep = new Line();
		sep.setEndX(200);
		sep.setStroke(Color.WHITE);	
		return sep;
	}

	private static void fuegeTitelHinzu(VBox menuBox,StackPane pane)
	{
		menuBox.getChildren().addAll(pane);
	}
	
	private static void fuegeZumMenuHinzu(VBox menuBox,StackPane... panes)
	{
		menuBox.getChildren().add(erstelleLinie());
		
		for (StackPane stackPane : panes) 
		{
			menuBox.getChildren().addAll(stackPane,erstelleLinie());
		}
	}

	
}
