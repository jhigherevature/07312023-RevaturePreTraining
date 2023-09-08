package com.testing.basics;

import java.sql.SQLException;
import java.util.List;

public class A_ProblemChild {
	public void problematic() throws Exception {
		throw new Exception();
	}
	
	public void moreProblematic(boolean type) throws SQLException, IndexOutOfBoundsException {
		if (type) 
			throw new SQLException();
		else 
			throw new IndexOutOfBoundsException();
	}
	
	/*
	 * This method should sort the given list, and return the newly sorted list
	 */
	public List<Integer> badSort(List<Integer> list) {
		/*
		 * Incorrect sorting logic goes here...
		 */
		return list;
	}
}
