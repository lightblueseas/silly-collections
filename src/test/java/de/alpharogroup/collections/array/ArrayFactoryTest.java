package de.alpharogroup.collections.array;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link ArrayFactory}.
 */
public class ArrayFactoryTest
{

	/**
	 * Test for method {@link ArrayFactory#newArray(Object...)}
	 */
	@Test
	public void testNewArray()
	{
		Integer actual;
		Integer expected;
		final Integer[] numbers = { 1, 2, 3 };
		final Integer[] array = ArrayFactory.newArray(1, 2, 3);
		for (int i = 0; i < numbers.length; i++)
		{
			expected = numbers[i];
			actual = array[i];
			assertEquals(expected, actual);
		}

		final Object[] objects = ArrayFactory.newArray();
		expected = 0;
		actual = objects.length;
		assertEquals(expected, actual);
	}

	/**
	 * Test the method {@link ArrayFactory#newRangeArray(int, int)}
	 */
	@Test
	public void testNewRangeArray()
	{
		Integer[] actual;
		Integer[] expected;
		actual = ArrayFactory.newRangeArray(5, 9);
		expected = ArrayFactory.newArray(5, 6, 7, 8, 9);
		assertTrue(Arrays.deepEquals(actual, expected));

		actual = ArrayFactory.newRangeArray(1, 49);
		expected = ArrayFactory.newArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
			17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
			39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49);

		assertTrue(Arrays.deepEquals(actual, expected));
	}

	/**
	 * Test method for {@link ArrayFactory} with {@link BeanTester}
	 */
	@Test(expectedExceptions = { BeanTestException.class, InvocationTargetException.class,
			UnsupportedOperationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ArrayFactory.class);
	}
}