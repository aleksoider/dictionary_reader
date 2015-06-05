/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skobki_dict.comparators;

import dictionary_reader.Comparator;

/**
 *
 * @author 123
 */
public final class simpleCompare implements Comparator {

    /**
     *
     * @param basis
     * @param target
     * @return
     */
    @Override
    public boolean compare(String[] basis, String target) {
        return (target.toLowerCase().startsWith(basis[0]));
    }

}
