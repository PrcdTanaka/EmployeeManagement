package d02.access.log;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class AccessLogSelectForm extends ActionForm {
	private int floor;
	private int year;
	private int month;

	private List<String> accessDate = new ArrayList<String>();
	private List<String> entryEmpName = new ArrayList<String>();
	private List<String> entryEmpNo = new ArrayList<String>();
	private List<String> entryTime = new ArrayList<String>();
	private List<String> exitEmpName = new ArrayList<String>();
	private List<String> exitEmpNo = new ArrayList<String>();
	private List<String> exitTime = new ArrayList<String>();
	private List<String> checkList = new ArrayList<String>();
	private List<String> status = new ArrayList<String>();

	public List<String> getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(String accessDate) {
		DateTimeFormatter dtformat = DateTimeFormatter
				.ofPattern("yyyy年MM月dd日(E)");
		int year = Integer.parseInt(accessDate.substring(0, 4));
		int month = Integer.parseInt(accessDate.substring(4, 6));
		int day = Integer.parseInt(accessDate.substring(6));
		LocalDate localAccessDate = LocalDate.of(year, month, day);
		String fdate = dtformat.format(localAccessDate);
		this.accessDate.add(fdate);
	}

	public List<String> getEntryEmpName() {
		return entryEmpName;
	}

	public void setEntryEmpName(String entryEmpName) {
		this.entryEmpName.add(entryEmpName);
	}

	public List<String> getEntryEmpNo() {
		return entryEmpNo;
	}

	public void setEntryEmpNo(String entryEmpNo) {
		this.entryEmpNo.add(entryEmpNo);
	}

	public List<String> getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime.add(entryTime);
	}

	public List<String> getExitEmpName() {
		return exitEmpName;
	}

	public void setExitEmpName(String exitEmpName) {
		if(exitEmpName == null){
			exitEmpName = "--------";
		}
		this.exitEmpName.add(exitEmpName);
	}

	public List<String> getExitEmpNo() {
		return exitEmpNo;
	}

	public void setExitEmpNo(String exitEmpNo) {
		if(exitEmpNo == null){
			exitEmpNo = "--------";
		}
		this.exitEmpNo.add(exitEmpNo);
	}

	public List<String> getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		if(exitTime == null){
			exitTime = "--------";
		}
		this.exitTime.add(exitTime);
	}

	public List<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(String checkList) {
		if (checkList == null) {
			checkList = "×";
		} else {
			checkList = "○";
		}
		this.checkList.add(checkList);
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(String status) {
		switch (status) {
		case "1":
			status = "入室";
			break;
		case "2":
			status = "退室";
			break;
		case "3":
			status = "再入室";
			break;
		case "4":
			status = "再退室";
			break;
		}
		this.status.add(status);
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
