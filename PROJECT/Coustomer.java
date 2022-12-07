package PROJECT;

import java.util.ArrayList;

public class Coustomer implements Comparable<Coustomer> {
	private String id;
	private String mobile_phone;
	private String name;
	private String adress;
	private int LimitedPlan = 2;
	public int UnLIimitedPlan = 0;
	public ArrayList<Media> requestCart = new ArrayList<>();
	public ArrayList<Media> rentedCart = new ArrayList<>();
	private String Plan = "";

	@Override
	public String toString() {
		return "Coustomer" + ":" + getId() + ":" + getName() + ":" + getAdress() + ":" + getLimitedPlan() + ":"
				+ getUnLIimitedPlan() + ":" + getMobile_phone() + ":" + getPlan() + ":";
	}

	public int getUnLIimitedPlan() {
		return this.UnLIimitedPlan;
	}

	public void setUnLIimitedPlan(int unLIimitedPlan) {
		this.UnLIimitedPlan = unLIimitedPlan;
	}

	public Coustomer(String name, String adress, String plan, String id, String mobile_phone) {
		super();
		setName(name);
		setAdress(adress);
		setPlan(plan);
		setId(id);
		setMobile_phone(mobile_phone);
		System.out.println("____________________________________________________________________________________");

		System.out.println("This customer has been successfully added");
		System.out.println("____________________________________________________________________________________");

	}

	public String getPlan() {
		return this.Plan;
	}

	public void setPlan(String plan) {
		if (plan.equals("LIMITED")) {
			this.Plan = plan;
		} else if (plan.equals("UNLIMITED")) {
			this.Plan = plan;
		}
	}

	public Coustomer(String id, String name, String adress, int limitedPlan, int unLIimitedPlan, String mobile_phone,
			String plan) {
		super();
		setName(name);
		setAdress(adress);
		setPlan(plan);
		setLimitedPlan(limitedPlan);
		setId(id);
		setMobile_phone(mobile_phone);
		UnLIimitedPlan = unLIimitedPlan;

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public int compareTo(Coustomer m) {
		if (this.getName().compareTo(m.getName()) > 0) {
			return 1;
		} else if (this.getName().compareTo(m.getName()) == 0) {
			return 0;
		} else {
			return -1;
		}

	}

	public int getLimitedPlan() {
		return this.LimitedPlan;
	}

	public void setLimitedPlan(int limitedPlan) {

		try {
			WrongNegativeException.checkNegativeNumber(limitedPlan);
			this.LimitedPlan = limitedPlan;

		}

		catch (WrongNegativeException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile_phone() {
		return this.mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	@Override
	public boolean equals(Object o) {
		if (this.getName().equals(((Coustomer) o).getName())) {
			return true;
		}
		return false;
	}

	public String GetInfoCustomer() {
		String str = String.format("Customer  ID  : %s", this.getId());
		str += String.format("\n Customer name :  : %s ", this.getName());
		str += String.format("\n Address : %s ", this.getAdress());
		str += String.format("\n Plan :  %s \n ", this.getPlan());
		str += "############################################################################\n";
		return str;
	}
}
