package views;

import java.util.ArrayList;
import java.util.Scanner;

import models.Bedroom;
import models.BedroomType;

public class View {
	
	public static final String USER_MENU = "Ingrese el numero de la opcion requerida.\n"
											+ "\t1. Agregar habitacion.\n"
											+ "\t2. Buscar habitacion.\n"
											+ "\t3. Eliminar habitacion.\n"
											+ "\t4. Ver porcentajes de disponibilidad.\n"
											+ "\t5. Ver habitaciones por costo.\n"
											+ "\t6. Ver porcentajes de habitaciones por tipo.\n"
											+ "\t7. Ver informacion de las habitaciones.\n"
											+ "\t0. Salir.";
	public static final String GET_BEDROOM_TYPE_MESSAGE = "Ingrese el numero correspondiente a tipo de habitacion.\n";
	public static final String GET_BED_QUANTITY_MESSAGE = "Ingrese el numero de camas de la habitacion.\n";
	public static final String GET_BEDROOM_CODE_MESSAGE = "Ingrese el codigo de la habitacion.\n";
	public static final String GET_BEDROOM_COST_MESSAGE = "Ingrese el costo de la habitacion.\n";
	public static final String SHOW_BEDROOM_AVAILABILITY_MESSAGE = "  Habitaciones disponibles: %1.2f%%\n  Habitaciones No disponibles: %1.2f%%\n";
	public static final String SHOW_BEDROOM_INFORMATION_MESSAGE = "-----------------\n Habitacion: %03d \n----------------------------------------------------------------\n Estado: %s \tCosto: $%-17.0f\n----------------------------------------------------------------\n Numero de camas: %d\tTipo de habitacion: %3s\n----------------------------------------------------------------\n\n";
	public static final String BEDROOM_LIST_INFORMATION_FORMAT = "  %1$-22s  %2$-14s  %3$-11s  %4$-23s  %5$-16s\n";
	public static final String BEDROOM_LIST_INFORMATION_SEPARATOR = " ______________________________________________________________________________________________\n";
	public static final String SHOW_BEDROOM_PERCENT_BY_TYPE_MESSAGE = "\n  Habitaciones tipo %s: %1.2f%%.\n";
	private Scanner scanner;

	public View(){
		this.scanner = new Scanner(System.in);
	}

	public int getMenuOption(){
		System.out.println(USER_MENU);
		return Short.parseShort(scanner.nextLine());
	}

	public int getBedroomCode(){
		System.out.println(GET_BEDROOM_CODE_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}
	
	public int getBedQuantity(){
		System.out.println(GET_BED_QUANTITY_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}

	public int getBedroomType(){
		System.out.println(GET_BEDROOM_TYPE_MESSAGE);
		for (BedroomType bedroomType : BedroomType.values()) {
			System.out.println("\t" + bedroomType.getCode() + "." + bedroomType.getType() + ".");
		}
		return Short.parseShort(scanner.nextLine());
	}

	public double getBedroomCost(){
		System.out.println(GET_BEDROOM_COST_MESSAGE);
		return Double.parseDouble(scanner.nextLine());
	}

	public void showBedroomInformation(Bedroom bedroom){
		String availability = (bedroom.isAvailable())?"Disponible":"No disponible";
		System.out.printf(SHOW_BEDROOM_INFORMATION_MESSAGE,bedroom.getRoomCode(),availability,bedroom.getCost(),bedroom.getBedQuantity(), bedroom.getRoomType().getType());
	}
/*
	public void showBedroomListInformation(ArrayList<Bedroom> bedroomList){
		try{
			System.out.println(BEDROOM_LIST_INFORMATION_SEPARATOR + String.format(BEDROOM_LIST_INFORMATION_FORMAT, "Numero de habitacion", "Estado", "Precio", "Tipo de habitacion", "Numero de camas") + BEDROOM_LIST_INFORMATION_SEPARATOR);
			for (Bedroom bedroom : bedroomList) {
				String availability = (bedroom.isAvailable())?"Disponible":"No disponible";
				System.out.println(String.format(BEDROOM_LIST_INFORMATION_FORMAT, bedroom.getRoomCode()+"",availability,"$"+bedroom.getCost(),bedroom.getRoomType().getType(),bedroom.getBedQuantity()+""));
			}
			System.out.println(BEDROOM_LIST_INFORMATION_SEPARATOR);
		}catch(NullPointerException e){
			this.showErrorMessage("No hay habitaiones disponibles.");
		}
	}
*/
	public void showBedroomListInformation(ArrayList<Object[]> bedroomList){
		try{
			System.out.println(BEDROOM_LIST_INFORMATION_SEPARATOR + String.format(BEDROOM_LIST_INFORMATION_FORMAT, "Numero de habitacion", "Estado", "Precio", "Tipo de habitacion", "Numero de camas") + BEDROOM_LIST_INFORMATION_SEPARATOR);
			for (Object[] bedroom : bedroomList) {
				String availability = (boolean)(bedroom[1])?"Disponible":"No disponible";
				System.out.println(String.format(BEDROOM_LIST_INFORMATION_FORMAT, bedroom[0]+"",availability,"$"+(double)bedroom[2],bedroom[3],bedroom[4]+""));
			}
			System.out.println(BEDROOM_LIST_INFORMATION_SEPARATOR);
		}catch(NullPointerException e){
			this.showErrorMessage("No hay habitaiones disponibles.");
		}
	}

	public void showBedroomAvailability(double availablePercent, double unavailablePercent){
		System.out.printf(BEDROOM_LIST_INFORMATION_SEPARATOR + SHOW_BEDROOM_AVAILABILITY_MESSAGE + BEDROOM_LIST_INFORMATION_SEPARATOR, availablePercent, unavailablePercent);
	}

	public void showBedroomPercentByType(double bedRoomPercent, BedroomType type){
		System.out.printf(BEDROOM_LIST_INFORMATION_SEPARATOR + SHOW_BEDROOM_PERCENT_BY_TYPE_MESSAGE + BEDROOM_LIST_INFORMATION_SEPARATOR, type.getType(), bedRoomPercent);
	}
	
	public void showErrorMessage(String message){
		System.out.println(BEDROOM_LIST_INFORMATION_SEPARATOR + "\n\tError: " + message + "\n" + BEDROOM_LIST_INFORMATION_SEPARATOR);
	}
}