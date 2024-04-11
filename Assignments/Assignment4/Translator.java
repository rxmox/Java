package edu.ucalgary.oop;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

  /* getTranslation()
   * getter method returning a stored TranslationText object.
  */

  /* translate()
   * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
   * the 31st), and a year. Note that years may be any previous year in the common era 
   * (CE) from 0 to the previous year, or they may be before the common era (BCE),
   * represented by negative numbers. Thus 2021, 800, and -1600 are all valid years.
   * Method throws an IllegalArgumentException if monthNum or dayNum is not
   * valid. Returns the formatted sentence as a String. Notice that the String
   * containing formatting uses numbered arguments - this is because some languages
   * will put the words in the sentence in a different order, but the translate()
   * method must be able to work without knowledge of the language structure.
   * Note: You do not have to check if a day is valid for a particular month/year;
   * February 31 or February 29, 2021 can both be accepted, but out of range values
   * e.g., month 15 day 0, are not valid and should be handled with an 
   * IllegalArgumentException. 
  */

  /* Constructor
   * Accepts a String of a two-letter language code (lowercase), dash, and two-letter 
   * region (caps) code, e.g., te-IN and throws an IllegalArgumentException if the language 
   * and region code are not in the correct format. Language codes are ISO 639-1 and
   * region codes are ISO 3166, but this method only checks the format of the String, 
   * not if the region and language codes are valid according to the ISO specifications.
   * The input parameter must exactly match the expected format.
   * It calls importTranslation().
  */

  /* importTranslation()
   * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
   * No arguments. Returns void.
  */

  /* importFromText()
   * Reads in from a the two-letter language code, dash, two-letter region code text 
   * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
   * the data. It can throw I/O exceptions. Throw a custom ArgFileNotFoundException
   * when the file isn't found. 
   * We expect the .txt file to be in a valid format. The file is expected to be in the same 
   * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will 
   * always consist of the month names, one per line, followed by the day names, one per line, 
   * followed by the sentence containing formatting strings. This is the last line in the file. You
   * cannot make any assumptions about what will appear on each line, only that each line
   * will contain only one data element, and that it will not contain an empty line.
   * No arguments. Returns void.
  */

  /* serialize()
  * Creates a serialized object file of the TranslationText object, with the
  * name format la-CO.ser, where la is the two-letter language code and CO is
  * the two-letter region code. An example of a serialized object file can be
  * found in the exercise directory as es-BO.ser
  * I/O exceptions can be thrown.
  * No arguments. Returns void.
  */

  /* deserialize()
   * Creates a TranslationText object from a .ser file. The files are named
   * xx-YY.ser, where xx is the two-letter language code and YY is the two-
   * letter region code. es-BO.ser is an example. It can throw I/O exceptions.
   * No arguments. Returns void.
  */


public class Translator {
      private TranslationText translation;
      private final static String LANGUAGE_REGEX = "([a-z]{2})-([A-Z]{2})";
      private final static Pattern LANGUAGE_PATTERN = Pattern.compile(LANGUAGE_REGEX);
      private String filename;

      public Translator(String language) throws ArgFileNotFoundException, IOException {
        Matcher matcher = LANGUAGE_PATTERN.matcher(language);
        boolean status = matcher.matches();
        if(!status){throw new IllegalArgumentException();}
        this.filename = language;
        importTranslation();


      }

      public String translate(int monthNum, int dayNum, int year) throws IllegalArgumentException{
        if(monthNum < 1 || monthNum > 12 || dayNum < 1 || dayNum > 31){
          throw new IllegalArgumentException();
        }
        String month = translation.getMonths()[monthNum - 1];
        String day = translation.getDays()[dayNum - 1];
        String sentence = translation.getSentence();
        String formattedSentence = String.format(sentence,  day, month, year);
        return formattedSentence;
      }


      public TranslationText getTranslation() {
        return translation;
      }


      public void importTranslation() throws ArgFileNotFoundException, IOException{
        
        if( new File( filename + ".ser").exists()){
        deserialize();
        }
        else{
        importFromText();
        }



      }

      public void importFromText() throws ArgFileNotFoundException, IOException{
        BufferedReader br = null;
        try{
         br = new BufferedReader(new FileReader(  filename + ".txt"));
        String[] months = new String[12];
        String[] days = new String[31];
        String sentence = "";
        for(int i = 0; i < 12; i++){
          months[i] = br.readLine();

        }
        for(int i = 0; i < 31; i++){
          days[i] = br.readLine();
        }
        sentence = br.readLine();
        this.translation = new TranslationText(months, days, sentence);
      }
      catch(FileNotFoundException e){
        throw new ArgFileNotFoundException("File not found");
      }
      catch(IOException e){
        throw new IOException("IO Exception 0");
      }
      finally{
        if(br != null){
            br.close();
        }
      }
      }

      public void serialize(){
        ObjectOutputStream out = null;
        try{
          out = new ObjectOutputStream(new FileOutputStream( filename + ".ser"));
          out.writeObject(translation);
        }
        catch(IOException e){
          System.out.println("IO Exception 1");
        }
        finally{
          if(out != null){
            try{
              out.close();
            }
            catch(IOException e){
              System.out.println("IO Exception 2");
            }
          }
        }


      }

    //   public void deserialize() throws IOException, FileNotFoundException {
    //     ObjectInputStream in = null;
    //     FileInputStream fileIn = null;
    
    //     try {
    //         fileIn = new FileInputStream(filename + ".ser");
    //         in = new ObjectInputStream(fileIn);
    //         this.translation = (TranslationText) in.readObject();
    //     } catch (ClassNotFoundException e) {
    //         e.printStackTrace();
    //         throw new IOException("Class not found during deserialization. Make sure that the class exists and is in the classpath.");
    //     } finally {
    //         if (in != null) {
    //             try {
    //                 in.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         if (fileIn != null) {
    //             try {
    //                 fileIn.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }
    
      public void deserialize() throws IOException,  FileNotFoundException{
        ObjectInputStream in = null;
        FileInputStream infile = null;
      
        try{
          infile = new FileInputStream( filename + ".ser");
          in = new ObjectInputStream(infile);
          this.translation = (TranslationText) in.readObject();
        }

        catch(ClassNotFoundException e){
          System.out.println("Class not found");
        }
        finally{
          if(in != null){
            try{
              in.close();
            }
            catch(IOException e){
              System.out.println("IO Exception 4");
            }
          }
        }


      }



}    
