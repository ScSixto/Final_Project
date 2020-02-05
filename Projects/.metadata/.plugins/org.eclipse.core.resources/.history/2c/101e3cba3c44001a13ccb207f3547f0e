package views;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

import models.Team;

public class View {
	
	public static final char ENIE = (char)241;
	public static final String COME_BACK_OPTION = "\t0. Volver al menu anterior.\n";
	public static final String SEPARATOR = "----------------------------------------------------------------------------------------------------------------------";
	public static final String RUNNER_LIST_FORMAT = "  %1$-5s %2$-10s %3$-10s %4$-10s %5$-10s %6$-13s %7$-20s %8$-10s %9$-20s";
	public static final String BIRTH_DATE_FORMAT = "%02d/%02d/%04d";
	public static final String ROUTE_TIME_AVERAGE_LIST_FORMAT = "  %-12s %-18s";
	public static final String USER_MENU = "Ingrese el numero de la opcion requerida.\n"
			+ "\t1. Mostrar lista de corredores.\n"
			+ "\t2. Mostrar promedio de recorrido por Equipo.\n"
			+ "\t3. Mostrar lista de promedios de recorrido por Equipo.\n"
			+ "\t4. Modificar informacion.\n"
			+ "\t0. Salir.";
	public static final String MODIFY_RUNNER_LIST_MENU = "Ingrese el numero de la opcion requerida.\n"
			+ "\t1. A"+ENIE+"adir corredor.\n"
			+ "\t2. Modificar atributos de un corredor.\n"
			+ "\t3. Eliminar corredor.\n"
			+ COME_BACK_OPTION;;
	public static final String MODIFY_RUNNER_ATTRIBUTES_MENU = "Ingrese el numero del atributo a modificar.\n"
			+ "\t1. Primer nombre.\n"
			+ "\t2. Segundo nombre.\n"
			+ "\t3. Apellido.\n"
			+ "\t4. Fecha de Nacimiento.\n"
			+ "\t5. Genero.\n"
			+ "\t6. Equipo.\n"
			+ "\t7. Tiempo de recorrido.\n"
			+ COME_BACK_OPTION;
	public static final String MODIFY_NAME = "Ingrese el nuevo nombre.\n";
	public static final String MODIFY_LASTNAME = "Ingrese el nuevo Apellido.\n";
	public static final String MODIFY_BIRTHDATE = "Ingrese la nueva fecha de Nacimiento.(mm/dd/aaaa)\n";
	public static final String MODIFY_GENDER = "Ingrese el nuevo Genero.\n";
	public static final String MODIFY_TEAM = "Ingrese el nuevo Equipo.\n";
	public static final String MODIFY_ROUTE_TIME = "Ingrese el nuevo Tiempo alcanzado.(HH:mm:ss)\n";
	public static final String GET_ID_MESSAGE = "Ingrese Codigo ID\n";

	private Scanner sc;

	public View() {
		sc = new Scanner(System.in);
	}

	public int getUserMenuOption() {
		System.out.println(USER_MENU);
		return sc.nextInt();
	}
	
	public int getModifyAttributeOption(){
		System.out.println(MODIFY_RUNNER_ATTRIBUTES_MENU);
		return sc.nextInt();
	}
	
	public String getRouteTime(){
		System.out.println(MODIFY_ROUTE_TIME);
		return sc.nextLine();
	}
	
	public int getId(){
		System.out.println(GET_ID_MESSAGE);
		return sc.nextInt();
	}
	
	public String getBirthdate(){
		System.out.println(MODIFY_BIRTHDATE);
		return sc.nextLine();
	}
	
	public String getName(){
		System.out.println(MODIFY_NAME);
		return sc.nextLine();
	}
	
	public String getLastName(){
		System.out.println(MODIFY_LASTNAME);
		return sc.nextLine();
	}

	public void showErrorMessage(ErrorMessage error) {
		System.out.println(SEPARATOR);
		System.out.println("\tError: " + error.getMessage());
		System.out.println(SEPARATOR);
	}

	public void showErrorMessage(ErrorMessage error, String message) {
		System.out.println(SEPARATOR);
		System.out.println("\tError: " + error.getMessage() + "[" + message + "].");
		System.out.println(SEPARATOR);
	}

	public void showAverageByTeam(String average,String team){
		System.out.println(SEPARATOR);
		System.out.println("Promedio de tiempo:\n\t" + team + ": " + average);
		System.out.println(SEPARATOR);
	}
	
	public void showAverageByTeamList(HashMap<String,String> timeAverageMap){
		System.out.println(SEPARATOR);
		System.out.println(String.format(ROUTE_TIME_AVERAGE_LIST_FORMAT, "Equipo","Promedio de tiempo"));
		System.out.println(SEPARATOR);
		Iterator<Entry<String,String>>  it = timeAverageMap.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> averageByTeam = it.next();
			System.out.println(String.format(ROUTE_TIME_AVERAGE_LIST_FORMAT, averageByTeam.getKey(),averageByTeam.getValue()));
		}
		System.out.println(SEPARATOR);
	}

	public int getTeam(){
		System.out.println("Ingrese la opcion requerida.");
		for(Team team : Team.values()) {
			System.out.println("\t" + team.getId() + ". " + team.getName() + ".");
		}
		System.out.println(COME_BACK_OPTION);
		return sc.nextInt();
	}

	public int getModifyRunnerListOption() {
		System.out.println(MODIFY_RUNNER_LIST_MENU);
		return sc.nextInt();
	}
}
