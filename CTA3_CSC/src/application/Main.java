package application;
	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

//Entry point of a JavaFX application is the Application class, so our Main class needs to inherit the Application class
public class Main extends Application {
	String[] colors = new String[]{"green","lightgreen","lightseagreen","olivedrab","seagreen","palegreen","mediumspringgreen","lime","limegreen","mediumaquamarine","mediumseagreen","chartreuse","aquamarine","darkseagreen","greenyellow","forestgreen","darkgreen","darkolivegreen","lawngreen"}; 
	//start() is an abstract method found in the Application class and needs to be defined into a concrete method for our application
	//the start method needs an argument with data type Stage
	@Override
	public void start(Stage primaryStage) {
		try {
			File myFile = new File("log.txt"); 
			myFile.createNewFile();
			//In order to create a typical JavaFX application you need the following: 
			//1. Prepare a Scene with the required dimensions and add the scene graph "root" to it 
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			//2. Prepare a Scene with the required nodes. A node may include Geometrical objects, UI controls, containers, media elements. 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//3. Prepare a stage and add the scene to the stage and display the contents of the stage
			primaryStage.setScene(scene);
			primaryStage.setTitle("Menu Application");
			primaryStage.show();
			
			//How to create a Menu component. First create a Menu object 
			Menu m = new Menu("Menu"); 
			//Define menu items to be included
			MenuItem m1 = new MenuItem("Print Date"); 
			MenuItem m2 = new MenuItem("Save to Log"); 
			MenuItem m3 = new MenuItem("Fun Thing"); 
			MenuItem m4 = new MenuItem("Close"); 
			//Add menu items to Menu Object
			m.getItems().add(m1);
			m.getItems().add(m2); 
			m.getItems().add(m3); 
			m.getItems().add(m4); 
			//Create the Menu Bar and add Menu object into the Menu Bar
			MenuBar mb = new MenuBar(); 
			mb.getMenus().add(m); 
			//Add the Menu bar to the Scene layout 
			root.setTop(mb);
			
			
			//Creating Vbox for nodes in center of Scene
			VBox vbox = new VBox(8); 
			//Creating text field node and set node center of Scene
			Label dateLabel = new Label("Date"); 
			TextField txtBox = new TextField();
			Label userNotice = new Label("Date logged to fie.");
			vbox.getChildren().addAll(dateLabel, txtBox, userNotice); 
			vbox.setAlignment(Pos.CENTER);
			userNotice.setVisible(false);
			txtBox.setMaxWidth(200); 
			root.setCenter(vbox);
			
			/*
			userNotice.setVisible(false);
			root.setCenter(txtBox);
			*/

			
			//Action event creation
			EventHandler<ActionEvent> eventm1 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					userNotice.setVisible(false);
					LocalDateTime date = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyy HH:mm:ss");
					String text = date.format(formatter); 
					txtBox.setText(text);
				}
			}; 
			EventHandler<ActionEvent> eventm2 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) { 
					try {
						FileOutputStream outputStream = new FileOutputStream(myFile,true); 
						if(txtBox.getText() != "") {
							String text = txtBox.getText()+"\n"; 
							byte[] array = text.getBytes(); 
							outputStream.write(array);
							outputStream.close(); 
							txtBox.clear();
							userNotice.setVisible(true);
						} else {
							userNotice.setVisible(false);
							outputStream.close(); 
							return; 
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}; 
			EventHandler<ActionEvent> eventm3 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					//define range for random index
					int max = colors.length; 
					int min = 0; 
					int range = max-min; 
					int randIndex = (int)(Math.random()*range)+min;
					String randColor = colors[randIndex]; 
					String s = String.format("-fx-background-color: %s", randColor); 
					root.setStyle(s);
					m3.setText(randColor); 
				}
			}; 
			EventHandler<ActionEvent> eventm4 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					primaryStage.close();  
				}
			}; 
			
			//Set Action events onto menu items
			m1.setOnAction(eventm1);
			m2.setOnAction(eventm2);
			m3.setOnAction(eventm3);
			m4.setOnAction(eventm4);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
