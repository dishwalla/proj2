/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproj;

import java.util.Comparator;
import java.util.Map;

/**
 * This is class, that implements comparator, to give us opportunity to compare Words for our main project purpose
 */
class ValueComparator implements Comparator<String> {

    public Map<String, Double> base;

    /**
     * Constructor for this class
     */
    public ValueComparator(Map<String, Double> base) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.base = base;
    }

    /**
     * Main method for any class, that implements Comparator
     */
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
