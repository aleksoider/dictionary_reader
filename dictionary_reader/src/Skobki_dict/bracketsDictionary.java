/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skobki_dict;

import dictionary_reader.Dictionary;
import dictionary_reader.resultObj;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 123
 */
public class bracketsDictionary implements Dictionary {

    String targetWord;
    int targetWordId;
    BufferedReader br = null;
    File file = null;
    static final Logger log = Logger.getLogger(bracketsDictionary.class.getName());

    public bracketsDictionary() {
        try {
            file = new File("");
            try {
                br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file), "UTF-8"
                        )
                );
            } catch (UnsupportedEncodingException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            log.log(Level.SEVERE, "{0}" + " " + "File Not Found", "");
        }
    }

    @Override
    public void setTargetWord(String word, int id
    ) {
        targetWord = word;
        targetWordId = id;
    }

    @Override
    public void find() {
        
    }

    @Override
    public resultObj getResultObj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toXML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
