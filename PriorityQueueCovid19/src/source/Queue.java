package source;

public class Queue<T> implements QueueInterface<T> {
	
	private class Node<T>{
		private Patient<T> data;
		private Node<T> next;
		
		private Node(Node<T> prev, Patient<T> data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		private Node(Patient<T> data) {
			this.data = data;
		}
		private Patient<T> getNodeData() {
			return data;
		}
		private void setNodeData(Patient<T> newEntry) {
			data = newEntry;
		}
		private Node<T> getNextNode() {
			return next;
		}
		private void setNextNode(Node<T> newNode) {
			next = newNode;
		}
	
	}
	
	private Node<T> firstNode;
	private Node<T> currentNode;
	
	public Queue() {
		firstNode = null;
		currentNode = null;
	}

	public boolean enqueue(Patient<T> newEntry) {
		
		Node<T> newNode = new Node<T>(newEntry);
		
		if(firstNode == null) {
			firstNode = newNode;
			return true;
		}
		else {
			if(newEntry.getRisklevel().equals("H")) {
				currentNode = firstNode;
				while(currentNode.getNextNode() != null) {
					if(!currentNode.getNextNode().getNodeData().getRisklevel().equals("H")) {
						break;
					}
					currentNode = currentNode.getNextNode();
				}
				Node<T> currentNext = currentNode.getNextNode();
				currentNode.setNextNode(newNode);
				newNode.setNextNode(currentNext);
				return true;
			}
			if(newEntry.getRisklevel().equals("M")) {
				currentNode = firstNode;
				while(currentNode.getNextNode() != null) {
					if(!currentNode.getNextNode().getNodeData().getRisklevel().equals("H") && 
							!currentNode.getNextNode().getNodeData().getRisklevel().equals("M") &&
							currentNode.getNextNode().getNodeData().getRisklevel().equals("L")) {
						break;
					}
					currentNode = currentNode.getNextNode();
				}
				Node<T> currentNext = currentNode.getNextNode();
				currentNode.setNextNode(newNode);
				newNode.setNextNode(currentNext);
				return true;
			}
			if(newEntry.getRisklevel().equals("L")) {
				currentNode = firstNode;
				while(currentNode.getNextNode() != null) {
					currentNode = currentNode.getNextNode();
				}
				currentNode.setNextNode(newNode);
				return true;
			}
			else {
				return false;
			}
		}
	}
	public Patient<T> getFront() {
		if(isEmpty()) {
			return null;
		}
		return firstNode.getNodeData();
	}
	public Patient<T> dequeue() {
		Patient<T> front = getFront();
		firstNode.setNodeData(null);
		firstNode = firstNode.getNextNode();
		return front;
	}
	public boolean isEmpty() {
		return firstNode == null;
	}
	public void clear() {
		firstNode = null;
	}
}
