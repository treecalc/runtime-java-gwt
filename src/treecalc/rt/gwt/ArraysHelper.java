package treecalc.rt.gwt;

import java.util.Arrays;

import treecalc.rt.V;

public class ArraysHelper {

	public static V[] copyOfV (Object[] objs, int newLength) {

		V[] result = new V[newLength];

		if (objs != null) {
			for (int i=0; i<newLength && i<objs.length; i++) {
				result[i] = (V) objs[i];
			}
		}

		return result;
	}

	public static V[] copyOfRangeV (Object[] objs, int from, int to) {

		int size = to - from;

		V[] result = new V[size];

		if (objs != null) {
			for (int i=0; i<size && i+from<objs.length; i++) {
				result[i] = (V) objs[i+from];
			}
		}

		return result;
	}


	/**
	 * Returns a copy of the supplied array, truncating or padding as
	 * necessary with <code>0d</code> to obtain the specified length.
	 * Indices that are valid for both arrays will return the same value.
	 * Indices that only exist in the returned array (due to the new length
	 * being greater than the original length) will return <code>0d</code>.
	 * This is equivalent to calling
	 * <code>copyOfRange(original, 0, newLength)</code>.
	 *
	 * @param original the original array to be copied.
	 * @param newLength the length of the returned array.
	 * @return a copy of the original array, truncated or padded with
	 *         <code>0d</code> to obtain the required length.
	 * @throws NegativeArraySizeException if <code>newLength</code> is negative.
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOfRange(double[],int,int)
	 */
	public static double[] copyOf(double[] original, int newLength)
	{
		if (newLength < 0)
			throw new NegativeArraySizeException("The array size is negative.");
		return copyOfRange(original, 0, newLength);
	}

	/**
	 * Copies the specified range of the supplied array to a new
	 * array, padding as necessary with <code>0d</code>
	 * if <code>to</code> is greater than the length of the original
	 * array.  <code>from</code> must be in the range zero to
	 * <code>original.length</code> and can not be greater than
	 * <code>to</code>.  The initial element of the
	 * returned array will be equal to <code>original[from]</code>,
	 * except where <code>from</code> is equal to <code>to</code>
	 * (where a zero-length array will be returned) or <code>
	 * <code>from</code> is equal to <code>original.length</code>
	 * (where an array padded with <code>0d</code> will be
	 * returned).  The returned array is always of length
	 * <code>to - from</code>.
	 *
	 * @param original the array from which to copy.
	 * @param from the initial index of the range, inclusive.
	 * @param to the final index of the range, exclusive.
	 * @return a copy of the specified range, with padding to
	 *         obtain the required length.
	 * @throws ArrayIndexOutOfBoundsException if <code>from < 0</code>
	 *                                        or <code>from > original.length</code>
	 * @throws IllegalArgumentException if <code>from > to</code>
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOf(double[],int)
	 */
	public static double[] copyOfRange(double[] original, int from, int to)
	{
		if (from > to)
			throw new IllegalArgumentException("The initial index is after " +
					"the final index.");
		double[] newArray = new double[to - from];
		if (to > original.length)
		{
			System.arraycopy(original, from, newArray, 0,
					original.length - from);
			Arrays.fill(newArray, original.length, newArray.length, 0d);
		}
		else
			System.arraycopy(original, from, newArray, 0, to - from);
		return newArray;
	}

	/**
	 * Returns a copy of the supplied array, truncating or padding as
	 * necessary with <code>0f</code> to obtain the specified length.
	 * Indices that are valid for both arrays will return the same value.
	 * Indices that only exist in the returned array (due to the new length
	 * being greater than the original length) will return <code>0f</code>.
	 * This is equivalent to calling
	 * <code>copyOfRange(original, 0, newLength)</code>.
	 *
	 * @param original the original array to be copied.
	 * @param newLength the length of the returned array.
	 * @return a copy of the original array, truncated or padded with
	 *         <code>0f</code> to obtain the required length.
	 * @throws NegativeArraySizeException if <code>newLength</code> is negative.
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOfRange(float[],int,int)
	 */
	public static float[] copyOf(float[] original, int newLength)
	{
		if (newLength < 0)
			throw new NegativeArraySizeException("The array size is negative.");
		return copyOfRange(original, 0, newLength);
	}

	/**
	 * Copies the specified range of the supplied array to a new
	 * array, padding as necessary with <code>0f</code>
	 * if <code>to</code> is greater than the length of the original
	 * array.  <code>from</code> must be in the range zero to
	 * <code>original.length</code> and can not be greater than
	 * <code>to</code>.  The initial element of the
	 * returned array will be equal to <code>original[from]</code>,
	 * except where <code>from</code> is equal to <code>to</code>
	 * (where a zero-length array will be returned) or <code>
	 * <code>from</code> is equal to <code>original.length</code>
	 * (where an array padded with <code>0f</code> will be
	 * returned).  The returned array is always of length
	 * <code>to - from</code>.
	 *
	 * @param original the array from which to copy.
	 * @param from the initial index of the range, inclusive.
	 * @param to the final index of the range, exclusive.
	 * @return a copy of the specified range, with padding to
	 *         obtain the required length.
	 * @throws ArrayIndexOutOfBoundsException if <code>from < 0</code>
	 *                                        or <code>from > original.length</code>
	 * @throws IllegalArgumentException if <code>from > to</code>
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOf(float[],int)
	 */
	public static float[] copyOfRange(float[] original, int from, int to)
	{
		if (from > to)
			throw new IllegalArgumentException("The initial index is after " +
					"the final index.");
		float[] newArray = new float[to - from];
		if (to > original.length)
		{
			System.arraycopy(original, from, newArray, 0,
					original.length - from);
			Arrays.fill(newArray, original.length, newArray.length, 0f);
		}
		else
			System.arraycopy(original, from, newArray, 0, to - from);
		return newArray;
	}

	/**
	 * Returns a copy of the supplied array, truncating or padding as
	 * necessary with <code>0</code> to obtain the specified length.
	 * Indices that are valid for both arrays will return the same value.
	 * Indices that only exist in the returned array (due to the new length
	 * being greater than the original length) will return <code>0</code>.
	 * This is equivalent to calling
	 * <code>copyOfRange(original, 0, newLength)</code>.
	 *
	 * @param original the original array to be copied.
	 * @param newLength the length of the returned array.
	 * @return a copy of the original array, truncated or padded with
	 *         <code>0</code> to obtain the required length.
	 * @throws NegativeArraySizeException if <code>newLength</code> is negative.
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOfRange(int[],int,int)
	 */
	public static int[] copyOf(int[] original, int newLength)
	{
		if (newLength < 0)
			throw new NegativeArraySizeException("The array size is negative.");
		return copyOfRange(original, 0, newLength);
	}

	/**
	 * Copies the specified range of the supplied array to a new
	 * array, padding as necessary with <code>0</code>
	 * if <code>to</code> is greater than the length of the original
	 * array.  <code>from</code> must be in the range zero to
	 * <code>original.length</code> and can not be greater than
	 * <code>to</code>.  The initial element of the
	 * returned array will be equal to <code>original[from]</code>,
	 * except where <code>from</code> is equal to <code>to</code>
	 * (where a zero-length array will be returned) or <code>
	 * <code>from</code> is equal to <code>original.length</code>
	 * (where an array padded with <code>0</code> will be
	 * returned).  The returned array is always of length
	 * <code>to - from</code>.
	 *
	 * @param original the array from which to copy.
	 * @param from the initial index of the range, inclusive.
	 * @param to the final index of the range, exclusive.
	 * @return a copy of the specified range, with padding to
	 *         obtain the required length.
	 * @throws ArrayIndexOutOfBoundsException if <code>from < 0</code>
	 *                                        or <code>from > original.length</code>
	 * @throws IllegalArgumentException if <code>from > to</code>
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOf(int[],int)
	 */
	public static int[] copyOfRange(int[] original, int from, int to)
	{
		if (from > to)
			throw new IllegalArgumentException("The initial index is after " +
					"the final index.");
		int[] newArray = new int[to - from];
		if (to > original.length)
		{
			System.arraycopy(original, from, newArray, 0,
					original.length - from);
			Arrays.fill(newArray, original.length, newArray.length, 0);
		}
		else
			System.arraycopy(original, from, newArray, 0, to - from);
		return newArray;
	}

	/**
	 * Returns a copy of the supplied array, truncating or padding as
	 * necessary with <code>0L</code> to obtain the specified length.
	 * Indices that are valid for both arrays will return the same value.
	 * Indices that only exist in the returned array (due to the new length
	 * being greater than the original length) will return <code>0L</code>.
	 * This is equivalent to calling
	 * <code>copyOfRange(original, 0, newLength)</code>.
	 *
	 * @param original the original array to be copied.
	 * @param newLength the length of the returned array.
	 * @return a copy of the original array, truncated or padded with
	 *         <code>0L</code> to obtain the required length.
	 * @throws NegativeArraySizeException if <code>newLength</code> is negative.
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOfRange(long[],int,int)
	 */
	public static long[] copyOf(long[] original, int newLength)
	{
		if (newLength < 0)
			throw new NegativeArraySizeException("The array size is negative.");
		return copyOfRange(original, 0, newLength);
	}

	/**
	 * Copies the specified range of the supplied array to a new
	 * array, padding as necessary with <code>0L</code>
	 * if <code>to</code> is greater than the length of the original
	 * array.  <code>from</code> must be in the range zero to
	 * <code>original.length</code> and can not be greater than
	 * <code>to</code>.  The initial element of the
	 * returned array will be equal to <code>original[from]</code>,
	 * except where <code>from</code> is equal to <code>to</code>
	 * (where a zero-length array will be returned) or <code>
	 * <code>from</code> is equal to <code>original.length</code>
	 * (where an array padded with <code>0L</code> will be
	 * returned).  The returned array is always of length
	 * <code>to - from</code>.
	 *
	 * @param original the array from which to copy.
	 * @param from the initial index of the range, inclusive.
	 * @param to the final index of the range, exclusive.
	 * @return a copy of the specified range, with padding to
	 *         obtain the required length.
	 * @throws ArrayIndexOutOfBoundsException if <code>from < 0</code>
	 *                                        or <code>from > original.length</code>
	 * @throws IllegalArgumentException if <code>from > to</code>
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOf(long[],int)
	 */
	public static long[] copyOfRange(long[] original, int from, int to)
	{
		if (from > to)
			throw new IllegalArgumentException("The initial index is after " +
					"the final index.");
		long[] newArray = new long[to - from];
		if (to > original.length)
		{
			System.arraycopy(original, from, newArray, 0,
					original.length - from);
			Arrays.fill(newArray, original.length, newArray.length, 0L);
		}
		else
			System.arraycopy(original, from, newArray, 0, to - from);
		return newArray;
	}

	/**
	 * Returns a copy of the supplied array, truncating or padding as
	 * necessary with <code>(short)0</code> to obtain the specified length.
	 * Indices that are valid for both arrays will return the same value.
	 * Indices that only exist in the returned array (due to the new length
	 * being greater than the original length) will return <code>(short)0</code>.
	 * This is equivalent to calling
	 * <code>copyOfRange(original, 0, newLength)</code>.
	 *
	 * @param original the original array to be copied.
	 * @param newLength the length of the returned array.
	 * @return a copy of the original array, truncated or padded with
	 *         <code>(short)0</code> to obtain the required length.
	 * @throws NegativeArraySizeException if <code>newLength</code> is negative.
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOfRange(short[],int,int)
	 */
	public static short[] copyOf(short[] original, int newLength)
	{
		if (newLength < 0)
			throw new NegativeArraySizeException("The array size is negative.");
		return copyOfRange(original, 0, newLength);
	}

	/**
	 * Copies the specified range of the supplied array to a new
	 * array, padding as necessary with <code>(short)0</code>
	 * if <code>to</code> is greater than the length of the original
	 * array.  <code>from</code> must be in the range zero to
	 * <code>original.length</code> and can not be greater than
	 * <code>to</code>.  The initial element of the
	 * returned array will be equal to <code>original[from]</code>,
	 * except where <code>from</code> is equal to <code>to</code>
	 * (where a zero-length array will be returned) or <code>
	 * <code>from</code> is equal to <code>original.length</code>
	 * (where an array padded with <code>(short)0</code> will be
	 * returned).  The returned array is always of length
	 * <code>to - from</code>.
	 *
	 * @param original the array from which to copy.
	 * @param from the initial index of the range, inclusive.
	 * @param to the final index of the range, exclusive.
	 * @return a copy of the specified range, with padding to
	 *         obtain the required length.
	 * @throws ArrayIndexOutOfBoundsException if <code>from < 0</code>
	 *                                        or <code>from > original.length</code>
	 * @throws IllegalArgumentException if <code>from > to</code>
	 * @throws NullPointerException if <code>original</code> is <code>null</code>.
	 * @since 1.6
	 * @see #copyOf(short[],int)
	 */
	public static short[] copyOfRange(short[] original, int from, int to)
	{
		if (from > to)
			throw new IllegalArgumentException("The initial index is after " +
					"the final index.");
		short[] newArray = new short[to - from];
		if (to > original.length)
		{
			System.arraycopy(original, from, newArray, 0,
					original.length - from);
			Arrays.fill(newArray, original.length, newArray.length, (short)0);
		}
		else
			System.arraycopy(original, from, newArray, 0, to - from);
		return newArray;
	}
	
	public static V[] copyOf (V[] original, int newLength) {
		if (newLength < 0) {
			throw new NegativeArraySizeException("The array size is negative.");
		}
		V[] newArray = new V[newLength];
		System.arraycopy(original, 0, newArray, 0, newLength);
		return newArray;
	}
}
