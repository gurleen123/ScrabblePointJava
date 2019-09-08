/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_200396648;
import java.util.ArrayList;
import assignment2_200396648.Digit;
/**
 *
 * @author gurleenrandhawa
 */
public class Scrabble {
    	ArrayList<Digit> letters=new ArrayList<Digit>();
	ArrayList<String> previousWords=new ArrayList<String>();
	int totalPoints=0;  // points start from 0
	public Scrabble() {   // setting letters in bag and there points
		letters.add(new Digit('E',true,12,1));
		letters.add(new Digit('A',true,9,1));
		letters.add(new Digit('R',false,6,1));
		letters.add(new Digit('O',true,8,1));
		letters.add(new Digit('I',true,8,1));
		letters.add(new Digit('T',false,6,1));
		letters.add(new Digit('S',false,4,1));
		letters.add(new Digit('N',false,6,1));
		letters.add(new Digit('L',false,4,1));
		letters.add(new Digit('D',false,4,2));
		letters.add(new Digit('U',true,4,1));
		letters.add(new Digit('G',false,3,2));
		letters.add(new Digit('P',false,2,3));
		letters.add(new Digit('M',false,2,3));
		letters.add(new Digit('B',false,2,3));
		letters.add(new Digit('H',false,2,4));
		letters.add(new Digit('C',false,2,3));
		letters.add(new Digit('W',false,2,4));
		letters.add(new Digit('Y',true,2,4));
		letters.add(new Digit('F',false,2,4));
		letters.add(new Digit('V',false,2,4));
		letters.add(new Digit('K',false,1,5));
		letters.add(new Digit('X',false,1,8));
		letters.add(new Digit('Z',false,1,10));
		letters.add(new Digit('J',false,1,8));
		letters.add(new Digit('Q',false,1,10));
	}
        
        //Word is too short or long
	public boolean isWordValidLength(String word) {
		if(word.length()<2 || word.length()>8)
			return false;		
		return true;
	}
        
        //Word does  include vowel
	public boolean isWordHavingVowel(String word) {
		for(int i=0;i<word.length();i++)
			if(isCharacterVowel(word.charAt(i)))
				return true;
		return false;
	}
        
        //Word contains letter that is no longer available “in bag”

	public boolean isWordHavingAvailableDigits(String word) {
		word=word.toUpperCase();
		for(int i=0;i<letters.size();i++) {
			int count=0;
			for(int j=0;j<word.length();j++) {
				if(word.charAt(j)==letters.get(i).letter)
					count++;
			}
			if(count>letters.get(i).remaining)
				return false;
		}
		return true;
	}
	public void decrementAvailableDigits(String word) {
		word=word.toUpperCase();
		for(int i=0;i<letters.size();i++) {
			int count=0;
			for(int j=0;j<word.length();j++) {
				if(word.charAt(j)==letters.get(i).letter)
					count++;
			}
			letters.get(i).remaining=letters.get(i).remaining-count;
		}
	}
        
	public boolean isWordInPreviousWords(String word) {
		for(int i=0;i<previousWords.size();i++) {
			if(previousWords.get(i).equalsIgnoreCase(word))
				return true;
		}
		return false;
	}
	public boolean isCharacterVowel(char letter) {
		if(letter=='A'||letter=='a'||letter=='E'||letter=='e'||letter=='I'||letter=='i'||letter=='O'||letter=='o'||letter=='U'||letter=='u')
			return true;
		return false;
	}
        
	public int calculateWordPoints(String word) {
		int points=0;
		word=word.toUpperCase();
		for(int i=0;i<word.length();i++) {			
			for(int j=0;j<letters.size();j++) {
				if(letters.get(j).letter==word.charAt(i))
					points=points+letters.get(j).point;
			}
		}
		return points;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void addPoints(int points) {
		totalPoints=totalPoints+points;
	}
	public void addWord(String word) {
		int points=calculateWordPoints(word);
		addPoints(points);
		previousWords.add(word);
		decrementAvailableDigits(word);
	}
        
        //History to Previous Words
	public String getWordHistory() {
		String wordHistory="";
		if(previousWords.size()>0)
			wordHistory=previousWords.get(0);
		for(int i=1;i<previousWords.size();i++) {
			wordHistory=wordHistory+", "+previousWords.get(i);
		}
		return wordHistory;
	}
	public ArrayList<Digit> getDigits(){
		return letters;
	}
        
 
                
        // game over when only one letter is available and consonants in bag history of previous words
        
	public boolean isGameOver() {
		int countAll=0,vowelCount=0;
		for(int i=0;i<26;i++) {
			countAll=countAll+letters.get(i).getRemaining();
			if(letters.get(i).isVowel())
				vowelCount=vowelCount+letters.get(i).getRemaining();
		}
		if(countAll<=1||vowelCount==0)
			return true;
		return false;
	}
}
