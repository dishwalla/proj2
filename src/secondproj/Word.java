/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproj;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Word is the class which includes Symbols and that makes Sentences
 */
public class Word implements PartOfSentence {

    private List<Symbol> listOfSym = new LinkedList<>();

    /*
     * Constructor of this class
     */
    public Word(String s) {
        for (char ch : s.toCharArray()) {
            Symbol sym = new Symbol(ch);
            listOfSym.add(sym);
        }
    }

    /*
     * Overriden method
     */
    @Override
    public boolean isCode() {
        boolean result = true;
        for (Symbol sym : getListOfSym()) {
            if (sym.getCh() == '\r' || sym.getCh() == '\n') {
                continue;
            }
            result = result && isLatinLetter(sym.getCh());
        }
        return result;
    }
    /*
     * Method check if letter is latin, to know where the code is
     */

    public boolean isLatinLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /**
     * @return the listOfSym
     */
    public List<Symbol> getListOfSym() {
        return listOfSym;
    }

    /*
     * Overriden method
     */
    @Override
    public String toString() {
        String res = "";
        for (Symbol s : listOfSym) {
            res += s.toString();
        }
        return res;
    }

}
