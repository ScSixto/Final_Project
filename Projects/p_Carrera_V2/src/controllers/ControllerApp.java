package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.JFramePpal;

public class ControllerApp implements ActionListener{

	public ControllerApp() {
		new JFramePpal(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(ActionCommands.valueOf(e.getActionCommand())) {
		case ADD_HOUSING:
			this.addHousing();
			break;
		case ADD_PACKAGE:
			this.addPackage();
			break;
		case ADD_TRAVEL:
			this.addTravel();
			break;
		default:
			break;
		}
	}

	private void addTravel() {
		JOptionPane.showMessageDialog(null,"Viajes");		
		
	}

	private void addPackage() {
		JOptionPane.showMessageDialog(null,"Paquetes");		
		
	}

	private void addHousing() {
		JOptionPane.showMessageDialog(null,"Alojamientos");		
	}
	
	public static void main(String[] args) {
		new ControllerApp();
	}

}
