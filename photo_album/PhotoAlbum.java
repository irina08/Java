import javafx.application.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.*;

/* Author: student CS 211S Irina Golovko
Date  :   14/12/2017
Homework assignment : #6 PhotoAlbum.
Objective : In this application "Photo Album" 
we have a photo album of different dogs.
When we click on any name of dog we can see 
a photo of this dog on the screen near the scroll bar.
/**********************************************************/

public class PhotoAlbum extends Application
{	
	
	public void start(Stage stg) 
	{		
		stg.setTitle("Demo: Photo Album of Dogs");
		
		// we need vertical space between children of FlowPane:
		// label and HBox
		FlowPane root = new FlowPane(0,50);
		root.setAlignment(Pos.TOP_CENTER);		
		Scene sc = new Scene(root, 500, 400);
		stg.setScene(sc);
		
		Label label = new Label("Photo Album");
		label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		label.setTextFill(Color.GREEN);
		label.setAlignment(Pos.CENTER);
			
		ListView <String> lv;
		ObservableList<String> ol = FXCollections.observableArrayList(
			"kolli", "mops", "beagle", "caucasian_Shepherd_Dog", "chau-chau", 
			"chihuahua", "german_Shepherd", "golden_retriver", 
			"siberian_husky", "papilon", "sharpey");
		lv = new ListView<String>(ol);
		lv.setPrefSize(80, 120);
		
		ImageView iv = new ImageView();
		
		
		
		
		// we need horizontal space between children 
		// of HBox: ListView - lv and ImageView - iv
		HBox box = new HBox(30);
		box.setPrefWidth(450);
		box.getChildren().addAll(lv, iv);
		
		lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
			{
				public void changed (ObservableValue<? extends String> changed, String oldVal, String newVal)
				{
					Image img = new Image(newVal + ".jpg", 300, 250, true, true);
					iv.setImage(img);
				}
			});
		
		root.getChildren().addAll(label, box);
    	stg.show();
	}
}