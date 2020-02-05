package views;

import java.util.ArrayList;
import java.util.Scanner;

import persistence.FileFormatType;

public class View {
	public static final String FILE_LIST_FORMAT = "%1$-15s%2$-10s";
	public static final String USER_MENU = "Ingrese el numero de la opcion requerida.\n"
			+ "\t1. Listar directorios y archivos a partir del directorio especificado.\n"
			+ "\t2. Leer numero de bytes de archivo.\n"
			+ "\t3. Mostrar lista de archivos por extension.\n"
			+ "\t4. Mostrar lista de archivos por cantidad de bytes.\n"
			+ "\t5. Mostrar nombres de archivos y directorios con tipo (Archivos/Directorio) y tamaño.\n"
			+ "\t0. Salir.";
	public static final String GET_PATH_NAME_MESSAGE = "Ingrese la ruta del archivo/directorio.";
	public static final String GET_BYTE_QUANTITY_MESSAGE = "Ingrese la cantidad de bytes.";
	public static final String GET_EXTENSION_MESSAGE = "Ingrese la extension del archivo.";

	private Scanner sc;

	public View() {
		sc = new Scanner(System.in);
	}
	
	public void showFileList(ArrayList<Object[]> fileInfo, FileFormatType format){
		for (Object[] file : fileInfo) {
			for (int i = 0; i < file.length; i++){
				if(format == FileFormatType.EXTENSION)
					System.out.println(String.format(FILE_LIST_FORMAT,file[i],file[++i]));
				else if(format == FileFormatType.SIZE)
					System.out.println(String.format(FILE_LIST_FORMAT,file[i],file[++i]+" Bytes."));
			}
		}
	}

	public void showErrorMessage(ErrorMessage error){
		System.out.println("\tError: " + error.getMessage());
	}
	
	public void showErrorMessage(ErrorMessage error, String message){
		System.out.println("\tError: " + error.getMessage() + " " + message + "\n");
	}

	public int getMenuOption() {
		System.out.println(USER_MENU);
		return Integer.parseInt(sc.nextLine());
	}

	public String getPathName() {
		System.out.println(GET_PATH_NAME_MESSAGE);
		return sc.nextLine();
	}

	public int getByteQuantity() {
		System.out.println(GET_BYTE_QUANTITY_MESSAGE);
		return Integer.parseInt(sc.nextLine());
	}

	public void showByteArray(int[] byteArray) {
		for (int i = 0; i < byteArray.length; i++) {			
			System.out.println(byteArray[i]);
		}
	}

	public void showCharByteArray(int[] byteArray) {
		System.out.print("\"");
		for (int i = 0; i < byteArray.length; i++) {			
			System.out.print(""+(char)byteArray[i]);
		}
		System.out.println("\"\n");
	}

	public String getExtension() {
		System.out.println(GET_EXTENSION_MESSAGE);
		return sc.nextLine();
	}
}
