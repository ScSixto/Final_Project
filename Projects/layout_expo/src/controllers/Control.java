package controllers;

import views.JFramePpal;
import views.JPCardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{

	private JFramePpal jFramePpal;
	
	public Control() {
		init();
	}

	public void init(){
		jFramePpal = new JFramePpal(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(ActionCommands.valueOf(e.getActionCommand())){
			case PREVIOUS_IMAGE:
				this.showPreviousCardImage();
			break;
			case NEXT_IMAGE:
				this.showNextCardImage();
			break;
			case DBZ_IMAGE:
				this.showCardImage(JPCardLayout.DBZ_KEY);
				break;
			case DEATH_NOTE_IMAGE:
				this.showCardImage(JPCardLayout.DEATH_NOTE_KEY);
				break;
			case NARUTO_IMAGE:
				this.showCardImage(JPCardLayout.NARUTO_KEY);
				break;
			case SHINGEKY_NO_KYOJIN_IMAGE:
				this.showCardImage(JPCardLayout.SHINGEKY_NO_KYOJIN_KEY);
				break;
			case ONE_PIECE_IMAGE:
				this.showCardImage(JPCardLayout.ONE_PIECE_KEY);
				break;
			case NANATSU_NO_TAIZAI_IMAGE:
				this.showCardImage(JPCardLayout.NANATSU_NO_TAIZAI_KEY);
				break;
			case ONE_PUNCH_MAN_IMAGE:
				this.showCardImage(JPCardLayout.ONE_PUNCH_MAN_KEY);
				break;
			default:
			break;

		}
	}

	private void showCardImage(String key){
		jFramePpal.showCardImage(key);
	}

	private void showPreviousCardImage() {
		jFramePpal.showPreviousCardImage();
	}

	private void showNextCardImage() {
		jFramePpal.showNextCardImage();
	}

}