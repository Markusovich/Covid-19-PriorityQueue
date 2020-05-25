package source;

public interface QueueInterface<T> {
	
	public boolean enqueue(Patient<T> newEntry);
	
	public Patient<T> getFront();
	
	public Patient<T> dequeue();
	
	public boolean isEmpty();
	
	public void clear();

}
