
public class HashNode {
	
	HashNode head;
	HashNode next;
	String key;
	String value;
	
	public HashNode(){
		this.head = null;
		this.next = null;
		this.key = null;
		this.value = null;
	}
	
	public HashNode(String key, String value){
		this.head = null;
		this.next = null;
		this.key = key;
		this.value = value;
	}

	public HashNode getHead() {
		return head;
	}

	public void setHead(HashNode head) {
		this.head = head;
	}

	public HashNode getNext() {
		return next;
	}

	public void setNext(HashNode next) {
		this.next = next;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
