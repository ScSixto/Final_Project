package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

import exceptions.FileFormatInvalid;

public class MyFile{
	
	public static final char READ_MODE = 'r';
	public static final char WRITE_MODE = 'w';

	private File file;
	private FileInputStream byteReader;
	private FileOutputStream byteWriter;
	private FileReader fileReader;
	private FileWriter fileWriter;
	private BufferedWriter bW = null;
	private BufferedReader bR = null;

	public MyFile(String fileName){
		file = new File(fileName);
	}

	public String getFileName() {
		return file.getName();
	}

	private void openFile(char mode) throws IOException{
		if (mode == WRITE_MODE)
			fileWriter = new FileWriter(file);
		else if(mode == READ_MODE)
			fileReader = new FileReader(file);
	}

	public void closeFile() throws IOException{
		if (fileReader != null)
			fileReader.close();
		if (fileWriter != null)
			fileWriter.close();
	}

	public int[] readByteArray() throws IOException{
		this.openFile(READ_MODE);
		this.byteReader = new FileInputStream(this.file);
		int[] byteArray = new int[0];
		while (this.byteReader.available() > 0)
			byteArray = this.addByte(byteArray, this.byteReader.read());
		return byteArray;
	}
	
	public void showByteReading() throws IOException{
		for (int byteReading : this.readByteArray()){
			System.out.println(byteReading);
		}
	}

	public void showCharByteReading() throws IOException{
		for (int byteReading : this.readByteArray()){
			System.out.print("Lectura: \"" + (char)byteReading + "\"");
		}
	}

	public int[] readByteArray(int byteQuantity)throws IOException{
		this.openFile(READ_MODE);
		this.byteReader = new FileInputStream(this.file);
		int[] byteArray = new int[0];
		for (int i = 0; i < byteQuantity;i++)
			byteArray = this.addByte(byteArray, this.byteReader.read());
		return byteArray;
	}

	private int[] addByte(int[] byteArray, int b){
		int[] byteArrayTemp = new int[byteArray.length + 1];
		for(int i = 0; i < byteArray.length;i++){
			byteArrayTemp[i] = byteArray[i];
		}
		byteArrayTemp[byteArrayTemp.length -1] = b;
		return byteArrayTemp;
	}

	public ArrayList<Object[]> getDirectoryTypeInfo() throws FileFormatInvalid, FileNotFoundException, IOException{
		if(file.isDirectory()){
			ArrayList<Object[]> fileInfoList = new ArrayList<>();
			for (File file : file.listFiles()){
				String type = getFileType(file);
				long size = (file.isDirectory())?0:new FileInputStream(file).available();
				fileInfoList.add(new Object[]{file.getName(),type,size});
			}
			return fileInfoList;
		}else{
			throw new FileFormatInvalid(file.getName());
		}
	}

	public Object[] getFileNameArray(){
//		if(file.isDirectory()){
			File[] fileArray = file.listFiles();
			String[] fileNameList = new String[fileArray.length];
			for (int i = 0; i < fileArray.length; i++) {
				fileNameList[i] = fileArray[i].getName();
			}
			return fileNameList;
//		}else{
//			throw new FileFormatInvalid(folderPathName);
//		}
	}

	public ArrayList<Object[]> getDirectoryInfoList(String extension) throws FileFormatInvalid{
		if(file.isDirectory()){
			ArrayList<Object[]> fileInfoList = new ArrayList<>();
			for (File file : file.listFiles()) {
				String type = getFileType(file);
				if(type.equals(extension))
					fileInfoList.add(new Object[]{file.getName(),type});
			}
			return fileInfoList;
		}else{
			throw new FileFormatInvalid(file.getName());
		}
	}

	public ArrayList<Object[]> getDirectoryInfoList(int byteQuantity) throws FileFormatInvalid, FileNotFoundException, IOException{
		if(file.isDirectory()){
			ArrayList<Object[]> fileInfoList = new ArrayList<>();
			for (File file : file.listFiles()) {
				long fileByteQuantity = (file.isDirectory())?0:new FileInputStream(file).available();
				if(fileByteQuantity > byteQuantity)
					fileInfoList.add(new Object[]{file.getName(),fileByteQuantity});
			}
			return fileInfoList;
		}else{
			throw new FileFormatInvalid(file.getName());
		}
	}

	public String getFileType(File file){
		return file.getName().substring(file.getName().lastIndexOf("."),file.getName().length());
	}

	public long getSize() throws IOException{
		this.byteReader = new FileInputStream(file);
		return byteReader.available();
	}
}