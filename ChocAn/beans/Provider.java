package beans;

import java.util.ArrayList;

public class Provider extends User {
	
	public static final double PERCENTAGE = 0.4;
	
	private int fkIdProvider;
	private int status;
	private ArrayList<Service> serviceList;

	public Provider(){}
	
	public Provider(
			int fkIdProvider,
			ArrayList<Service> serviceList
			){
		this.serviceList = serviceList;
		this.fkIdProvider = fkIdProvider;
	}

	public int getFkIdProvider() {
		return fkIdProvider;
	}

	public void setFkIdProvider(int fkIdProvider) {
		this.fkIdProvider = fkIdProvider;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public ArrayList<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(ArrayList<Service> serviceList) {
		this.serviceList = serviceList;
	}
	
	
	
}
