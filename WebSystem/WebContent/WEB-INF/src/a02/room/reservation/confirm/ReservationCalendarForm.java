package a02.room.reservation.confirm;

import org.apache.struts.action.ActionForm;

public class ReservationCalendarForm extends ActionForm {

	private String date;
	private String month;
	private String button;

	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
}
