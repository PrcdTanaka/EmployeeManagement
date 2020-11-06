package a02.room.reservation.confirm;

import org.apache.struts.action.ActionForm;

public final class ReservationCalendarForm extends ActionForm {

	private String date;
	private String month;
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
