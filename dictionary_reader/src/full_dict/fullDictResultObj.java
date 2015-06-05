/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package full_dict;

import dictionary_reader.resultObj;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 123
 */
public class fullDictResultObj implements resultObj{
    String homonym;
    ArrayList<String> props;
    fullDictResultObj(String[] splitLine) {
        homonym=splitLine[0];
        props=new ArrayList();
        props.add(splitLine[1]);
        if(splitLine.length>=3){
            String[] split = splitLine[2].split(",");
            props.addAll(Arrays.asList(split));
        }
    }

    @Override
    public String getHomonym() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getProperty(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toXML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        System.out.println("------");
        System.out.println(homonym);
        for (String prop : props) {
            System.out.println(prop);
        }
        System.out.println("------");
    }
    
}
