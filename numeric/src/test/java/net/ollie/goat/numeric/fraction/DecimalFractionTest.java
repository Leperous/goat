package net.ollie.goat.numeric.fraction;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class DecimalFractionTest {

    @Test
    public void testToDouble() {
        assertThat(BigDecimalFraction.of(1, 2).doubleValue(), is(0.5d));
        assertThat(BigDecimalFraction.of(1, 4).doubleValue(), is(0.25d));
    }

    @Test
    public void testEquality() {
        assertThat(BigDecimalFraction.of(2, 4), is(BigDecimalFraction.of(1, 2)));
        assertThat(BigDecimalFraction.of(2, 6), is(BigDecimalFraction.of(1, 3)));
    }

    @Test
    public void testMultiplication() {
        assertThat(BigDecimalFraction.of(2, 3).times(BigDecimalFraction.of(5, 7)), is(BigDecimalFraction.of(10, 21)));
    }

    @Test
    public void testCompare() {
        final BigDecimalFraction d1 = BigDecimalFraction.of(1, 2);
        final BigDecimalFraction d2 = BigDecimalFraction.of(1, 3);
        assertThat(d1.compareTo(d1), is(0));
        assertTrue(d1.compareTo(d2) > 0);
        assertTrue(d2.compareTo(d1) < 0);
    }

    @Test
    public void testAdd() {
        assertThat(BigDecimalFraction.of(1, 2).plus(BigDecimalFraction.of(2, 3)), is(BigDecimalFraction.of(7, 6)));
    }

    @Test
    public void testIsReduced() {
        assertTrue("1/2", BigDecimalFraction.of(1, 2).isReduced());
        assertFalse("2/4", BigDecimalFraction.of(2, 4).isReduced());
        assertTrue("1/3", BigDecimalFraction.of(1, 3).isReduced());
        assertFalse("2/6", BigDecimalFraction.of(2, 6).isReduced());
        assertTrue("-1/3", BigDecimalFraction.of(-1, 3).isReduced());
        assertTrue("-1/3", BigDecimalFraction.of(1, -3).isReduced());
        assertFalse("-2/3", BigDecimalFraction.of(-2, 6).isReduced());
        assertFalse("-2/3", BigDecimalFraction.of(2, -6).isReduced());
        assertFalse("4/8", BigDecimalFraction.of(4, 8).isReduced());
        assertTrue("3/7", BigDecimalFraction.of(3, 7).isReduced());
    }

}
