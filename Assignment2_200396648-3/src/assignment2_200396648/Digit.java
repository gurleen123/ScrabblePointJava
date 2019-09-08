/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_200396648;

/**
 *
 * @author gurleenrandhawa
 */
public class Digit {
    char letter;
	boolean vowel;
	int remaining;
	int point;
	public Digit(char letter, boolean vowel, int remaining,int point) {
		this.letter=letter;
		this.vowel=vowel;
		this.remaining=remaining;
		this.point=point;
	}
	public char getLetter()
	{
		return letter;
	}
	public void setLetter(char letter) {
		this.letter=letter;
	}
	public boolean isVowel() {
		return vowel;
	}
	public void setVowel(boolean vowel) {
		this.vowel=vowel;
	}
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int remaining) {
		this.remaining=remaining;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point=point;
	}	
}
