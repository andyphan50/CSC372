package application;

public class DataUpdater {
	
	//Communication class for updated data lists with new student data
	public void updateData(StudentDataList dataModel, Student newData) {
		dataModel.addData(newData); 
	}

}
