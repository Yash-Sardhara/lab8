package postfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

	// Implement a sufficient number of tests to have
	// reasonable confidence in the correctness of your
	// PostfixEvaluator implementation.
	
	@Test
	public void test1() throws MalformedExpressionException {
	    PostfixEvaluator pe = new PostfixEvaluator("5 2 +");
	    pe.eval();
	}

}