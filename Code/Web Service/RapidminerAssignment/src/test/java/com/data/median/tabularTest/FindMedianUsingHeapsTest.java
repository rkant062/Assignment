package com.data.median.tabularTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.data.median.service.FindMedianUsingHeaps;

public class FindMedianUsingHeapsTest {

	@Test
	public void medianOddTest() {
		FindMedianUsingHeaps heap = new FindMedianUsingHeaps();
		double array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (double d : array)
			heap.addNum(d);
		assertEquals(heap.findMedian(), array[(array.length - 1) / 2], 0);

	}

	@Test
	public void medianEvenTest() {
		FindMedianUsingHeaps heap = new FindMedianUsingHeaps();
		double array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (double d : array)
			heap.addNum(d);
		assertEquals(heap.findMedian(), (array[(array.length - 1) / 2] + array[(array.length - 1) / 2 + 1]) / 2.0, 0);

	}

	@Test
	public void medianUnsortedTest() {
		FindMedianUsingHeaps heap = new FindMedianUsingHeaps();
		int array[] = { 7, 4, 1, 2, 5, 3, 6, 8 };
		for (int d : array)
			heap.addNum(d);
		Arrays.sort(array);
		assertEquals(heap.findMedian(), (array[(array.length - 1) / 2] + array[(array.length - 1) / 2 + 1]) / 2.0, 0);

	}
}