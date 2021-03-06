package net.ollie.goat.numeric.percentage;

import net.ollie.goat.numeric.Numeric;

/**
 *
 * @author Ollie
 */
public abstract class Percentage extends Number implements Numeric.Summable<Percentage> {

    private static final long serialVersionUID = 1L;

    @Override
    public Percentage plus(final Percentage that) {
        return new BigDecimalPercentage(this.decimalValue().add(that.decimalValue()));
    }

    @Override
    public String toString() {
        return this.decimalValue().movePointRight(2) + "%";
    }

    public static Percentage oneBasisPoint() {
        return BigDecimalPercentage.basisPoints(1);
    }

    public static Percentage zero() {
        return BigDecimalPercentage.ZERO_PERCENT;
    }

    public static Percentage one() {
        return BigDecimalPercentage.ONE_PERCENT;
    }

    public static Percentage oneHundred() {
        return BigDecimalPercentage.ONE_HUNDRED_PERCENT;
    }

    public static Percentage of(final long percentage) {
        return new IntegerPercentage(percentage);
    }

}
