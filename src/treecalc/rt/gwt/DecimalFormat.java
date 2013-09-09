package treecalc.rt.gwt;

import treecalc.rt.V;

public final class DecimalFormat {
    private boolean leadingzeros;
    private boolean groupingUsed = false;
    private int groupingSize = 3;
    private char groupingSeparator = ',';
    private char decimalSeparator = '.';
    private String positivePrefix = null;
    private String positiveSuffix = null;
    private String negativePrefix = "-";
    private String negativeSuffix = null;
    private int minInt = 1;
    private int minFrac = 0;
    private int maxFrac = 0;
    
	public DecimalFormat(boolean leadingzeros, DecimalFormatSymbols symbols) {
		this.leadingzeros = leadingzeros;
		if (symbols!=null) {
			groupingSeparator = symbols.getGroupingSeparator();
			decimalSeparator  = symbols.getDecimalSeparator();
		}
	}

	public boolean isLeadingzeros() {
		return leadingzeros;
	}

	public void setLeadingzeros(boolean leadingzeros) {
		this.leadingzeros = leadingzeros;
	}

	public boolean isGroupingUsed() {
		return groupingUsed;
	}

	public void setGroupingUsed(boolean groupingUsed) {
		this.groupingUsed = groupingUsed;
	}

	public int getGroupingSize() {
		return groupingSize;
	}

	public void setGroupingSize(int groupingSize) {
		this.groupingSize = groupingSize;
	}

	public char getGroupingSeparator() {
		return groupingSeparator;
	}

	public void setGroupingSeparator(char groupingSeparator) {
		this.groupingSeparator = groupingSeparator;
	}

	public char getDecimalSeparator() {
		return decimalSeparator;
	}

	public void setDecimalSeparator(char decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public String getPositivePrefix() {
		return positivePrefix;
	}

	public void setPositivePrefix(String positivePrefix) {
		this.positivePrefix = positivePrefix;
	}

	public String getPositiveSuffix() {
		return positiveSuffix;
	}

	public void setPositiveSuffix(String positiveSuffix) {
		this.positiveSuffix = positiveSuffix;
	}

	public String getNegativePrefix() {
		return negativePrefix;
	}

	public void setNegativePrefix(String negativePrefix) {
		this.negativePrefix = negativePrefix;
	}

	public String getNegativeSuffix() {
		return negativeSuffix;
	}

	public void setNegativeSuffix(String negativeSuffix) {
		this.negativeSuffix = negativeSuffix;
	}

	public int getMinInt() {
		return minInt;
	}

	public void setMinInt(int minInt) {
		this.minInt = minInt;
	}

	public int getMinFrac() {
		return minFrac;
	}

	public void setMinFrac(int minFrac) {
		this.minFrac = minFrac;
	}

	public int getMaxFrac() {
		return maxFrac;
	}

	public void setMaxFrac(int maxFrac) {
		this.maxFrac = maxFrac;
	}

	public static String format(double value) {
		//precondition: Math.abs(value)>1e-16 && Math.abs(value)<1e+15
		if (Math.ceil(value)==value) {
			return Long.toString((long)Math.ceil(value));
		}
		// max 12 digits after comma
		boolean negative;
		if (value<0) {
			negative = true;
		} else {
			negative = false;
		}
		String numberStr = Double.toString(value);
	    int point = numberStr.indexOf('.'); // position of point character
	    String intStr;
	    String fracStr;
	    if (point >= 0) {
	        intStr  = numberStr.substring(0,point);
	        fracStr = numberStr.substring(point+1);
	    } else {
	    	return numberStr;
	    }
	    int maxFrac = 12;
	    if (fracStr.length() > maxFrac) { // round
	        if (maxFrac==0) {
	            intStr = Long.toString((long)Math.floor(value));
	            fracStr = "";
	        } else {
	            numberStr = Double.toString(V.getInstance(value).bf_round(V.getInstance(maxFrac)).doubleValue());
		        point = numberStr.indexOf('.'); // position of point character
		        if (point >= 0) {
		            intStr  = numberStr.substring(0,point);
		            fracStr = numberStr.substring(point+1);
		            int fracLen = fracStr.length();
		            int indNotZero=fracLen;
		            while(--indNotZero>=0) {
		            	if (fracStr.charAt(indNotZero)!='0') {
		            		break;
		            	}
		            }
		            if (indNotZero<0) {
		            	fracStr = "";
		            } else if (indNotZero!=fracLen-1) {
		            	fracStr = fracStr.substring(0, indNotZero+1);
		            }
		        } else {
		            intStr = numberStr;
		            fracStr = "";
		        }
	        }                        
	    }
	    if (fracStr.length()==0) {
	    	return negative ? ('-' + intStr) : intStr; 
	    } else {
	    	return negative ? ('-' + intStr + "." + fracStr) : (intStr + "." + fracStr);
	    }
	}
	
	public String format(V n) {
	    int i;
	    String numberStr = n.toString();
	    if (numberStr==null || numberStr.length()== 0) {
	        return n.stringValue();                                   
	    }
	    boolean negative = false;
	    // remove sign
	    if (numberStr.charAt(0) == '-') {
	        negative = true;
	        numberStr = numberStr.substring(1);
	    }
	    int point = numberStr.indexOf('.'); // position of point character
	    String intStr;
	    String fracStr;
	    if (point >= 0) {
	        intStr  = numberStr.substring(0,point);
	        fracStr = numberStr.substring(point+1);
	    } else {
	        intStr = numberStr;
	        fracStr = "";
	    }
	    int minInt  = this.minInt;
	    int minFrac = this.minFrac;
	    int maxFrac = this.maxFrac;
	    if (fracStr.length() > maxFrac) { // round
	        if (maxFrac==0) {
	            numberStr = n.bf_round().stringValue();
	        } else {
	            numberStr = n.bf_round(V.getInstance(maxFrac)).stringValue();
	        }                        
	        if (numberStr.charAt(0) == '-') {
	            numberStr = numberStr.substring(1);
	            negative = true;
	        } else {
	            negative = false;
	        }
	        point = numberStr.indexOf('.'); // position of point character
	        if (point >= 0) {
	            intStr  = numberStr.substring(0,point);
	            fracStr = numberStr.substring(point+1);
	        } else {
	            intStr = numberStr;
	            fracStr = "";
	        }
	    }
	    for (i=fracStr.length(); i<minFrac; i++) { // if minFrac=4 then 1.12 --> 1.1200
	        fracStr = fracStr + "0";
	    }
	    for (i=intStr.length(); i<minInt; i++) {
	        intStr = (this.leadingzeros ? '0':' ') + intStr;
	    }
	    if (this.groupingUsed) {
	        int j = 0;
	        for(i=intStr.length(); i>0; i--) { // add commas
	            if (j != 0 && (j % this.groupingSize)==0) {
	                intStr = intStr.substring(0,i) + this.groupingSeparator + intStr.substring(i);
	                j = 0;
	            }
	            j++;
	        }
	    }
	    String formattedValue;
	    if (fracStr.length() > 0) {
	        formattedValue = intStr + this.decimalSeparator + fracStr;
	    } else {
	        formattedValue = intStr;
	    }
	    if (negative) {       
	        if (this.negativePrefix==null && this.positivePrefix==null) {
	            formattedValue = '-' + formattedValue;
	        } else {
	            if (this.negativePrefix!=null) {
	                formattedValue = this.negativePrefix + formattedValue;
	            } 
	            if (this.negativeSuffix!=null) {
	                formattedValue = formattedValue + this.negativeSuffix;
	            }                   
	        }
	    } else {
	        if (this.positivePrefix!=null) {
	            formattedValue = this.positivePrefix + formattedValue;
	        } 
	        if (this.positivePrefix!=null) {
	            formattedValue = formattedValue + this.positiveSuffix;
	        }
	    }
	    return formattedValue;
		
	}

	public static void test(double value, String format) {
		V n = V.getInstance(value);
		V f = V.getInstance(format);
		V ret = n.bf_format(f);
		System.out.println(n + ", format " + f + " -> " + ret);
	}
	
	public static void main(String...args) {
		test(2, "0.3");
		test(2.12345, "0.3");
		test(2, "0,3");
		test(2.12345, "0,3");
		test(-2, "0,3");
		test(-2.12345, "0,3");
		test(12345678, ",.2");
		test(12345678, ".,2");
	}
}
