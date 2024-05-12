package application;
	
import java.util.Iterator;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;



public class Main extends Application {
	Label header = new Label("Welcome to the student Database"); 
	Label tableHeader = new Label("Currently Enrolled Students"); 
	Button addBtn = new Button("Enroll Student"); 
	Button removeBtn = new Button("Remove Student"); 
	Button openTxt = new Button("Save"); 
	static StudentDataList obsStudentList = new StudentDataList(); 
	DataUpdater dataUpdater = new DataUpdater(); 
	Student currSelected;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setPadding(new Insets(0,0,0,0));
			root.setVgap(10);
			root.setHgap(10);
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Creating event handlers on buttons
			addBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					AddStudentForm newStage = new AddStudentForm(); 
					newStage.openAddStudentForm();
				}
			}); 
			
			openTxt.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					StudentDataList.saveLinkedList(); 
				}
			}); 
			
			//Creating HBox for buttons
			HBox optionsHbox = new HBox(); 
			optionsHbox.setSpacing(10);
			optionsHbox.getChildren().addAll(addBtn,removeBtn,openTxt); 
			
			//Initial data examples created  
			Student andy = new Student("Andy","505 Lamar",3.9,"Chemistry"); 
			Student jimmy = new Student("Jimmy", "3400 Mayflower",3.2,"Biology"); 
			Student kevin = new Student("Kevin","1400 Chalice", 2.9, "Computer Science"); 
			
			//Creating table node for student information
			TableView<Student> studentTable = new TableView<>(); 
			TableColumn<Student, String> name = new TableColumn<>("Name"); 
			name.setCellValueFactory(cellData -> cellData.getValue().nameProperty()); 
			TableColumn<Student, String> address = new TableColumn<>("Address"); 
			address.setCellValueFactory(cellData -> cellData.getValue().addressProperty()); 
			TableColumn<Student, Double> gpa = new TableColumn<>("GPA");
			gpa.setCellValueFactory(cellData -> cellData.getValue().gpaProperty().asObject()); 
			TableColumn<Student, String> major = new TableColumn<>("Major"); 
			major.setCellValueFactory(cellData -> cellData.getValue().majorProperty()); 
			studentTable.getColumns().addAll(name,address,gpa,major); 
			
			//Create observable list data structure for table
			dataUpdater.updateData(obsStudentList, kevin);
			dataUpdater.updateData(obsStudentList, jimmy);
			dataUpdater.updateData(obsStudentList, andy);
			studentTable.setItems(obsStudentList.getDataList());
			
			//Creating a mouse event for when an item is selected on the table 
			studentTable.setOnMouseClicked(event -> {
				//get the selected items 
				ObservableList<Student> selection = studentTable.getSelectionModel().getSelectedItems();
				currSelected = selection.get(0); 
			});
			
			removeBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					StudentDataList.removeData(currSelected); 
				}
			}); 
			//Arranging nodes in the grid
			header.setStyle("-fx-font-size: 20px"); 
			root.add(header, 0, 0);
			root.add(tableHeader, 0, 1);
			root.add(studentTable, 0, 2);
			root.add(optionsHbox, 0, 3);
			
			//Display stage
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Student Database");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
