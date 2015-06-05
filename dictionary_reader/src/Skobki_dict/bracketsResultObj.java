/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skobki_dict;

import dictionary_reader.resultObj;
import java.util.HashMap;

/**
 *
 * @author 123
 */
public class bracketsResultObj implements resultObj{
    String homonym;
    HashMap<String,String> properties;

    /**
     *
     * @param line
     */
    public bracketsResultObj(String[] line) {
        properties=new HashMap();
        homonym=line[0];
        parseProps(line);
    }
    private void parseProps(String[] props){
        for(int i=1;i<props.length;i++){
            String[] split = props[i].split("=");
            properties.put(split[0], split[1]);
        }
    }
    @Override
    public String getHomonym() {
        return this.homonym;
    }

    @Override
    public String getProperty(String key) {
        return this.properties.getOrDefault(key, "no such key");
    }

    @Override
    public void toXML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        System.out.println(homonym);
        for(HashMap.Entry<String, String> e : this.properties.entrySet()) {
            System.out.print(e.getKey()+" : ");
            System.out.println(e.getValue());
        }
        System.out.println("");
    }
    
}
