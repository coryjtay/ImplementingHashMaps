// PROGRAMMER: COREY TAYLOR
public class PrimitiveIntKeyStringValueSeparateChainingHashMap {

	// INSTANCE VARIABLES
	private int numberOfBuckets;
	private int size;
	private PrimitiveIntKeyStringValueSeparateChainingHashMapNode[] bucket;

	// CONSTRUCTORS
	public PrimitiveIntKeyStringValueSeparateChainingHashMap() {
		numberOfBuckets = 10;
		size = 0;
		bucket = new PrimitiveIntKeyStringValueSeparateChainingHashMapNode[numberOfBuckets];
	}

	public PrimitiveIntKeyStringValueSeparateChainingHashMap(int numberOfBuckets) {
		if (numberOfBuckets <= 0) {
			throw new IllegalArgumentException("Number of buckets cannot be less than or equal to zero");
		}
		size = 0;
		this.numberOfBuckets = numberOfBuckets;
		bucket = new PrimitiveIntKeyStringValueSeparateChainingHashMapNode[numberOfBuckets];
	}

	// INSTANCE METHODS
	private int hashCodeIndex(int key) {
		int hashCode = Math.abs(key); // non negative hashCode
		return (hashCode % numberOfBuckets);
	}

	public String put(int key, String value) {
		int index = hashCodeIndex(key);
		PrimitiveIntKeyStringValueSeparateChainingHashMapNode currentNode = bucket[index];
		while (currentNode != null) {
			if (currentNode.getKey() == key) {
				String oldValue = currentNode.getValue();
				currentNode.setValue(value);
				return oldValue;
			}
			currentNode = currentNode.getNextNode();
		}
		PrimitiveIntKeyStringValueSeparateChainingHashMapNode newNode = new PrimitiveIntKeyStringValueSeparateChainingHashMapNode(
				key, value, bucket[index]);
		bucket[index] = newNode;
		size++;
		return null;
	}

	public int getSize() {
		return size;
	}

	public String get(int key) {
		int index = hashCodeIndex(key);
		PrimitiveIntKeyStringValueSeparateChainingHashMapNode currentNode = bucket[index];
		if (currentNode.getKey() == key) {
			return currentNode.getValue();
		} else {
			throw new IllegalArgumentException("No known value with specified key");
		}
	}

	public String remove(int key) {
		int index = hashCodeIndex(key);
		PrimitiveIntKeyStringValueSeparateChainingHashMapNode currentNode = bucket[index];
		PrimitiveIntKeyStringValueSeparateChainingHashMapNode previousNode = null;

		while (currentNode != null) {
			if (currentNode.getKey() == key) {
				if (previousNode == null) {
					// key is in first node of bucket
					bucket[index] = currentNode.getNextNode();
				} else {
					// key is in a non-first node of bucket
					previousNode.setNextNode(currentNode.getNextNode());
				}
				size--;
				return currentNode.getValue();
			}
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return null;
	}

	public double loadFactor() {
		return size / numberOfBuckets;
	}
}
