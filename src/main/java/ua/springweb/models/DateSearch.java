package ua.springweb.models;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
public class DateSearch {
	public DateSearch() {
		
	}
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public Date date1;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public Date date2;
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	
	
	

}

