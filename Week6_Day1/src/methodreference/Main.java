package methodreference;

public class Main {
	public static void main(String[] args) {
		
		StringToNum lambda = (String word) -> { return word.length(); };
		lambda.giveNumFromString("Hello");
		
		StringToNum mtdRef = String::length;
		
		
		StringToNum staticMtdRef = Main::implementsStringToNum;
		staticMtdRef.giveNumFromString("Hello");
		
		Main m = new Main();
		StringToNum instanceVarMtdRef = m::instanceImplementationStringToNum;
		
		invokeStringToNumMethod(instanceVarMtdRef, "Hello");
		
		invokeStringToNumMethod(Main::implementsStringToNum, "Hello");
		
		ObjectMaker lambdaImplementation = () -> {return new Object(); };
		
		ObjectMaker constructorMtdRef = Object::new;
		
	}
	
	
	
	public static void invokeStringToNumMethod(StringToNum implementation, String input) {
		implementation.giveNumFromString(input);
	}
	
	
	
	public static int implementsStringToNum(String s) {
		return 0;
	}
	
	public int instanceImplementationStringToNum(String s) {
		return 0;
	}
}


