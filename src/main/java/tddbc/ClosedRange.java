package tddbc;

import java.util.Objects;

public class ClosedRange {

    private int lowerEndpoint;
    private int upperEndpoint;

    public ClosedRange(int lowerEndpoint, int upperEndpoint) {
        requireLowerEndPointIsSmallerThanUpperEndPoint(lowerEndpoint, upperEndpoint);

        this.lowerEndpoint = lowerEndpoint;
        this.upperEndpoint = upperEndpoint;

    }

    private void requireLowerEndPointIsSmallerThanUpperEndPoint(int lowerEndpoint, int upperEndpoint)
    {
        if(!(lowerEndpoint <= upperEndpoint))
        {
            throw new IllegalArgumentException();
        }
    }

    public int getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public int getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public String toString() {
        return "[" + lowerEndpoint + "," + upperEndpoint + "]";
    }

    public boolean contains(int num) {
        return lowerEndpoint <= num && num <= upperEndpoint;
    }

    public boolean contains(ClosedRange containsClosedRange) {
        if (lowerEndpoint <= containsClosedRange.lowerEndpoint && upperEndpoint >= containsClosedRange.upperEndpoint) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClosedRange that = (ClosedRange) o;
        return lowerEndpoint == that.lowerEndpoint &&
                upperEndpoint == that.upperEndpoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerEndpoint, upperEndpoint);
    }

}
