package postfix;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 
 * @author Sathish Gopalakrishnan
 * 
 * This class contains a method to evaluate an arithmetic expression
 * that is in Postfix notation (or Reverse Polish Notation).
 * See <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Wikipedia</a>
 * for details on the notation.
 *
 */
public class PostfixEvaluator {
	
	private String arithmeticExpr;
	
	/**
	 * This is the only constructor for this class.
	 * It takes a string that represents an arithmetic expression
	 * as input argument.
	 * 
	 * @param expr is a string that represents an arithmetic expression 
	 * <strong>in Postfix notation</strong>.
	 */
	public PostfixEvaluator( String expr ) {
		arithmeticExpr = expr;
	}
	
	/**
	 * This method evaluates the arithmetic expression that 
	 * was passed as a string to the constructor for this class.
	 * 
	 * @return the value of the arithmetic expression
	 * @throws MalformedExpressionException if the provided expression is not
	 * 	a valid expression in Postfix notation
	 */
	double eval( ) throws MalformedExpressionException {
		// TODO: Implement this method.
        Stack<Double> postfix_Evaluator = new Stack<>();
        Scanner arithmeticExpressionScanner = new Scanner(arithmeticExpr);
        double answer;

        while(!arithmeticExpressionScanner.isEmpty()){
            Token current_Token = arithmeticExpressionScanner.getToken();
            arithmeticExpressionScanner.eatToken();
            double opperandTwo;
            double opperandOne;
            if (current_Token.isDouble()){
                postfix_Evaluator.push(current_Token.getValue());
            }
            else{
                try{
                   opperandTwo = postfix_Evaluator.pop();
                   opperandOne = postfix_Evaluator.pop();
                }
                catch (EmptyStackException e){
                    throw new  MalformedExpressionException();
                }

                if(current_Token.getName().equals("+") ){
                    postfix_Evaluator.push(opperandTwo + opperandOne);
                }
                else if(current_Token.getName().equals("-") ){
                    postfix_Evaluator.push(opperandOne - opperandTwo);
                }
                else if(current_Token.getName().equals("*") ){
                    postfix_Evaluator.push(opperandTwo * opperandOne);
                }
                else if(current_Token.getName().equals("/") ){
                    postfix_Evaluator.push(opperandOne / opperandTwo);
                }
            }
        }

        answer = postfix_Evaluator.pop();

        if(!postfix_Evaluator.isEmpty()){
            throw new MalformedExpressionException();
        }

		// The code provided here is for illustration only, and
		// can be deleted when you write your implementation.

		// Using a stack makes it very simple to evaluate the
		// arithmetic expression.
		// See http://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
		
		// Use the Scanner to get the elements (tokens) in the
		// arithmetic expression.

		//Scanner scanner = new Scanner(arithmeticExpr);
		//Token currToken = scanner.getToken();
		
		// now process the token, etc.
		// You should read the implementation of the Token class
		// to determine what methods you can and should use.
		
		// It is sufficient to support the four basic operations:
		// addition, subtraction, multiplication & division.
		
		return answer;
	}
	
}