package com.amazonaws.lambda.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
@RunWith(MockitoJUnitRunner.class)
public class LambdaFunctionHandlerTest {

	@Test
    public void return_encoded_string() {
		 LambdaFunctionHandler handler = new LambdaFunctionHandler();
		 handler.startLoad();
		
	}

}


