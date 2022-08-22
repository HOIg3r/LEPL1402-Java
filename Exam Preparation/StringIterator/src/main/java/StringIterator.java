import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Question:
 *
 * You are asked to implement an IterableString allowing
 * to iterate on the successive chars of a given string
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 *
 */
public class StringIterator {

    /**
     * Factory method
     * @param s the string on which to iterate
     * @return a new instance of your implementation of an IterableString allowing to iterate on s
     */
    public static IterableString makeIterableString(String s) {
        return new MyIterator(s);
    }

    /**
     * An IterableString permit to iterate on each character of a
     * string one by one from left to right
     */
    public interface IterableString extends Iterable<Character> {}

    // TODO implement the interface IterableString as an (inner) class

    public static  class MyIterator implements IterableString{
        String str;
        MyIterator(String s){
            str = s;
        }

        @Override
        public Iterator<Character> iterator() {
            return new Iterator<Character>() {

                String s = str;
                int count = 0;

                @Override
                public boolean hasNext() {
                    return count < s.length();
                }

                @Override
                public Character next() {
                    if(!hasNext()){
                        throw new NoSuchElementException();
                    }
                    count++;
                    return s.charAt(count-1);

                }
            };
        }
    }
}
