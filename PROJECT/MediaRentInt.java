package PROJECT;

import java.util.ArrayList;

public interface MediaRentInt {
	void addCustomer(String name, String address, String plan, String id, String mobile_phone);

	void addMovie(String title, int CopiesAvalible, String rating, String code);

	void addGame(String title, int CopiesAvalible, double weigth, String code);

	void addAlbum(String title, int CopiesAvalible, String atrtist, String songs, String code);

	void setLimitedPlanLimit(int value);

	String getAllCoustomers();

	String getAllMedia();

	boolean addToCart(String costomerId, String mediaCode);

	boolean removeToCart(String costomerId, String mediaCode);

	String processRequest();

	boolean returnMedia(String costomerId, String mediaCode);

	ArrayList<String> searchMedia(String title, String rating, String artist, String songs);

}
