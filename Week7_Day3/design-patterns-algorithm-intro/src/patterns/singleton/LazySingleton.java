package patterns.singleton;

/*
 * A Singleton design patterns insures that we only have a single
 * object created for a specific class.
 * 
 * 'Lazy' or 'Late' instantiation, means that our Singleton object
 * should be created when the upon the first call to retrieve the object.
 * This means our Singleton may potentially never be instantiated if 
 * it is not required.
 */
public class LazySingleton {
	private String data;
	
	private static LazySingleton mySingleton;
	
	/*
	 * The Constructor of this class is declared as private so that a
	 * new instance cannot be created directly, instead we must retrieve
	 * the instance using the 'getInstance()' method below.
	 */
	private LazySingleton() { }
	
	/*
	 * The 'getInstance' method allows you to get a reference to the 
	 * Singleton object. The first time this method is called a new 
	 * Singleton object is created. Otherwise the existing reference
	 * is returned
	 */
	public static LazySingleton getInstance() {
		if (mySingleton == null) mySingleton = new LazySingleton();

		return mySingleton;
	}
	
	/*
	 * The 'clone' method can be used to create a copy of an object.
	 * Since we are implementing the singleton pattern, we override
	 * this method to throw an exception.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
