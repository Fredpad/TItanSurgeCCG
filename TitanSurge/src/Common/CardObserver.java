package Common;

public interface CardObserver {
	void update(String command, String key);
	void update(String command, int value);
	void update(String command);
	void update(String command,int position, int value);
	void update(String command, int value, String status, int position );
	int get(String command);
}
