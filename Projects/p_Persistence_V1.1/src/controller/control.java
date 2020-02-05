package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import exceptions.FileFormatInvalid;
import persistence.MyFile;
import views.ErrorMessage;
import views.FileFormatType;
import views.View;

public class Control {
	public static final int SHOW_FILE_COMPLETE_LIST_OPTION = 1;
	public static final int READ_FILE_BY_BYTES_QUANTITY_OPTION = 2;
	public static final int SHOW_FILE_LIST_BY_EXTENSION_OPTION = 3;
	public static final int SHOW_FILE_LIST_BY_BYTES_QUANTITY_OPTION = 4;
	public static final int SHOW_FILE_LIST_WITH_SIZE_OPTION = 5;
	public static final int EXIT = 0;

	private MyFile file;
	private View view;

	public Control(){
		view = new View();
		init();
	}

	public void init(){
		int op;
		try{
			do{
				op = view.getMenuOption();
				switch (op) {
				case SHOW_FILE_COMPLETE_LIST_OPTION:
					this.showFileCompleteList();
					file.closeFile();
					break;
				case READ_FILE_BY_BYTES_QUANTITY_OPTION:
					this.readFileByBytesQuantity();
					file.closeFile();
					break;
				case SHOW_FILE_LIST_BY_EXTENSION_OPTION:
					this.showFileListByExtension();
					file.closeFile();
					break;
				case SHOW_FILE_LIST_BY_BYTES_QUANTITY_OPTION:
					this.showFileListByBytesQuatity();
					file.closeFile();
					break;
				case SHOW_FILE_LIST_WITH_SIZE_OPTION:
					this.showFileListWithSize();
					file.closeFile();
					break;
				default:
					view.showErrorMessage(ErrorMessage.INVALID_VALUE);
					break;
				}
			}while(op != EXIT);
		}catch(IOException e){
			view.showErrorMessage(ErrorMessage.INVALID_FILE);
		}
	}

	private void showFileCompleteList() {
		this.file = new MyFile(view.getPathName());
		
	}

	private void readFileByBytesQuantity() {
		this.file = new MyFile(view.getPathName());
		try {
			int[] byteArray = file.readByteArray(view.getByteQuantity());
			view.showByteArray(byteArray);
			view.showCharByteArray(byteArray);
		} catch (FileNotFoundException e) {
			view.showErrorMessage(ErrorMessage.INVALID_FILE, e.getMessage());
		} catch(IOException e){
			view.showErrorMessage(ErrorMessage.INVALID_FILE, e.getMessage());
		}
	}

	private void showFileListByExtension(){
		this.file = new MyFile(view.getPathName());
		try {
			view.showFileList(file.getDirectoryInfoList(view.getExtension()),FileFormatType.EXTENSION);
		} catch (FileFormatInvalid e) {
			view.showErrorMessage(ErrorMessage.INVALID_FILE, e.getMessage());
		}
	}

	private void showFileListByBytesQuatity() {
		this.file = new MyFile(view.getPathName());
		try {
			view.showFileList(file.getDirectoryInfoList(view.getByteQuantity()), FileFormatType.SIZE);
		} catch (FileFormatInvalid e) {
			view.showErrorMessage(ErrorMessage.INVALID_FILE, e.getMessage());
		} catch (IOException e) {
			view.showErrorMessage(ErrorMessage.INVALID_FILE, e.getMessage());
		}
	}

	private void showFileListWithSize() {
		this.file = new MyFile(view.getPathName());
		try {
			view.showFileList(file.getDirectoryTypeInfo(), FileFormatType.SIZE);
		} catch (FileFormatInvalid e) {
			view.showErrorMessage(ErrorMessage.INVALID_FILE, e.getMessage());
		}
	}
}
