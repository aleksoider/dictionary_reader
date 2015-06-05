/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package full_dict;

import dictionary_reader.Comparator;

/**
 *
 * @author 123
 */
public final class fullCompare implements Comparator{
    String clear(String dictWord){
        char[] c=new char[dictWord.length()];
        int st=0;int j=0;
        char[] buf=dictWord.toCharArray();
        while (buf[st] == '-') {
            st++;
        }
        for (int i = st; i < buf.length; i++) {
            if (buf[i] != '\'') {
                c[j] = buf[i];
                j++;
            }
        }
        return new String(c).trim();
    }
    @Override
    public boolean compare(String[] basis, String target) {
        String base=clear(basis[0]);
        
        return target.contains(base);
    }
    
}
