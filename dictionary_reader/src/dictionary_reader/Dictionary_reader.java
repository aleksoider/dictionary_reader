/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_reader;

import Skobki_dict.bracketsDictionary;
import full_dict.fullDictionary;
import java.util.ArrayList;

/**
 *
 * @author 123
 */
public class Dictionary_reader {

    /**
     * @param args the command line arguments
     */
    static String clear(String dictWord) {
        char[] c = new char[dictWord.length()];
        int st = 0;
        int j = 0;
        char[] buf = dictWord.toCharArray();
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

    private static String[] divide(String line) {
        ArrayList<String> buf = new ArrayList();
        String[] split = line.split(" ");
        for (String split1 : split) {
            if (!split1.isEmpty()) {
                buf.add(split1);
            }
        }
        String[] b = buf.toArray(new String[buf.size()]);
        return b;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       Dictionary dict=new bracketsDictionary();
       dict.setTargetWord("вершины", 1);
       dict.find();
       System.out.println("==========================================");
       resultObj result=dict.getNextResultObj();
       while(result != null){
           result.print();
           result=dict.getNextResultObj();
           //result.getHomonym();       вытащить само слово
           //result.getProperty("ЛН")   вытащить значение свойства "ЛН", если его нет придет "no such key"
       }
//        Dictionary dict2 = new fullDictionary();
//        dict2.setTargetWord("вершины", 1);
//        dict2.find();
    }

}
