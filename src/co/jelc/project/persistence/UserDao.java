package co.jelc.project.persistence;

public interface UserDAO{
	
	boolean validateByCredentials(String username, String password);

}
