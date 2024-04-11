package edu.ucalgary.oop;

import java.io.Serializable;

// imports required for example serialization

// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectOutputStream;
// import java.io.Serializable;

/* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19L.
 * Member data names should be based on those implied by the getters. Member data are not final.
*/

  /* getSentence()
   * Getter method, returns String
  */

  /* getMonths()
   * Getter method, returns String[]
  */

  /* getDays()
   * Getter method, returns String[]
  */

  /* getMonth()
   * Accepts an integer 0-11 corresponding to an index in the months array,
   * and returns the value at that index. (e.g., 0 = January)
  */

  /* getDay()
   * Accepts an integer 0-30 corresponding to an index in the day array,
   * and returns the value at that index. (e.g., 30 = 31st)
  */

  /* Constructor
   * Accepts a String array of months, a String array of days, and a String 
   * containing a sentence with formatting.
  */
  
public class TranslationText implements Serializable{
  private static final long serialVersionUID = 19L;
  String sentence;
  String[] months;
  String[] days;

  public TranslationText(String[] months, String[] days, String sentence){
    this.sentence = sentence;
    this.months = months;
    this.days = days;
  }

  public String getSentence(){
    return sentence;
  }

  public String[] getMonths(){
    return months;
  }

  public String[] getDays(){
    return days;
  }

  public String getMonth(int month){
    return months[month];
  }

  public String getDay(int day){
    return days[day];
  }

  // example serialization
  // public static void main(String[] args) {
  //       // Example data - adjust as needed
  //       String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  //       String[] days = new String[31];
  //       for (int i = 0; i < days.length; i++) {
  //           days[i] = String.valueOf(i + 1);
  //       }
  //       String sentence = "%s of %s, %d";

  //       TranslationText exampleTranslation = new TranslationText(months, days, sentence);
        
  //       try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("es-BO.ser"))) {
  //           out.writeObject(exampleTranslation);
  //           System.out.println("Serialization successful");
  //       } catch (IOException e) {
  //           e.printStackTrace();
  //       }
  //   }

}