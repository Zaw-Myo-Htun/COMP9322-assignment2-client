package au.edu.unsw.soacourse.model;

public class RegistrationRequestDTO {
	
	public RegistrationRequestDTO(int iD, String name, String email) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
	}
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private String name;
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		        return new StringBuffer(" name : ").append(this.name)
		                .append("  id : ").append(this.ID)
		                .append(" email : ").append(this.email).toString();
		    }

	
	
	
}
