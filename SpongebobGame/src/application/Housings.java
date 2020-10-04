package application;

import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Housings 
{

	
	public static Scene erstelleSzene(Stage primaryStage)
	{
		AnchorPane anchorPane = new AnchorPane();
		
		Button button1 = new Button("SpongeBob Housing");
		button1.setMinSize(200, 200);
		
		button1.setOnAction(e -> primaryStage.setScene(Menu.erstelleSzene(primaryStage)));   
		
		anchorPane.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
	        button1.setLayoutX(newValue.doubleValue()/2 - (button1.widthProperty().getValue() / 2));
	    });
		anchorPane.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
	        button1.setLayoutY(newValue.doubleValue()/2 - (button1.heightProperty().getValue() / 2));
	    });
	
		button1.setTranslateX(230);
		button1.setTranslateY(0);
		
		VBox layout1 = new VBox(20);     
		anchorPane.getChildren().addAll(button1);
		
		
		Scene housingsScene = new Scene(anchorPane, 300, 250);
		housingsScene.getStylesheets().add(Menu.class.getResource("Housings.css").toExternalForm());
		
		return housingsScene;
		
	}
	
	
}
