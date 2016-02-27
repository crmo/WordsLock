package com.zl.lock.Junit;

import android.test.AndroidTestCase;

public class JunitTest extends AndroidTestCase {
	public void test(){
		String text = "confer";
		char c = text.charAt(0);
		//System.out.println("-------------"+c);
		assertEquals("c", c);
		
	}
}
