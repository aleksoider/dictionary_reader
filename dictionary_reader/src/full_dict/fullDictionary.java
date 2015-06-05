/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package full_dict;

import dictionary_reader.Comparator;
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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micen
 */
public class fullDictionary implements Dictionary {
    String targetWord;
    int targetWordId;
    int id=0;
    BufferedReader br = null;
    File file = null;
    static final Logger log = Logger.getLogger(fullDictionary.class.getName());
    ArrayList<resultObj> resultList;
    Comparator comparator;
    public fullDictionary() {
        comparator=new fullCompare();
        file = new File("paradigms.txt");
    }

    @Override
    public void setTargetWord(String word, int id) {
        resultList=new ArrayList();
        targetWord = word;
        targetWordId = id;
    }

    boolean openInputStream() {
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file),"windows-1251"
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
                        id++;
                        compare(line);
                    } else {
                        break;
                    }
                } catch (IOException ex) {
                    log.log(Level.SEVERE, null, ex);
                }

            }
        }
        print();
    }
    private String[] divide(String line) {
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
    public void print() {
        System.out.println("id: " + this.targetWordId + "; word: " + this.targetWord);
        for (int i = 0; i < this.resultList.size(); i++) {
            resultList.get(i).print();
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
        String[] split=divide(line);
        if(comparator.compare(split, targetWord)){           
            this.resultList.add(new fullDictResultObj(split));
        }
    }
}
