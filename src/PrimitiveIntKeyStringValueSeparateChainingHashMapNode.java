// PROGRAMMER: COREY TAYLOR
public class PrimitiveIntKeyStringValueSeparateChainingHashMapNode {

	// INSTANCE VARIABLES
	private PrimitiveIntKeyStringValueSeparateChainingHashMapNode nextNode;
	private int key;
	private String value;

	// CONSTRUCTOR
	public PrimitiveIntKeyStringValueSeparateChainingHashMapNode(int key, String value,
			PrimitiveIntKeyStringValueSeparateChainingHashMapNode nextNode) {
		this.key = key;
		this.value = value;
		this.nextNode = nextNode;
	}

	// INSTANCE METHODS
	public PrimitiveIntKeyStringValueSeparateChainingHashMapNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(PrimitiveIntKeyStringValueSeparateChainingHashMapNode nextNode) {
		this.nextNode = nextNode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getKey() {
		return key;
	}

}
