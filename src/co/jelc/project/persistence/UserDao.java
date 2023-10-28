package co.jelc.project.persistence;

public interface UserDao{
	
	boolean validateByCredentials(String username, String password);

}
