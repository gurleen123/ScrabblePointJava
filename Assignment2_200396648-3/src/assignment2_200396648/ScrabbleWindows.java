/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this templatelate file, choose Tools | Templates
 * and open the templatelate in the editor.
 */
package assignment2_200396648;

/**
 *
 * @author gurleenrandhawa
 */

// importing the classes
import java.util.ArrayList;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import javafx.application.Application; 
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage; 
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.Group; 
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 

/**
 *
 * @author prit
 */
        
public class ScrabbleWindows extends Application { 
    
    
	Text text;
	TextField input;    //TextField to type word (1 mark)
	Button submit;      //Submit Word button (1 mark)
	ArrayList<Text> textList=new ArrayList<Text>();  
	Scrabble scrabble;    //26 Letters displayed with their accompanying point values 26 marks
	Label previous;  //Previous Word element to display previous words (2 marks)
	Label points;
        

   @Override 
   public void start(Stage stage) {       
      
      text = new Text();        
      text.setY(75); 
      text.setX(55); 
      text.setFont(new Font(22)); 
      text.setText("ENTER YOUR WORDS BELOW"); 
      
      
      input = new TextField(); 
      input.setLayoutY(100);
      input.setLayoutX(50);
      input.setFont(new Font(22)); 
      input.setStyle("-fx-background-color: #FFFDD0; -fx-padding: 5px; ");   //Design look & creativity (5 marks)

      
      points = new Label();        
      points.setLayoutX(850); 
      points.setLayoutY(100); 
      points.setFont(new Font(20)); 
      points.setText("Points  : 0"); // points that word is using the scrabble point system.
      points.setStyle("-fx-background-color: #FFFDD0; -fx-padding: 5px; ");
      
      submit = new Button("Submit");   //Submit button initializes processing (1 marks)
      submit.setFont(new Font(22)); 
      submit.setLayoutX(400);
      submit.setLayoutY(100);
      submit.setStyle("-fx-background-color: #add8e6; -fx-padding: 5px; ");
      
      
      
      scrabble=new Scrabble();
      ArrayList<Digit> letters=scrabble.getDigits();
      
      Text text2 = new Text();          //Previous Words node displays valid previous words in format “Word1, Word2” (5 marks)
      text2.setX(50); 
      text2.setY(220);
      text2.setFont(new Font(22)); 
      text2.setText(" Point values of digits and remaining chances");
      text2.setStyle(" -fx-margin: 30px; ");
      
      Group root = new Group(); 
      ObservableList list = root.getChildren(); 
      list.add(text);       
      list.add(input);      
      list.add(submit); 
     
      list.add(text2); 
      list.add(points);   
      
   
      
     for(int i=0;i<6;i++) {
    	  Text template=new Text();
    	  template.setFont(new Font(30)); 
          template.setStyle("-fx-background-color: #99AAFF;");
          template.setX(120+i*110); 
          template.setY(280);
          
          template.setText(letters.get(i).letter+"("+letters.get(i).getPoint()+","+letters.get(i).getRemaining()+")");
    	  textList.add(template);
    	  list.add(template);
          
      }
      
            for(int i=6;i<13;i++) {
    	  Text template=new Text();
    	  template.setFont(new Font(30)); 
          template.setX(120+(i-6)*110); 
          template.setY(340);
          
          template.setText(letters.get(i).letter+"("+letters.get(i).getPoint()+","+letters.get(i).getRemaining()+")");
    	  textList.add(template);
    	  list.add(template);
          template.setStyle("-fx-background-color: #99AAFF;");

      }
            
          for(int i=13;i<20;i++) {
    	  Text template=new Text();
    	  template.setFont(new Font(30)); 
          template.setX(120+(i-13)*110); 
          template.setY(400);
          
          template.setText(letters.get(i).letter+"("+letters.get(i).getPoint()+","+letters.get(i).getRemaining()+")");
    	  textList.add(template);
    	  list.add(template);
          template.setStyle("-fx-background-color: #99AAFF;");

      }
      for(int i=20;i<26;i++) {
    	  Text template=new Text();
    	  template.setFont(new Font(30)); 
          template.setX(120+(i-20)*110); 
          template.setY(460);
          template.setText(letters.get(i).letter+"("+letters.get(i).getPoint()+","+letters.get(i).getRemaining()+")");
    	  textList.add(template);
    	  list.add(template);
           template.setStyle("-fx-background-color: #99AAFF;"); 
      }
      

      Text text3 = new Text();          // History to Previous Words is kept as any data structure desired( 3 marks)
      text3.setFont(new Font(20)); 
      text3.setX(50); 
      text3.setY(650);          
      text3.setText(" Words History"); 
      

      list.add(text3);
      
      previous = new Label();        
      previous.setFont(new Font(20)); 
      previous.setLayoutX(55); 
      previous.setLayoutY(700);          
      previous.setWrapText(true);
      previous.setMaxWidth(300);
      previous.setText(scrabble.getWordHistory());    
      previous.setStyle("-fx-background-color: #FFFDD0;");
      previous.setMinSize(1000,40);
      
      list.add(previous);
      
      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
              String word=input.getText();
              Alert alert = new Alert(AlertType.ERROR);
              alert.setHeaderText("Error");
              alert.initStyle(StageStyle.TRANSPARENT);
              if(scrabble.isWordInPreviousWords(word))
              {
            	  alert.setContentText("Word is already uesd and check word history");  
                  alert.show();
                  return;
              }
              
              
              if(!scrabble.isWordValidLength(word))
              {
            	  alert.setContentText("Word must contain 2 to 8 characters");   
                  alert.show();
                  
                  return;
              }
              
              
              if(!scrabble.isWordHavingVowel(word)) 
              {
            	  alert.setContentText("Word must have atleast one vowel");   
                  alert.show();
                  return;
              }
             
              if(!scrabble.isWordHavingAvailableDigits(word))
              {
            	  alert.setContentText("Word contains letter that is not available in bag ");   
                  alert.show();
                  return;
              }
              scrabble.addWord(word);
              points.setText("Total points: "+scrabble.getTotalPoints()); 
              previous.setText(scrabble.getWordHistory()); 
              input.setText("");
              for(int i=0;i<26;i++) {      
            	  if(letters.get(i).getRemaining()>0)
            		  textList.get(i).setText(letters.get(i).letter+"("+letters.get(i).getPoint()+","+letters.get(i).getRemaining()+")");
            	  else
            		  textList.get(i).setText("");
              }
              
              new Alert(AlertType.INFORMATION);
              if(scrabble.isGameOver())
              {
            	  alert.setContentText("Game over!");   //Message of “Game Over” displayed (1 mark)
                  alert.show();
                  return;
              }
              
          }
      }; 
   
      
      
      // when button is pressed 
      submit.setOnAction(event); 

      Scene scene = new Scene(root, 1200, 800 , Color.LIGHTGREEN); 
      stage.setTitle("Scrabble"); 
      stage.setScene(scene); 

      stage.show(); 
   }   
   public static void main(String args[]){ 
      launch(args); 
   } 
} 




