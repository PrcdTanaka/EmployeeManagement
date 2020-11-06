package a01.room.reservation;

import org.apache.struts.action.ActionForm;

public class RoomReservationMainForm extends ActionForm {

	private int floor;
	private String button;

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

}
