package ua.com.vit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="VitEvents")
public class Events {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventsId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "duration")
	private Double duration;
	
	@Column(name = "cost")
	private Float cost;

	public int getEventsId() {
		return eventsId;
	}

	public void setEventsId(int eventsId) {
		this.eventsId = eventsId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Events [eventsId=" + eventsId + ", type=" + type + ", date=" + date + ", duration=" + duration
				+ ", cost=" + cost + "]";
	}
	
	
	
}
