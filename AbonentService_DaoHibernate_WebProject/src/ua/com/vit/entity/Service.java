package ua.com.vit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="VitService")
public class Service {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceId;
	
	@Column(name = "service_name")
	private String serviceName;
	
	
	@Column(name = "sms_sending")
	private String smsSending;
	
	@Column(name = "extramoney")
	private String extraMoney ;
	
	@Column(name = "internet_usage")
	private String internetUsage ;

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getSmsSending() {
		return smsSending;
	}

	public void setSmsSending(String smsSending) {
		this.smsSending = smsSending;
	}

	public String getExtraMoney() {
		return extraMoney;
	}

	public void setExtraMoney(String extraMoney) {
		this.extraMoney = extraMoney;
	}

	public String getInternetUsage() {
		return internetUsage;
	}

	public void setInternetUsage(String internetUsage) {
		this.internetUsage = internetUsage;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", smsSending=" + smsSending
				+ ", extraMoney=" + extraMoney + ", internetUsage=" + internetUsage + "]";
	}
	
	
}
