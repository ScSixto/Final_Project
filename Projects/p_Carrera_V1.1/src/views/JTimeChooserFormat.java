package views;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class JTimeChooserFormat extends JPanel{

    private JSpinnerFormat hoursSpinner;
    private JSpinnerFormat minutesSpinner;
    private JSpinnerFormat secondsSpinner;

    public JTimeChooserFormat(){
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(0);
        this.setLayout(layout);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(0,-layout.getHgap(),0,0));

        this.setToolTipText("Ingrese tiempo en formato HH:mm:ss");
        this.setMaximumSize(new Dimension(70,25));
        this.initComponents();
    }

    private void initComponents(){
       this.addHourSpinner();
       this.addMinutesSpinner();
       this.addSecondsSpinner();
    }

    private void addHourSpinner(){
        this.hoursSpinner = new JSpinnerFormat(JSpinnerFormat.POSITIVE_SPINNER);
        this.hoursSpinner.setToolTipText("Horas");
        this.hoursSpinner.setBorder(BorderFactory.createEmptyBorder());
        this.add(hoursSpinner);
    }

    private void addMinutesSpinner(){
        this.minutesSpinner = new JSpinnerFormat(0,59);
        this.minutesSpinner.setToolTipText("Minutos");
        this.minutesSpinner.setBorder(BorderFactory.createEmptyBorder());
        this.add(minutesSpinner);
    }

    private void addSecondsSpinner(){
        this.secondsSpinner = new JSpinnerFormat(0,59);
        this.secondsSpinner.setToolTipText("Segundos");
        this.secondsSpinner.setBorder(BorderFactory.createEmptyBorder());
        this.add(secondsSpinner);
    }

    public void resetValues(){
        this.setHours(0);
        this.setMinutes(0);
        this.setSeconds(0);
    }

    public int getHours(){
        return (int)this.hoursSpinner.getValue();
    }

    public int getMinutes(){
        return (int)this.minutesSpinner.getValue();
    }

    public int getSeconds(){
        return (int)this.secondsSpinner.getValue();
    }

    public void setHours(int hours){
        this.hoursSpinner.setValue(hours);
    }

    public void setMinutes(int minutes){
        this.minutesSpinner.setValue(minutes);
    }

    public void setSeconds(int seconds){
        this.secondsSpinner.setValue(seconds);
    }

    public LocalTime getTime(){
        return LocalTime.of(this.getHours(), this.getMinutes(), this.getSeconds());
    }
}