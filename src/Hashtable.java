
public class Hashtable {

	/*
	 * Implements seperate chaining policy, creating a linked list for each arr slot.
	 */
	HashNode[] arr; //when full, create new array
	
	public Hashtable(){
		arr = new HashNode[314527];
	}

	public void put(String key, String val) {
		// TODO Auto-generated method stub
		HashNode node = new HashNode(key, val);
		int place = Math.abs((key.hashCode()) % arr.length);		
		
		if(arr[place] == null){
			arr[place] = node;
			return;
		} else {
			HashNode curr = arr[place];
			if(curr.getKey().equals(key)){
				curr.setValue(val);
				return;
			}
			while(curr.getNext() != null){
				if(curr.getKey().equals(key)){
					curr.setValue(val);
					return;
				}
				curr = curr.getNext();
			}			
		}

		node.setNext(arr[place]);
		arr[place] = node;		
	
	}

	public Object get(String key) {
		// TODO Auto-generated method stub
		int place = Math.abs((key.hashCode()) % arr.length);
		if(arr[place] == null){
			return null;
		}
		HashNode curr = arr[place];
		if(curr.getKey().equals(key)){
			return curr.getValue();
		}
		while(curr.getNext() != null){
			if(curr.getKey().equals(key))
				return curr.getValue();
			curr = curr.getNext();
		}
		return null;
	}

	public String remove(String key) throws Exception {
		int place = Math.abs((key.hashCode()) % arr.length);
		String returnString = "";
		if(arr[place] == null){
			return null;
		}
//		if(arr[place] == null){
//			try {
//				throw new Exception();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		HashNode curr = arr[place];
		HashNode prev = arr[place];

		while(curr.getNext() != null){
			prev = curr;
			curr = curr.getNext();	
			if(curr.getKey().equals(key)){	
				returnString = curr.getValue();
				if(curr.getNext() != null){
					prev.setNext(curr.getNext());
					curr = prev;
				} else {
					curr.setNext(null);
				}
			}		
		}
		
		returnString = curr.getValue();
		if(curr.getKey().equals(key)){
			prev.setNext(null);
		}
		if(arr[place].getKey().equals(key) && arr[place].getNext() == null){
			arr[place] = new HashNode();
		} else {
			arr[place] = arr[place].getNext();
		}
		
		return returnString;
//		while(curr.getNext() != null){
//			if(curr.getKey().equals(key)){
//				if(curr == head) {
//					continue;
//				} else if(curr.getNext() == null) {
//					prev.setNext(null);
//				} else {
//					prev.setNext(curr.getNext());
//				}
//			}
//			prev = curr;
//		}
//		if(head.getKey().equals(key))
//			arr[place] = arr[place].getNext();					

	}

	public boolean containsKey(String key) {
		// TODO Auto-generated method stub
		int place = Math.abs((key.hashCode()) % arr.length);
		if(arr[place] == null)
			return false;
		HashNode curr = arr[place];

		while(curr.getNext() != null){
			if(curr.getKey().equals(key))
				return true;
			curr = curr.getNext();
		}
		if(arr[place].equals(key))
			return true;
		return false;
	}

	/* Prints all values associated with given key. */
	public void printKeyList(String key){
		int place = Math.abs((key.hashCode()) % arr.length);
		if(arr[place] == null)
			return;
		HashNode curr = arr[place];
		System.out.print(curr.getValue() + " ");
		while(curr.getNext() != null){
			curr = curr.getNext();
			System.out.print(curr.getValue() + " ");
		}
		System.out.println();
	}

	public void printKeys(){
		for(HashNode node : arr){
			if(node != null){
				System.out.print(node.getKey() + " ");
			} else {
				System.out.print(node + " ");
			}		
		}
		System.out.println();
	}

	
}
