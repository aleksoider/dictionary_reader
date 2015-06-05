/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_reader;

import Skobki_dict.bracketsDictionary;

/**
 *
 * @author 123
 */
public class Dictionary_reader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dictionary dict=new bracketsDictionary();
        dict.setTargetWord("вершины", 1);
        dict.find();
    }
    
}
