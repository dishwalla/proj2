/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproj;

/**
 * The only class in project, that both implements and extends other classes: Symbol and interface PartOfSentence
 */
public class Punctuation extends Symbol implements PartOfSentence {

    public static String codePuncts = "(){}<>^;+=-/\\*%.:";

    /*
     * Constructor of this class
     */
    public Punctuation(char ch) {
        super(ch);
    }

    /*
     * Overriden method
     */
    @Override
    public boolean isCode() {
        return codePuncts.contains(ch + "");

    }

    /*
     * Overriden method
     */
    @Override
    public String toString() {
        return super.toString();
    }


}
