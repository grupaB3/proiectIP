package model;

public interface Monitor {

	void createFromTxt(String fileName);

	void removeComponentFromList(Object component);

	void addComponentToList(Object component);

	void sendCommand();

	void printComponentsList();

	void refresh();
}
