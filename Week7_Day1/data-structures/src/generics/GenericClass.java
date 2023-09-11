package generics;

public class GenericClass<K, T> {
	private K key;
	private T value;
	
	public T getValue() {
		return value;
	}	
	public void setValue(T value) {
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}	
	public void setKey(K key) {
		this.key = key;
	}
}
