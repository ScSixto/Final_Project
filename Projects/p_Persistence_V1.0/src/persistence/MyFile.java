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
	public static final String DIRECTORY_EXTENSION = ".dir";
	public static final String DIRECTORY = "Directorio";
	public static final String FILE = "Archivo";
	public static final String FILE_EXTENSION = ".file";

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

	public MyFile() {
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

	private String[] getDirectoryFileNameArray(File fileDirectory, int directoryCounter, FileFormatType fileFormatType) throws IOException{
			String[] fileListName = new String[0];
			int directoryCount = directoryCounter;
			fileListName = addString(fileListName, this.getFileListTab(directoryCount++) + this.getFileField(fileDirectory, fileFormatType));
			for (File file : fileDirectory.listFiles()) {
				if(file.isDirectory()){
					String[] subfileName = getDirectoryFileNameArray(file,directoryCount,fileFormatType);
					fileListName = this.concatStringArray(fileListName, subfileName);
				}else{
					fileListName = addString(fileListName, this.getFileListTab(directoryCount) + this.getFileField(file, fileFormatType));
				}
			}
			return fileListName;
	}

	private String[] getDirectoryFileNameArrayByExtension(File fileDirectory, int directoryCounter, String extension) throws IOException{
		String[] fileListName = new String[0];
		int directoryCount = directoryCounter;
		fileListName = addString(fileListName, this.getFileListTab(directoryCount++) + this.getFileField(fileDirectory, FileFormatType.NAME));
		for (File file : fileDirectory.listFiles()) {
			if(file.isDirectory()){
				String[] subfileName = getDirectoryFileNameArrayByExtension(file,directoryCount,extension);
				fileListName = this.concatStringArray(fileListName, subfileName);
			}else if(this.getFileExtension(file).contains(extension)){
				fileListName = addString(fileListName, this.getFileListTab(directoryCount) + this.getFileField(file, FileFormatType.NAME));
			}
		}
		return fileListName;
	}
	
	public String[] getDirectoryFileNameArrayByExtension(File fileDirectory, String extension) throws IOException, FileFormatInvalid{
		if(this.file.isDirectory()){
			String[] fileListName = new String[0];
			int directoryCount = 0;
			fileListName = addString(fileListName, this.getFileListTab(directoryCount++) + this.getFileField(this.file, FileFormatType.NAME));
			for (File file : this.file.listFiles()){
				if(file.isDirectory()){
					String[] subfileName = getDirectoryFileNameArrayByExtension(file,directoryCount,extension);
					fileListName = this.concatStringArray(fileListName, subfileName);
				}else if(this.getFileExtension(file).contains(extension)){
					fileListName = addString(fileListName, this.getFileListTab(directoryCount) + this.getFileField(file, FileFormatType.NAME));
				}
			}
			return fileListName;
		}else{
			throw new FileFormatInvalid(this.file.getName());
		}
	}

	private String[] getDirectoryFileArray(File fileDirectory,FileFormatType fileFormatType) throws IOException{
		String[] fileFieldArray = new String[0];
		if(fileFormatType.equals(FileFormatType.NAME)){
			fileFieldArray = getDirectoryFileNameArray(fileDirectory, 0, FileFormatType.NAME);
		}else{
			fileFieldArray = addString(fileFieldArray,this.getFileField(fileDirectory, fileFormatType));
			for (File file : fileDirectory.listFiles()) {
				if(file.isDirectory()){
					String[] subfileArray = getDirectoryFileArray(file,fileFormatType);
					fileFieldArray = this.concatStringArray(fileFieldArray, subfileArray);
				}else{
					fileFieldArray = addString(fileFieldArray, this.getFileField(file, fileFormatType));
				}
			}
		}	
		return fileFieldArray;
}

	public String getFileField(File file ,FileFormatType fileFormatType) throws IOException{
		String fileField = "";
		switch (fileFormatType) {
		case NAME:
			fileField = file.getName();
			break;
		case EXTENSION:
			fileField += this.getFileExtension(file);
			break;
		case SIZE:
			fileField += this.getFileSize(file);
			break;
		case TYPE:
			fileField += this.getFileType(file);
			break;
		}
		return fileField;
	}

	private String getFileType(File file) {
		return (file.isDirectory())?DIRECTORY:FILE;
	}

	public String getFileListTab(int directoryCount){
		String fileListTab = "";
		for (int i = 0; i < directoryCount; i++) {
			fileListTab += "'  ";
		}
		return fileListTab;
	}
	
	public boolean hasDirectories(File fileDirectory){
		boolean hasDirectories = false;
		int i = 0;
		File[] fileArray = fileDirectory.listFiles();
		while(i < fileArray.length && !hasDirectories){
			if(fileArray[i].isDirectory())
				hasDirectories = true;
			i++;
		}
		return hasDirectories;
	}

	public String[] concatStringArray(String[] strArray1, String[] strArray2){
		String[] strArrayResult = new String[strArray1.length + strArray2.length];
		System.arraycopy(strArray1, 0, strArrayResult, 0, strArray1.length);
		System.arraycopy(strArray2, 0, strArrayResult, strArray1.length, strArray2.length);
		return strArrayResult;
	}

	private String[] addString(String[] stringArray, String string){
		String[] stringArrayTemp = new String[stringArray.length + 1];
		for(int i = 0; i < stringArray.length;i++){
			stringArrayTemp[i] = stringArray[i];
		}
		stringArrayTemp[stringArrayTemp.length -1] = string;
		return stringArrayTemp;
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

	public String getFileExtension(File file) throws IOException{
		String fileExtension = "";
		if(file.isDirectory()){
			fileExtension = DIRECTORY_EXTENSION;
		}else{
			boolean hasExtension = file.getPath().lastIndexOf(".") != -1;
			if(hasExtension)
				fileExtension =  file.getPath().substring(file.getPath().lastIndexOf("."));
			else
				fileExtension = FILE_EXTENSION;
		}
		return fileExtension;
	}

	public long getFileSize(File file) throws IOException{
		long byteSize = 0;
		if (file.isDirectory()) {
			for (File subfile : file.listFiles()){
				byteSize += this.getFileSize(subfile);				
			}
		} else {
			this.byteReader = new FileInputStream(file);
			byteSize += byteReader.available();
		}
		return byteSize;
	}

	private int getLongerString(String[] strArray){
		int maxSize = 0;
		for (String string : strArray) {
			if(string.length() > maxSize){
				maxSize = string.length();
			}
		}
		return maxSize;
	}

	public static void main(String[] args) {
		MyFile m = new MyFile();
		try {
			String[] nameArray =  m.getDirectoryFileArray(new File("resources"), FileFormatType.NAME);
			String[] sizeArray =  m.getDirectoryFileArray(new File("resources"), FileFormatType.SIZE);
			String[] extensionArray =  m.getDirectoryFileArray(new File("resources"), FileFormatType.EXTENSION);
			String[] typeArray =  m.getDirectoryFileArray(new File("resources"), FileFormatType.TYPE);
			System.out.println(String.format("%1$-50s %2$-10s" , "Nombre","Tipo"));
			System.out.println("----------------------------------------------------------------------------");
			for (int i = 0;i < nameArray.length;i++) {
				System.out.println(String.format("%1$-50s %2$-10s" , nameArray[i],typeArray[i]  +""));
			}
		} catch (IOException e) {
			System.out.println("la cagaste prro");
		}
	}
}