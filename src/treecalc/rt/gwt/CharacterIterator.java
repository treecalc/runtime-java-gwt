package treecalc.rt.gwt;

public interface CharacterIterator extends Cloneable {

	char DONE = '\uFFFF';

	char current();

	char next();

	char previous();

	char first();

	char last();

	int getIndex();

	char setIndex(int index) throws IllegalArgumentException;

	int getBeginIndex();

	int getEndIndex();

	Object clone();
}
