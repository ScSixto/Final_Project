package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import exceptions.FileFormatInvalid;

public class FileManager {
	public static final char READ_MODE = 'r';
	public static final char WRITE_MODE = 'w';

	private File file;
	private FileReader fileReader;
	private FileWriter fileWriter;
	private BufferedWriter buffWriter;
	private BufferedReader buffReader;

	private void openFile(String filePath, char mode) throws IOException, FileFormatInvalid {
		this.file = new File(filePath);
		if (!this.file.isDirectory()) {
			if (mode == WRITE_MODE) {
				fileWriter = new FileWriter(file);
			} else if (mode == READ_MODE)
				fileReader = new FileReader(file);
		}else{
			throw new FileFormatInvalid(file.getName());
		}
	}

	public void closeFile() throws IOException {
		if (fileReader != null) {
			buffReader.close();
			fileReader.close();
		}
		if (fileWriter != null) {
			buffWriter.close();
			fileWriter.close();
		}
	}

	public ArrayList<String> readFile(String filePath) throws IOException, FileFormatInvalid {
		this.openFile(filePath, READ_MODE);
		this.buffReader = new BufferedReader(this.fileReader);
		ArrayList<String> info = new ArrayList<>();
		String register = buffReader.readLine();
		while (register != null) {
			info.add(register);
			register = buffReader.readLine();
		}
		this.closeFile();
		return info;
	}

	public void writeFile(String filePath, String[] info) throws IOException, FileFormatInvalid {
		this.openFile(filePath, WRITE_MODE);
		this.buffWriter = new BufferedWriter(this.fileWriter);
		for (int i = 0; i < info.length; i++) {
			if (info[i] != null) {
				this.buffWriter.write(info[i]);
				this.buffWriter.newLine();
			}
		}
		this.closeFile();
	}
}