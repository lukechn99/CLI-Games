public class Node {
	Node next;
	String data;

	public Node (String data, Node next) {
		this.next = next;
		this.data = data;
	}

	public void setNext (Node next) {
		this.next = next;
	}
	public void setData (String data) {
		this.data = data;
	}
	public Node getNext () {
		return next;
	}
	public String getData () {
		return data;
	}
	public boolean hasNext () {
		return next != null;
	}
}