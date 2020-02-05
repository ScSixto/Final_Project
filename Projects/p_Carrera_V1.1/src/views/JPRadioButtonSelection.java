package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JPRadioButtonSelection extends JPanel{

    private HashMap<String, JRadioButtonFormat> radioButtonList;

    public JPRadioButtonSelection(ActionListener act, HashMap<String, String> radioButtonNamesList){
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(10);
        this.setLayout(layout);
        this.setBorder(BorderFactory.createEmptyBorder(0,-layout.getHgap(),0,0));
        this.setOpaque(false);

        this.initComponents(act, radioButtonNamesList);
    }

    private void initComponents(ActionListener act, HashMap<String, String> radioButtonNamesList) {
        this.initializeRadioButtonList(radioButtonNamesList);
        this.addRadioButtonList(act);
    }

    private void initializeRadioButtonList(HashMap<String, String> radioButtonNamesList){
        this.radioButtonList = new HashMap<>();
        Iterator<Map.Entry<String, String>> it = radioButtonNamesList.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> radioButton = it.next();
            this.radioButtonList.put(radioButton.getKey(), new JRadioButtonFormat(radioButton.getValue()));
        }
    }

    private void addRadioButtonList(ActionListener act){
        Iterator<Map.Entry<String, JRadioButtonFormat>> it = this.radioButtonList.entrySet().iterator();
        while(it.hasNext()){
            this.add(it.next().getValue());
        }
    }

    public JRadioButtonFormat getRadioButton(String key){
        return this.radioButtonList.get(key);
    }

    public void resetComponents(){
        Iterator<Map.Entry<String, JRadioButtonFormat>> it = this.radioButtonList.entrySet().iterator();
        while(it.hasNext()){
            it.next().getValue().setSelected(false);
        }
    }

    public void setUnselectedExcept(String key){
        Iterator<Map.Entry<String, JRadioButtonFormat>> it = this.radioButtonList.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, JRadioButtonFormat> radioButton= it.next();
            if(!radioButton.getKey().equals(key)){
                radioButton.getValue().setSelected(false);
            }
        }
    }

    public String getSelection(){
        String selectedObject = null;
        Iterator<Map.Entry<String, JRadioButtonFormat>> it = this.radioButtonList.entrySet().iterator();
        while(it.hasNext() && selectedObject == null){
            Map.Entry<String, JRadioButtonFormat> radioButton = it.next();
            if(radioButton.getValue().isSelected()) {
                selectedObject = radioButton.getKey();
            }
        }
        return selectedObject;
    }
}