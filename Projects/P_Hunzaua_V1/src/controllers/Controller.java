package controllers;


import models.*;
import views.View;

public class Controller {
	public static final short ADD_BEDROOM_OPTION = 1;
	public static final short SEARCH_BEDROOM_OPTION = 2;
	public static final short REMOVE_BEDRROM_OPTION = 3;
	public static final short GET_AVAILABILITY_PERCET_OPTION = 4;
	public static final short GET_BEDROOM_LIST_BY_COST_OPTION = 5;
	public static final short GET_BEDROOM_PERCET_BY_TYPE_OPTION = 6;
	public static final short GET_BEDROOM_LIST_INFORMATION_OPTION = 7;
	public static final short EXIT_BACK = 0;
	
	private Hotel manager;
	private View view;
	
	public Controller(){
		this.manager = new Hotel();
		this.view = new View();
		this.init();
	}
	
	private void init(){
		int op = 0;
		do{
			op = view.getMenuOption();
			switch(op) {
				case ADD_BEDROOM_OPTION:
					this.addBedroom();
					break;
				case SEARCH_BEDROOM_OPTION:
					this.searchBedroom();
					break;
				case REMOVE_BEDRROM_OPTION:
					this.removeBedroom();
					break;
				case GET_AVAILABILITY_PERCET_OPTION:
					this.getAvailabilityPercent();
					break;
				case GET_BEDROOM_LIST_BY_COST_OPTION:
					this.getBedroomListByCost();
					break;
				case GET_BEDROOM_PERCET_BY_TYPE_OPTION:
					this.getBedroomPercentByType();
					break;
				case GET_BEDROOM_LIST_INFORMATION_OPTION:
					this.getBedroomListInformation();
					break;
				case EXIT_BACK:
					break;
				default:
					view.showErrorMessage("Opcion invalida.");
					break;
			}
		}while(op != EXIT_BACK);
	}

	private void getBedroomListInformation(){
		this.view.showBedroomListInformation(this.manager.getBedroomList());
	}

	private void getBedroomPercentByType(){
		try{
			BedroomType bedroomType= this.getBedroomType();
			this.view.showBedroomPercentByType(this.manager.getBedroomPercent(this.manager.getBedroomQuantityByType(bedroomType)),bedroomType);
		}catch(ArithmeticException e){
			this.view.showErrorMessage("No hay existencia de habitaciones.");
		}
	}

	private void getBedroomListByCost(){
		this.view.showBedroomListInformation(this.manager.getBedroomListByCost(this.view.getBedroomCost()));
		
	}

	private void getAvailabilityPercent() {
		try{
			double availablePercent = this.manager.getBedroomPercent(this.manager.getRoomAvailabilityQuantity());
			double unavailablePercent = this.manager.getBedroomPercent(this.manager.getRoomUnavailabilityQuantity());
			this.view.showBedroomAvailability(availablePercent, unavailablePercent);
		}catch(ArithmeticException e){
			this.view.showErrorMessage("No hay existencia de habitaciones.");
		}
	}

	private void removeBedroom() {
		try{
			this.manager.removeBedroom(this.manager.searchBedroom(this.view.getBedroomCode()));
		}catch(NullPointerException e){
			this.view.showErrorMessage("La habitacion no existe.");
		}catch(ArrayIndexOutOfBoundsException e){
			this.view.showErrorMessage("La habitacion no existe.");
		}
	}

	private void searchBedroom(){
		try{
			this.view.showBedroomInformation(this.manager.searchBedroom(this.view.getBedroomCode()));
		}catch(ArrayIndexOutOfBoundsException e){
			this.view.showErrorMessage("Habitacion inexistente.");
		}
	}

	private void addBedroom(){
		BedroomType bedroomType = this.getBedroomType();
		if(bedroomType != BedroomType.EXIT)
			this.manager.addBedroom(this.manager.createBedroom(this.view.getBedQuantity(), bedroomType, this.view.getBedroomCost()));
	}

	private BedroomType getBedroomType(){
		int bedroomTypeOption = this.view.getBedroomType();
		BedroomType bedroomType = null;
		if(bedroomTypeOption == BedroomType.SENCILLA.getCode())
			bedroomType = BedroomType.SENCILLA;
		else if(bedroomTypeOption == BedroomType.DOBLE.getCode())
			bedroomType = BedroomType.DOBLE;
		else if(bedroomTypeOption == BedroomType.ACOMODACION_MULTIPLE.getCode())
			bedroomType = BedroomType.ACOMODACION_MULTIPLE;
		else if(bedroomTypeOption == BedroomType.SUITE.getCode())
			bedroomType = BedroomType.SUITE;
		else if (bedroomTypeOption == BedroomType.EXIT.getCode())
			bedroomType = BedroomType.EXIT;
		return bedroomType;
	}
}