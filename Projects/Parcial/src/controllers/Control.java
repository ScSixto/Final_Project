package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import models.*;
import org.json.simple.DeserializationException;
import persistence.FileManager;
import views.*;

public class Control implements ActionListener{

	public static final String EMPLOYEE_FILE_PATH = "resources/Empleados.institucion";

	private FileManager fileManager;
	private JFramePpal jFramePpal;
	private EmployeeManager employeeManager;



	public Control() {
		jFramePpal = new JFramePpal(this);
		fileManager = new FileManager();
		employeeManager = new EmployeeManager();
		init();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(ActionCommands.valueOf(e.getActionCommand())){
		case SHOW_EMPLOYEE_WINNER_LIST:
			break;
		case SHOW_EMPLOYEE_LIST:
			this.showEmployeeList();
			break;
		default:
			break;
		
		}
	}

	public void showEmployeeList(){
		ArrayList<Object[]> employeeDataList = UtilView.formatEmployeeData(employeeManager.getEmployeeDataList());
		if(employeeDataList.size() > 0){
			jFramePpal.showTable(employeeDataList, TableHeader.EMPLOYEE_LIST);
		}else{
			jFramePpal.showErrorMessage(ErrorMessage.EMPLOYEE_LIST_EMPTY);
		}
	}

	public void init(){
		this.readFiles();
	}


	private void readFiles(){
		this.readEmployees();
	}

	private void readEmployees(){
		try {
			ArrayList<Object[]> employeeObjectArrayList = fileManager.readEmployees(EMPLOYEE_FILE_PATH, FileManager.JSON_FILE_TYPE);
			for(Object[] employeeArray: employeeObjectArrayList){
				employeeManager.addEmployee(new Employee(Util.toLong((String)employeeArray[3]),(String)employeeArray[0],(String)employeeArray[1],Util.toRankingCategoryFormat((String)employeeArray[5]), Util.toDocumentTypeFormat((String)employeeArray[2]), Util.toBondingTypeFormat((String)employeeArray[4]), Util.toInteger((String)employeeArray[6]), Util.toInteger((String) employeeArray[7])));
			}
		} catch (IOException e){
			e.printStackTrace();
		} catch (DeserializationException e) {
			e.printStackTrace();
		}
	}
//
//	private void writeClaseArray(){
//		try{
//			fileManager.writeJsonFile("resources/reporte.json",((fileManager.getJsonEmployeeArray(employeeManager.toHashMapList())).toJson()));
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//	}

//
//	private void readFile() {
//		try {
//			ArrayList<String[]> damagedEmployeeList = new ArrayList<>();
//			ArrayList<String[]> employeeDataMatrix = Util.getFileInfo(fileManager.readFile(EMPLOYEE_FILE_PATH));
//			for (String[] register : employeeDataMatrix){
//				try{
//					String secondName = register[EmployeeFormat.SECOND_NAME.getFileFormatPosition()];
//					if(Util.isValidSecondName(secondName) && employeeManager.searchEmployee(Integer.parseInt(register[EmployeeFormat.ID.getFileFormatPosition()])) == EmployeeManager.VALUE_NOT_FOUND_CODE){
//						employeeManager.addEmployee(this.createEmployee(register));
//					}else{
//						damagedEmployeeList.add(register);
//					}
//				}catch(DateTimeParseException e){
//					System.out.println(1);
//					damagedEmployeeList.add(register);
//				}
//			}
//		}catch (IOException | FileFormatInvalid e) {
//			view.showErrorMessage(ErrorMessage.INVALID_FILE,e.getMessage());
//		}
//	}
}