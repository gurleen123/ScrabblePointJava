/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_200396648;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gurleenrandhawa
 */
public class Assignment2_200396648 {
public static void main(String[] args) {
	Scrabble scrabble=new Scrabble();
	System.out.println(scrabble.isWordHavingAvailableDigits("have available digits"));
}
}
