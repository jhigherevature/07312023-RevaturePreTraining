package patterns.singleton;

/*
 * A Singleton design patterns insures that we only have a single
 * object created for a specific class.
 * 
 * 'Eager' or 'Early' instantiation, means that our Singleton object
 * should be created when the class is loaded into memory. This means
 * our Singleton is always available in our application.
 */
public class EagerSingleton {
	private String data;
	
	private static EagerSingleton mySingleton = new EagerSingleton();
	
	/*
	 * The Constructor of this class is declared as private so that a
	 * new instance cannot be created directly, instead we must retrieve
	 * the instance using the 'getInstance()' method below.
	 */
	private EagerSingleton() { }
	
	/*
	 * The 'getInstance' method allows you to get a reference to
	 * the Singleton object
	 */
	public static EagerSingleton getInstance() {
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
