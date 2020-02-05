package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Hotel {
	
	public static final int VALUE_NOT_FOUND_CODE = -1;
	private ArrayList<Bedroom> bedroomList;
	
	public Hotel(){
		bedroomList = new ArrayList<Bedroom>();
	}

	public ArrayList<Bedroom> getBedroomList() {
		return bedroomList;
	}

	public void addBedroom(Bedroom bedroom){
		this.bedroomList.add(bedroom);
	}

	public Bedroom createBedroom(int bedQuantity, BedroomType roomType, double cost){
		return new Bedroom(bedQuantity, roomType,cost);
	}

	public Bedroom searchBedroom(int bedroomCode) throws NullPointerException, ArrayIndexOutOfBoundsException{
		this.organizeBedroomListByCode();
		int position = VALUE_NOT_FOUND_CODE, half,initialP = 0, finalP = this.bedroomList.size()-1;
		while(initialP <= finalP && position == -1){
			half = (int)((finalP + initialP)/2);
			if(half >= 0 && half < this.bedroomList.size())
				if(bedroomCode > this.bedroomList.get(half).getRoomCode())
					initialP = half + 1;
				else if(bedroomCode < this.bedroomList.get(half).getRoomCode())
					finalP = half - 1;
				else
					position = half;
		}
		return this.bedroomList.get(position);
	}

	private void organizeBedroomListByCode(){
		Collections.sort(this.bedroomList, new Comparator<Bedroom>(){
			public int compare(Bedroom room1, Bedroom room2) {
				if (room1.getRoomCode() > room2.getRoomCode()) return 1;
				else if(room1.getRoomCode() < room2.getRoomCode()) return -1;
				else return 0;
			}
		});
	}

	public void removeBedroom(Bedroom bedroom){
		this.bedroomList.remove(bedroom);
	}

	public double getBedroomPercent(int bedroomQuantity) throws ArithmeticException{
		return (bedroomQuantity * 100)/bedroomList.size();
	}
	
	public int getRoomAvailabilityQuantity(){
		int roomAvailabilityQuantity = 0;
		for (Bedroom bedroom : bedroomList) {
			if(bedroom.isAvailable())
				roomAvailabilityQuantity++;
		}
		return roomAvailabilityQuantity;
	}

	public int getRoomUnavailabilityQuantity(){
		int roomUnavailabilityQuantity = 0;
		for (Bedroom bedroom : bedroomList) {
			if(!bedroom.isAvailable())
				roomUnavailabilityQuantity++;
		}
		return roomUnavailabilityQuantity;
	}

	public ArrayList<Bedroom> getBedroomListByCost(double cost){
		ArrayList<Bedroom> bedroomListByCost = new ArrayList<Bedroom>();
		for (Bedroom bedroom : bedroomList) {
			if(bedroom.getCost() <= cost)
				bedroomListByCost.add(bedroom);
		}
		return bedroomListByCost;
	}

	public ArrayList<Object[]> getBedroomMatrixInformation(){
		ArrayList<Object[]> bedroomMatrixInformation = new ArrayList<Object[]>();
		Iterator<Bedroom> it = this.bedroomList.iterator();
		while(it.hasNext()){
			bedroomMatrixInformation.add(it.next().toObjectArray());
		}
		return bedroomMatrixInformation;
	}

	public int getBedroomQuantityByType(BedroomType type){
		System.out.println("good");
		int bedroomQuantityByType = 0;
		for (Bedroom bedroom : bedroomList) {
			if(bedroom.getRoomType() == type)
				bedroomQuantityByType++;
		}
		return bedroomQuantityByType;
	}
}