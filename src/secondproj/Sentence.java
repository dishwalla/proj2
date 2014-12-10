/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproj;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * This class is about to divide whole text to logic units - sentences from parts of sentences: Words or Punctuation
 */
public class Sentence {
    
    private List<PartOfSentence> listOfParticles = new LinkedList<>();
    
    /*
     * Method, that serves to fill private List listOfParticles
     */
    public void addPartOfSentence(PartOfSentence pos){
        getListOfParticles().add(pos);
    }

    /**
     * @return the listOfParticles
     */
    public List<PartOfSentence> getListOfParticles() {
        return listOfParticles;
    }

     /*
     * Overriden method
     */
    @Override
    public String toString() {
        String res = "";
        for(PartOfSentence ps : listOfParticles){
            res += ps.toString();
        }
        //res = listOfParticles.stream().map((p) -> p.toString()).reduce(res, String::concat);
        return res;
    }
    
    
}
