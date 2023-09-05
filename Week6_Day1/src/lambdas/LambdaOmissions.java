package lambdas;

public class LambdaOmissions {
	public static void main(String[] args) {
		/*
		 * Rule 0 : We NEVER need to state the datatype for Lamba parameters
		 */
		MathOpsSingle rule_0 = (d) -> { return d; };
		MathOps rule_zero = (x, y) -> { return x / y; };
		TripleArgs rule_zero_again = (a, b, c) -> { };
		
		/*
		 * Rule 1 : We can omit the parameter parenthesis if the func interface we are implementing
		 * 		has a single parameter and we do not state the datatype in the lambda syntax
		 */
		MathOpsSingle rule_one = x ->  { return x + 5; };
		MathOpsSingle rule_one_wrong = (x) ->  { return x + 5; };
		
		/*
		 * Rule 2 : We can omit the curly braces (for the lambda body) if the implementation is a single
		 * 		statement, AND we do not state the keyword 'return' if it is needed.
		 */
		MathOpsSingle rule_two1 = (Double a) -> a + 5;
		MathOps rule_two2 = (a, b) -> a * b;
		TripleArgs rule_two3 = (a, b, c) -> System.out.println("This is my implementation");
		TripleArgs rule_two4 = (a, b, c) -> { };
		
	}
}
