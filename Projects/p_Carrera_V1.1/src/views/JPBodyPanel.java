package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class JPBodyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPTablePanel tablePanel;
    private JDAddRunner runnerGetterDialog;


    public JPBodyPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        this.runnerGetterDialog = new JDAddRunner(act);

        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        this.tablePanel = new JPTablePanel();
        this.add(tablePanel);
    }

    public void showRunnerTable(ArrayList<Object[]> runnerDataList){
        this.tablePanel.setJTableComponents(TableHeader.RUNNER_LIST);
        this.tablePanel.addRowList(runnerDataList);
    }

    public void showRunnerDataGetter(){
        runnerGetterDialog.reset();
        runnerGetterDialog.setVisible(true);;
    }

    public HashMap<RunnerData, Object> getNewRunnerData() throws NullPointerException{
        this.runnerGetterDialog.setAlwaysOnTop(false);
        HashMap<RunnerData, Object> newRunnerData = new HashMap<>();
        newRunnerData.put(RunnerData.ID, this.runnerGetterDialog.getId());
        newRunnerData.put(RunnerData.FIRST_NAME, this.runnerGetterDialog.getFirstName());
        newRunnerData.put(RunnerData.SECOND_NAME, this.runnerGetterDialog.getSecondName());
        newRunnerData.put(RunnerData.LAST_NAME, this.runnerGetterDialog.getLastName());
        newRunnerData.put(RunnerData.BIRTH_DATE, this.runnerGetterDialog.getBirthDate());
        newRunnerData.put(RunnerData.GENDER, this.runnerGetterDialog.getGender());
        newRunnerData.put(RunnerData.TEAM, this.runnerGetterDialog.getTeam());
        newRunnerData.put(RunnerData.ROUTE_TIME, this.runnerGetterDialog.getRouteTime());
        return newRunnerData;
    }
}