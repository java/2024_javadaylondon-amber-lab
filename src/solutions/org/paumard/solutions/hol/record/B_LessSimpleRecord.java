package org.paumard.solutions.devnexus.record;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class B_LessSimpleRecord {

    /**
     * The content of this class has just been added to make the code
     * compile. All this content should be removed when you make this class a record.
     */
    record Range(int begin, int end) implements Iterable<Integer> {

        public Range {
            if (begin > end) {
                throw new IllegalArgumentException("End must be greater than begin");
            }
        }

        public Range(int end) {
            this(0, end);
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                private int index = begin;

                @Override
                public boolean hasNext() {
                    return index < end;
                }

                @Override
                public Integer next() {
                    return index++;
                }
            };
        }
    }

    /**
     * Make the Range class a Record. Remove the constructors, the begin() and the end()
     * methods from it.
     * </p>
     * Uncomment the call of the constructor and make the test pass.
     */
    @Test
    public void b_record01() {

        Range range = new Range(10, 20);

        assertThat(range.begin()).isEqualTo(10);
        assertThat(range.end()).isEqualTo(20);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Replace the existing Range class with a record.  
    // </editor-fold>


    /**
     * Add a constructor that only takes end as a parameter,
     * and that gives 0 to the value of begin.
     * </p>
     * Uncomment the call of the constructor and make the test pass.
     */
    @Test
    public void b_record02() {

        Range range = new Range(10);

        assertThat(range.begin()).isEqualTo(0);
        assertThat(range.end()).isEqualTo(10);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Remember that the constructors of a record should
    // always call the canonical constructor.  
    // </editor-fold>


    /**
     * A valid range should have a begin value lesser than
     * its end value. Write a validation rule to enforce this
     * property.
     */
    @Test
    public void b_record03() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Range(20, 10));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You can add this validation rule either in the canonical 
    // constructor, or in the compact constructor.
    // </editor-fold>


    /**
     * Let us make this Range iterable! Add the implements
     * <code>Iterable&lt;Integer></code> to the record declaration.
     * For your code to compile, you just need to add a single method:
     * <code>iterator()</code>. This method should return an
     * <code>Iterator&lt;Integer></code>.
     * </p>
     * You can then uncomment the foreach in the following code
     * to make the test pass.
     */
    @Test
    public void b_record04() {

        Range range = new Range(0, 5);
        List<Integer> indexes = new ArrayList<>();
        for (int index : range) {
            indexes.add(index);
        }

        assertThat(indexes).containsExactly(0, 1, 2, 3, 4);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You can implement this iterator with an anonymous class.
    // </editor-fold>
}
