package views;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;

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
	public static final String T_PISCICULTURE = "Pisciculture";
	public static final String T_OPTIONS = "Options";
	public static final String T_EXPORT = "Export";
	public static final String T_EXIT = "Exit";
	public static final String T_HOMEPAGE = "HomePage";
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
	public static final String T_REPORTS = "Reports";
	public static final String T_TABLES = "Tables";
	public static final String T_TEXT_OF_PISCICULTURE = "Text_Of_Pisciculture";
	public static final String T_TITLE_TABLE_CULTIVES = "Title_Table_Cultives";
	public static final String T_GRAPHICS = "Graphics";

    public static final char LOWERCASE_ACCENTED_N = (char) 241;
    public static final char LOWERCASE_ACCENTED_A = (char) 225;
    public static final char LOWERCASE_ACCENTED_E = (char) 233;
    public static final char LOWERCASE_ACCENTED_I = (char) 237;
    public static final char LOWERCASE_ACCENTED_O = (char) 243;
    public static final char LOWERCASE_ACCENTED_U = (char) 250;
    public static final char EM_DASH = (char) 8212;
	
	public static final String ID = "Id";
	public static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//Botones dialogos de confirmacion
	public static final String BUTTON_YES = "Yes_Button";
	public static final String BUTTON_NO = "No_Button";
	public static final String BUTTON_ACCEPT = "Accept_Button";
	
	public static final Color COLOR_BACKGRAUND = Color.decode("#d7d8d8");
	public static final Color COLOR_PRESENTATION = Color.decode("#333333");
	public static final Color COLOR_LINE = Color.decode("#17a788");
	//public static final Color COLOR_BACKGRAUND = Color.decode("#ffffff");
	//public static final Color COLOR_PRESENTATION = Color.decode("#E77714");
	public static final Color COLOR_BLACK = Color.BLACK;
	
//nombre paneles cardlayout
	public static final String PANEL_INITIAL = "Panel Presentation";
	public static final String PANEL_TABLE = "Panel Table";
	public static final String PANEL_TABLE_REPORTS = "Panel Table Reports";
	public static final String PANEL_GRAPHIC_REPORTS = "Panel Graphics Reports";
	
//adiciones
	public static final String LINE = EM_DASH + " " + EM_DASH + " " + EM_DASH + " " + EM_DASH + " " + EM_DASH + " " + EM_DASH + " " + EM_DASH + " " + EM_DASH + " " + EM_DASH + " " + EM_DASH;
	public static final String PANEL_GRAFICA = "Panel Grafica";
	
	public static Icon convertToIcon(String route, int width, int heigth) {
		ImageIcon icon = new ImageIcon(route);
		Icon scaleIcon = new ImageIcon(icon.getImage().getScaledInstance(width,heigth, Image.SCALE_SMOOTH));
		return scaleIcon;
	}

//Valores gráfica de barras
	public static final Color DEFAULT_AXIS_COLOR = ConstantsGUI.COLOR_BLACK;
	public static final int MAX_PIXEL_COL_HEIGHT_VALUE = 300;
	public static final int MAX_PIXEL_COL_WIDTH_VALUE = 40;
	public static final int AXIS_LINE_WIDTH = 2;
	public static final int COL_SEPARATION = 3;
	public static final int Y_AXIS_VALUE_QUANTITY = 5;
	public static final Font DATA_LABEL_FONT = new Font("Arial",Font.PLAIN,10);
	public static final int Y_AXIS_LABEL_WIDTH = 30;
	public static final int INFORMATION_CIRCLE_DIAMETER = 15;
	public static final int INFORMATION_CIRCLE_ANGLE = 45;
}
