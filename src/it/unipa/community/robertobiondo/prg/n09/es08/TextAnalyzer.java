/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.es08;


import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Roberto Biondo
 */
public class TextAnalyzer {

    private Map<String, Integer> textMap;
    private CharSequence text;
    private String mostFrequentWord;
    private int mostFrequentWordCount;

    public TextAnalyzer(CharSequence text) {
        textMap = new TreeMap<>();
        this.setText(text);
    }

    public void setText(CharSequence text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null!");
        }
        this.text = text;
        this.updateMap();
    }

    public String getText() {
        return this.text.toString();
    }

    private void updateMap() {
        this.textMap.clear();
        if (!text.toString().isEmpty()) {
            String[] split = text.toString().split("[^a-zA-Z0-9]");
            String key;
            for (int i = 0; i < split.length; i++) {
                key = split[i].toLowerCase();
                if (key.isEmpty()) {
                    continue;
                }
                if (this.textMap.containsKey(key)) {
                    this.textMap.put(key, this.textMap.get(key) + 1);
                } else {
                    this.textMap.put(key, 1);
                }
            }
        }
        this.updateMostFrequentWord();
    }

    private void updateMostFrequentWord() {
        if (this.textMap.isEmpty()) {
            this.mostFrequentWord = "";
        }
        String word = "";
        int maxFrequency = 0;
        Iterator<String> keysIterator = this.textMap.keySet().iterator();
        while (keysIterator.hasNext()) {
            String s = keysIterator.next();
            if (this.textMap.get(s) > maxFrequency) {
                maxFrequency = this.textMap.get(s);
                word = new String(s);
            }
        }
        this.mostFrequentWord = new String(word);
        this.mostFrequentWordCount = this.getWordFrequency(this.getMostFrequentWord());
    }

    public int getWordCount() {
        return this.textMap.size();
    }

    public int getWordFrequency(CharSequence word) {
        if (this.textMap.containsKey(word.toString().toLowerCase())) {
            return this.textMap.get(word.toString().toLowerCase());
        } else {
            return 0;
        }
    }

    public String getMostFrequentWord() {
        return this.mostFrequentWord;
    }

    public int getMostFrequentWordFrequency() {
        return this.mostFrequentWordCount;
    }

    @Override
    public String toString() {
        if (this.textMap.isEmpty()) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        Iterator<String> keysIterator = this.textMap.keySet().iterator();
        String tmp;
        while (keysIterator.hasNext()) {
            tmp = keysIterator.next();
            s.append("\n").append(tmp).append(" - ").append(this.textMap.get(tmp));
        }
        return s.toString();
    }
}
