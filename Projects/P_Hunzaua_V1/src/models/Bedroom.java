package models;

public class Bedroom {

	private static int sequential = 0;
	private int roomCode;
	private int bedQuantity;
	private BedroomType roomType;
	private double cost;
	private boolean available;
	
	public Bedroom(int bedQuantity, BedroomType roomType, double cost){
		this.bedQuantity = bedQuantity;
		this.roomType = roomType;
		this.cost = cost;
		this.available = true;
		this.roomCode = ++this.sequential;
	}
	
	public int getRoomCode() {
		return roomCode;
	}

	public int getBedQuantity() {
		return bedQuantity;
	}

	public BedroomType getRoomType() {
		return roomType;
	}

	public double getCost() {
		return cost;
	}
	
	public void disableRoom(){
		this.available = false;
	}

	public boolean isAvailable(){
		return available;
	}
	
	public Object[] toObjectArray(){
		return new Object[] {this.roomCode, this.available, this.cost, this.roomType, this.bedQuantity};
	}
}
