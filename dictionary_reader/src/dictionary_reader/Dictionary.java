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
public interface Dictionary {
    public void setTargetWord(String word, int id);
    public void find();
    public resultObj getNextResultObj();
    public void toXML();   
}
