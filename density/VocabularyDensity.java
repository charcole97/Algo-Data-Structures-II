//---------------------------------------------------------------------------
// VocabularyDensity.java       by Dale/Joyce/Weems                 Chapter 5
//
// Displays the number of total words, unique words in the input text file,
// and the resulting vocabulary density.
// Input file indicated by a command line argument.
//---------------------------------------------------------------------------


import java.io.*;
import java.util.*;

public class VocabularyDensity
{
  public static void main(String[] args) throws IOException 
  {
    final int CAPACITY = 1000;   // capacity of collection
    String fname = args[0];      // input file of text
    String word;                 // current word
    int numWords = 0;            // total number of words
    int uniqWords;               // number of unique words
    double density;              // vocabulary density

    ArrayCollection<String> words = new ArrayCollection<String>(CAPACITY);

    // Set up file reading
    FileReader fin = new FileReader(fname);
    Scanner wordsIn = new Scanner(fin);
    wordsIn.useDelimiter("[^a-zA-Z']+");  // delimiters are nonletters,'

    while (wordsIn.hasNext())      // while more words to process
    {
      word = wordsIn.next();          
      word = word.toLowerCase();
      if (!words.contains(word))
        words.add(word);
      numWords++;
    }
  
    density = (double)numWords/words.size();
    System.out.println("Analyzed file " + fname);
    System.out.println("\n\tTotal words:  " + numWords);
    if (words.size() == CAPACITY)
      System.out.println("\tUnique words: at least " + words.size());
    else
    {
      System.out.println("\tUnique words: " + words.size());
      System.out.printf("\n\tVocabulary density: %.2f", density);
    }
  } 
} 
