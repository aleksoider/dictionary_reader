/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skobki_dict.comparators;

import Skobki_dict.bracketsResultObj;
import dictionary_reader.Comparator;

/**
 *
 * @author 123
 */
public final class concatCompare implements Comparator {

    /**
     *
     * @param basis
     * @param target
     * @return
     */
    @Override
    public boolean compare(String[] basis, String target) {
        if (basis.length == 3) {
            if (basis[0].length() >= new Integer(basis[2])) {
                String base = basis[0].substring(0, basis[0].length() - new Integer(basis[2])) + basis[1];
                if ((target.toLowerCase().startsWith(base))) {
                    return true;
                } else {
                    simpleCompare s = new simpleCompare();
                    return s.compare(basis, target);
                }
            } else {
                if ((target.toLowerCase().startsWith(basis[1]))) {
                    return true;
                } else {
                    simpleCompare s = new simpleCompare();
                    return s.compare(basis, target);
                }
            }
        }
        return false;
    }

}
