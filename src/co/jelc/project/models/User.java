package co.jelc.project.models;

public class User {

	private Integer id;
	
	private String username;
	
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	
	public String getPassword() {
		return password;
	}

	
	
	
	
}
