package uk.co.gfk;

import java.util.List;

public class Wonder {

    private List<Integer> primeValues;

    public Wonder(List<Integer> primeValues) {
        this.primeValues = primeValues;
    }

    public List<Integer> getPrimeValues() {
        return primeValues;
    }
}
