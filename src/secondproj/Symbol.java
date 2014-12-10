/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproj;

/**
 * Class symbol is the class that describes particles of any Word or Punctuation
 */
public class Symbol {

    protected char ch;

    /*
     * Constructor of this class
     */
    public Symbol(char ch) {
        this.ch = ch;
    }

    /*
     * Check if this is the symbol, or not
     */
    public boolean isSymbol() {
        return true;
    }
    /**
     * @return the ch
     */
    public char getCh() {
        return ch;
    }

    /**
     * @param ch the ch to set
     */
    public void setCh(char ch) {
        this.ch = ch;
    }

     /*
     * Overriden method
     */
    @Override
    public String toString() {
        return ch + "";
    }

}
