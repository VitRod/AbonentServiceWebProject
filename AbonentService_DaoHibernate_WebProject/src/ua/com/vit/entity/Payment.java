package ua.com.vit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="VitPayment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "payment_amount")
	private Float paymentAmount;
	
	@Column(name = "payment_cash")
	private int paymentCash;
	
	@Column(name = "payment_card")
	private int paymentCard;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getPaymentCash() {
		return paymentCash;
	}

	public void setPaymentCash(int paymentCash) {
		this.paymentCash = paymentCash;
	}

	public int getPaymentCard() {
		return paymentCard;
	}

	public void setPaymentCard(int paymentCard) {
		this.paymentCard = paymentCard;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount
				+ ", paymentCash=" + paymentCash + ", paymentCard=" + paymentCard + "]";
	}
	
	
	
}
