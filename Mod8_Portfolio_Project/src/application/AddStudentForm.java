package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddStudentForm {
	Label title = new Label("Please enter the student information below."); 
	Label name = new Label("Name:");
	Label address = new Label("Address:"); 
	Label gpa = new Label("GPA:"); 
	Label major = new Label("Major:"); 
	TextField nameField = new TextField(); 
	TextField addressField = new TextField(); 
	TextField gpaField = new TextField(); 
	TextField majorField = new TextField(); 
	Button confirm = new Button("Submit"); 
	Button clear = new Button("Clear"); 
	DataUpdater updateList = new DataUpdater(); 
	
	public void openAddStudentForm() {
		try {
			Stage studentStage = new Stage(); 
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setPadding(new Insets(0,0,0,0));
			root.setVgap(10);
			root.setHgap(10);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			//creating HBox for buttons
			HBox hboxbuttons = new HBox(); 
			hboxbuttons.setSpacing(10);
			hboxbuttons.getChildren().addAll(confirm,clear); 
			
			
			//Adding event handlers for buttons
			//Creating event handlers on buttons
			confirm.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
					double gpaInput = Double.valueOf(gpaField.getText());
					if(gpaInput < 0 || gpaInput > 4) {
						Alert alert = new Alert(AlertType.INFORMATION); 
						alert.setTitle("Warning"); 
						alert.setContentText("Invalid GPA entered. Please try again"); 
						gpaField.clear(); 
						alert.showAndWait(); 
					} else {
						String nameInput = nameField.getText(); 
						String addressInput = addressField.getText();
						String majorInput = majorField.getText(); 
						Student newStudent = new Student(nameInput,addressInput, gpaInput,majorInput); 
						updateList.updateData(Main.obsStudentList, newStudent); 
						StudentDataList.saveLinkedList(); 
						studentStage.close(); 
					}
				} catch(Exception e) {
					System.out.println("Error caught"); 
				}
				}
			}); 
			
			clear.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					nameField.setText("");
					addressField.setText("");
					gpaField.setText("");
					majorField.setText("");
				}
			}); 
			
			
			//Arranging nodes in the grid
			root.add(title, 1, 0);
			root.add(name, 0, 1);
			root.add(address, 0, 2);
			root.add(gpa, 0, 3);
			root.add(major, 0, 4);
			root.add(nameField, 1, 1);
			root.add(addressField, 1, 2);
			root.add(gpaField, 1, 3);
			root.add(majorField, 1, 4);
			root.add(hboxbuttons, 1, 5);
			GridPane.setHalignment(hboxbuttons, HPos.CENTER);
			GridPane.setHalignment(name,HPos.CENTER);
			GridPane.setHalignment(address,HPos.CENTER);
			GridPane.setHalignment(gpa,HPos.CENTER);
			GridPane.setHalignment(major,HPos.CENTER);
			GridPane.setHalignment(nameField,HPos.LEFT);
			
			//Setting right padding for labels
			Insets padding = new Insets(5,0,5,0); 
			GridPane.setMargin(name, padding);
			GridPane.setMargin(nameField, padding);
			
			studentStage.setScene(scene);
			studentStage.show();
			studentStage.setTitle("Enroll Student");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
