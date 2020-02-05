package views;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class JDateChooserFormat extends JDateChooser{

	private static final long serialVersionUID = 1L;

	public static final Dimension DEFAULT_DATE_CHOOSER_ICON_DIMENSION = new Dimension(20,20);
	public static final String DEFAULT_DATE_CHOOSER_ICON_PATH = "resources/img/DateIcon.png";
	public static final Color DEFAULT_DATE_CHOOSER_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;
    public static final Font DEFAULT_DATE_CHOOSER_FONT = new Font("Arial",Font.PLAIN,14);

    public JDateChooserFormat(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setOpaque(false);
        this.setForeground(DEFAULT_DATE_CHOOSER_FOREGROUND);
        this.setFont(DEFAULT_DATE_CHOOSER_FONT);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.calendarButton.setBorderPainted(false);
        this.calendarButton.setBackground(ConstantsGUI.COLOR_IMPOSSIBLE);
        this.calendarButton.setOpaque(false);
        this.calendarButton.setBorder(BorderFactory.createEmptyBorder(2,0,3,5));
        this.setIcon(new ImageIcon(new ImageIcon(DEFAULT_DATE_CHOOSER_ICON_PATH).getImage().getScaledInstance((int)DEFAULT_DATE_CHOOSER_ICON_DIMENSION.getWidth(),(int)DEFAULT_DATE_CHOOSER_ICON_DIMENSION.getHeight(), Image.SCALE_AREA_AVERAGING)));
        this.setDateFormatString("dd/MM/yyyy");
//        this.getDateEditor().setMaxSelectableDate(Date.from(Instant.now()));
        this.getDateEditor().getUiComponent().setBackground(ConstantsGUI.COLOR_LIGHT_GRAY_4);
        this.getDateEditor().getUiComponent().setForeground(ConstantsGUI.COLOR_DARK_GRAY);
        this.getDateEditor().getUiComponent().setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        LocalDate fecha = LocalDate.of(1999,5,3);
        this.getJCalendar().setDate(new Date(fecha.getDayOfMonth(),fecha.getMonthValue(),fecha.getYear()));
//        this.getDateEditor().getUiComponent().setMaximumSize(null);
//        date.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                JTextField chooser = (JTextField) e.getSource();
//                chooser.selectAll();
//            }
//        });
//        this.getComponent(1).setVisible(false);;
//        Component dateTextField = this.getComponent(1);
//        dateTextField.setBackground(ConstantsGUI.COLOR_LIGHT_GRAY_4);
//        dateTextField.setFont(DEFAULT_DATE_CHOOSER_FONT);
//        dateTextField.setForeground(DEFAULT_DATE_CHOOSER_FOREGROUND);
//        dateTextField.setMaximumSize(new Dimension(WIDTH,25));
//        this.remove(1);
//
//        this.add(dateTextField);
        //        this.getDateEditor().setSelectableDateRange(Date.from(Instant.from(LocalDate.of(1803,4,1))),Date.from(Instant.from(LocalDate.of(2017,1,3))));
    }

    public LocalDate getLocalDate() throws NullPointerException{
            System.out.println(LocalDate.of(this.getJCalendar().getDate().getYear()+1900,this.getDate().getMonth()+1,this.getDate().getDate()));
            return LocalDate.of(this.getJCalendar().getDate().getYear()+1900,this.getDate().getMonth()+1,this.getDate().getDate());
    }

    public void reset(){
        this.setDate(null);
    }

    public void setLocalDate(LocalDate date){
        this.setDate(new Date(date.getYear()-1900,date.getMonthValue()-1,date.getDayOfMonth()));
    }
}