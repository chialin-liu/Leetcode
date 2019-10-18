// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer val = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        if(iter.hasNext()){
            val = iter.next();
        }
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer tmp = val;
        val = iter.hasNext()? iter.next(): null;
        return tmp;
	}

	@Override
	public boolean hasNext() {
	    return val != null;
	}
}
