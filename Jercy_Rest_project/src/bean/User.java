package bean;

public class User 
{
	private String name,dob,doj;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String dob, String doj) {
		super();
		this.name = name;
		this.dob = dob;
		this.doj = doj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	

}
