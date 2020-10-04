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
	public static void erstelleSzene(Scene scene)
	{
		scene.getStylesheets().clear();
		StackPane titlepane = new StackPane();
		VBox menuBox = new VBox();
		menuBox.setAlignment(Pos.CENTER);
		
		//Titel oder Uberschrift
		
		Text textTitle = new Text("SETTINGS");
		textTitle.setFill(Color.WHITE);
		textTitle.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD,70));
		textTitle.setTranslateY(-150);
		titlepane.getChildren().addAll(textTitle);
		
		StackPane gamma = erstelleMenuPunkt("GAMMA ");
		StackPane credits = erstelleMenuPunkt("CREDITS");
		StackPane back = erstelleMenuPunkt("BACK");
		
		gamma.setOnMouseClicked(event -> System.out.println("Gamma Setting Clicked!"));
		credits.setOnMouseClicked(event -> System.out.println("Creates By Me"));
		
		back.setOnMouseClicked(event -> 
		{
			Menu.erstelleSzene(scene);
			Audio.stop();
			Audio.erstelleAudio("src/songs/main_backgroundsong.mp3");
			
		});
		
		
		fuegeTitelHinzu(menuBox, titlepane);
		
		fuegeZumMenuHinzu(menuBox, gamma, credits, back);
		
		scene.getStylesheets().add(Menu.class.getResource("Settings.css").toExternalForm());
		scene.setRoot(menuBox);
	}
	
	private static StackPane erstelleMenuPunkt(String name)
	{		
		StackPane stackpane = new StackPane();
		
		Stop[] stops = new Stop[6];
		stops[0] = new Stop(0,Color.YELLOW);
		stops[1] = new Stop(0.1,Color.LIME);
		stops[2] = new Stop(0.3,Color.BLACK);
		stops[3] = new Stop(0.5,Color.BLACK);
		stops[4] = new Stop(0.9,Color.LIME);
		stops[5] = new Stop(1,Color.YELLOW);
		
		LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		
		Rectangle bg = new Rectangle(400,60);
		bg.setOpacity(0.55);
		
		
		Text text = new Text(name);
		
		text.setFill(Color.YELLOW);
		text.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,22));
	
		
		stackpane.setAlignment(Pos.CENTER);
		
		bg.setOnMouseEntered(event -> 
		{
			bg.setFill(gradient);
			text.setFill(Color.LIME);
		});
		
		bg.setOnMouseExited(event ->
		{
			bg.setFill(Color.BLACK);
			text.setFill(Color.YELLOW);
		
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
