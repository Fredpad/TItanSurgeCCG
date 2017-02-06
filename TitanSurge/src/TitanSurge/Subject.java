package TitanSurge;

//Interface used to created the observer pattern
public interface Subject {
	public void setObservers(Observer obs);
	public void removeObservers(Observer obs);
	public void hasChanged();
	public void clearChanged();
	public void notifyObservers();
	public void recordConditions();
}
