package edu.tucn.lab6.ex4;

import java.util.HashMap;
import java.util.Set;
import java.util.Collection;

public class Dictionary {
    HashMap<Word, Definition> dictionary = new HashMap<Word, Definition>();

    public void addWord(Word w, Definition d){
        dictionary.put(w, d);
    }
    public Definition getDefinition(Word w){
        return dictionary.get(w);
    }
    public Set<Word> getAllWords(){
        return dictionary.keySet();
    }
    public Collection<Definition> getAllDefinitions(){
        return dictionary.values();
    }
}
