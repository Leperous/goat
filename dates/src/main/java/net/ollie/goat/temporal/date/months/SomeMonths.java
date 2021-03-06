package net.ollie.goat.temporal.date.months;

import java.time.Month;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.ollie.goat.collection.Sets;

/**
 *
 * @author ollie
 */
@XmlRootElement
public class SomeMonths implements Months {

    @XmlElement(name = "month")
    private Set<Month> months;

    @Deprecated
    SomeMonths() {
    }

    public SomeMonths(final Month... months) {
        this.months = Sets.asSet(months);
    }

    public SomeMonths(final Collection<Month> months) {
        this.months = new HashSet<>(months);
    }

    @Override
    public boolean contains(final Month month) {
        return months.contains(month);
    }

    @Override
    public Iterator<Month> iterator() {
        return months.iterator();
    }

}
