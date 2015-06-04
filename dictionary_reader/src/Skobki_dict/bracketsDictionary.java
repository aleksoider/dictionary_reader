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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
    ArrayList<resultObj> resultList;

    public bracketsDictionary() {
        file = new File("");

    }

    @Override
    public void setTargetWord(String word, int id
    ) {
        targetWord = word;
        targetWordId = id;
    }

    boolean openInputStream() {
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), "UTF-8"
                    )
            );
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            log.log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public void find() {
        if (openInputStream()) {
            while (true) {
                String line = null;
                try {
                    if ((line = br.readLine()) != null) {
                        compare(line);
                    } else {
                        break;
                    }
                } catch (IOException ex) {
                    log.log(Level.SEVERE, null, ex);
                }

            }
        }

    }

    @Override
    public resultObj getResultObj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toXML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void compare(String line) {
        String[] splitLine = line.split(";");
        String[] basis = splitLine[0].split(",");
        if (basis.length == 3) {
            String base = basis[0].substring(0, basis[0].length() - new Integer(basis[2])) + basis[1];
            if ((this.targetWord.toLowerCase().contains(base))) {
                bracketsResultObj buf = new bracketsResultObj(line);
                this.resultList.add(buf);
            } else {
                if ((this.targetWord.toLowerCase().contains(basis[0]))) {
                    bracketsResultObj buf = new bracketsResultObj(line);
                    this.resultList.add(buf);
                }
            }
        } else {
            if ((this.targetWord.toLowerCase().contains(basis[0]))) {
                bracketsResultObj buf = new bracketsResultObj(line);
                this.resultList.add(buf);
            }
        }
    }

}
