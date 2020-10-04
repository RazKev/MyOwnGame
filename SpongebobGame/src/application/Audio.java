package application;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Audio 
{
	private static MediaPlayer mediaPlayer;
	
	public static void erstelleAudio(String path)
	{
		path = new File(path).getAbsolutePath();
		Media hit = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(hit);
		
		mediaPlayer.setOnEndOfMedia(new Runnable() 
		{ 	 
			   @Override
		       public void run() 
		       {
		         mediaPlayer.seek(Duration.ZERO);
		       }
		});
		mediaPlayer.play();
		
	}
	
	public static void stop()
	{
		mediaPlayer.stop();
	
	}
	
}
