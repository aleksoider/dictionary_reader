/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_reader;

/**
 *
 * @author 123
 */
public interface resultObj {
    public String getHomonym();
    public String getProperty(String key);
    public void toXML();
    public void print();
}
