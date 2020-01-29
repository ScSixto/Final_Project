package views;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConstantsGUI {

	public static final String TITLE_PROGRAM = "Title_Window";
	public static final String T_CULTIVE = "Cultive";
	public static final String T_ADD = "Add";
	public static final String T_DELETE = "Delete";
	public static final String T_EDIT = "Edit";
	public static final String T_LANGUAGE = "Language";
	public static final String LANGUAGE_SPANISH = "Spanish";
	public static final String LANGUAGE_ENGLISH = "English";
	public static final String T_PRESENTATION = "Message_Presentation";
	public static final String T_OPTIONS = "Options";
	public static final String T_EXPORT = "Export";
	public static final String T_EXIT = "Exit";
	public static final String T_CONFIRMATION = "Confirmation";
	public static final String T_MESSAGE_END_PROGRAM = "Message_End_Program";
	public static final String T_MESSAGE_CONFIRMATION_END_PROGRAM = "Message_Confirmation_End_Program";
	public static final String T_TOWN = "Town";
	public static final String T_YEAR = "Year";
	public static final String T_SPECIE = "Specie";
	public static final String T_CULTIVATED_QUANTITY = "Cultivated_Quantity";
	public static final String T_HARVESTED_QUANTITY = "Harvested_Quantity";
	public static final String T_TOTAL_CULTIVE_WEIGHT_KG = "Total_Cultive_Weight";
	public static final String T_TOTAL_CULTIVE_PRICE = "Total_Cultive_Price";
	public static final String T_TABLE_CULTIVES = "Cultives";
	public static final String T_TABLES = "Tables";
	public static final String ID = "Id";
//Botones dialogos de confirmacion
	public static final String BUTTON_YES = "Yes_Button";
	public static final String BUTTON_NO = "No_Button";
	public static final String BUTTON_ACCEPT = "Accept_Button";
	
	public static final String COLOR_BACKGRAUND = "#ffffff";
	public static final String COLOR_PRESENTATION = "#E77714";
	
//nombre paneles cardlayout
	public static final String PANEL_PRESENTATION = "Panel Presentation";
	public static final String PANEL_TABLE = "Panel Table";
	
	public static Icon convertToIcon(String route, int width, int heigth) {
		ImageIcon icon = new ImageIcon(route);
		Icon scaleIcon = new ImageIcon(icon.getImage().getScaledInstance(width,heigth, Image.SCALE_SMOOTH));
		return scaleIcon;
	}

}
