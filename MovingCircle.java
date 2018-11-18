import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.canvas.*;
import javafx.stage.*;
import javafx.event.*;

/* Author: student CS 211S Irina Golovko
Date  :   06/12/2017
Homework assignment : #5 MovingCircle.
Objective : In this application "Moving Circle" 
we have red circle in the centre 
of the application and 6 buttons: 
- when we click on button "Left" circle moves to the left
with every other click by click but no further then border 
of the application;
- when we click on button "Right" circle moves to the right
no further then border of the application;
- when we click on button "Up" circle moves up
no further then border of the application;
- when we click on button "Down" circle moves down
no further then border of the application;
- when we click on button "Shrink" the size of circle 
decrease but no less then to the tiny dot;
- when we click on button "Expand" the size of circle 
increase but no further then the application boards;
/**********************************************************/

public class MovingCircle extends Application
{	
	double x = 150;
	double y = 150;
	double r = 50;
	
	public void start(Stage stg) 
	{		
		stg.setTitle("Moving Circle Program");
		FlowPane root = new FlowPane(40,100);
		root.setAlignment(Pos.TOP_CENTER);
		Scene sc = new Scene(root, 450, 450);
		stg.setScene(sc);
		
		Label label = new Label("Moving Circle");
		label.setFont(new Font("Arial", 20));
		label.setMinWidth(450);
		label.setMinHeight(50);
		
		
		
		
		label.setAlignment(Pos.CENTER);
		
		Button btnL = new Button("Left");
		Button btnR = new Button("Right");
		Button btnU = new Button("Up");
		Button btnD = new Button("Down");
		Button btnSh = new Button("Shrink");
		Button btnEx = new Button("Expand");		
		
		// we have to create special container for the circle
		// in order the circle will be in the middle of app
		Pane can = new Pane();
		can.setPrefSize(300, 300);
		
		Circle c = new Circle(x, y, r, Color.RED);
		can.getChildren().addAll(c);
		
		// with every click on Left button coordinate x 
		// will be decrease by 10 while x > 0 
		btnL.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle (ActionEvent ae)
			{	
				if (x > 0)
				{
					x = x - 10;
					c.setCenterX(x);
				}	
			}		
		});

		// with every click on Right button coordinate x 
		// will be increase by 10 while x < 300 
		btnR.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle (ActionEvent ae)
			{
				if (x < 300)
				{
					x = x + 10;
					c.setCenterX(x);
				}	
			}		
		});
		
		// with every click on Up button coordinate y 
		// will be decrease by 10 while y > 50 
		// because we need space for label and buttons
		btnU.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle (ActionEvent ae)
			
			
			
			
			{
				if (y > 50)
				{
					y = y - 10;
					c.setCenterY(y);			
				}		
			}			
		});
	
		// with every click on Down button coordinate y 
		// will be increase by 10 while y < 300 
		btnD.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle (ActionEvent ae)
			{
				if (y < 300)
				{
					y = y + 10;
					c.setCenterY(y + 10);			
				}	
			}		
		});
	
		// with every click on Expand button the size 
		// of circle will be increase by 5 while r < 110
		// in oreder that circle doesn't move the borders 
		// of app and don't touch label and buttons
		btnEx.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle (ActionEvent ae)
			{
				if (r < 110)
				{
					r = r + 5;
					c.setRadius(r);
				}
			}	
		});
		
		// with every click on Shrink button the size 
		// of circle will be decrease by 2 while r > 2 
		// to the size of tiny dot.
		btnSh.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle (ActionEvent ae)
			{
				if (r > 2)
				{
					r = r - 2;
					c.setRadius(r);
					
					
					
				}
			}	
		});
		
		root.getChildren().addAll(label, btnL, btnR, btnU, btnD, btnSh,btnEx, can);
    	stg.show();
	}
}