package treecalc.rt.gwt;

import java.util.Arrays;

public class BitSet {
	final byte[] bits;
	public BitSet(int size) {
		bits = new byte[size];
	}
	public boolean get(int index) {
		return bits[index]>0;
	}
	public void set(int fromIndex, int toIndex) {
		Arrays.fill(bits, fromIndex, toIndex, (byte) 1);
	}
	public void set(int index) {
		bits[index] = 1;
	}
	public int size() {
		return bits.length;
	}
}
