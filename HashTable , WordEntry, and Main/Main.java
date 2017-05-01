
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  
  public static void main(String args[]) throws IOException {
    
    HashTable table = new HashTable(20000);
    /*
     File file = new File("movieReviews.txt");
     BufferedReader reader = null;
     
     int x = 1;
     try{
     reader = new BufferedReader(new FileReader(file));
     if(reader.readLine() == null)
     {
     System.out.println("Cound not open file");
     }
     else{
     table = new HashTable(2000);
     while((line = reader.readLine()) != null)
     {
     score = Integer.parseInt(message.substring(0 , 1));
     
     message = line.substring(x , message.indexOf(" "));
     x += message.indexOf(" ");
     }
     }
     } catch (FileNotFoundException e){
     } catch(IOException e){
     }
     */
    
    List<String> lines = readLines("movieReviews.txt");
    for (String a : lines) {
      System.out.println("enter a review -- Press return to exit:");
       System.out.println(a.substring(1,a.length()-1));
      StringTokenizer token = new StringTokenizer(a, " ");
      String message;
      
      int count =0;
      double tscore = 0;
      int score = Integer.parseInt(token.nextToken());
      while (token.hasMoreTokens()) {
        message = token.nextToken();
        if(!message.equals(" ") && !message.equals("'"))
        {
        table.put(message, score);
        count++;
        
        tscore+=table.getAverage(message);
        }
      }
      double ttScore = tscore/count;
      System.out.println(" The review has an average value of " + ttScore );
     System.out.println( (ttScore>=2  ?  " Positive Sentiment " :   " Negative Sentiment "));
      System.out.println();
    }
    
  }
  
  private static List<String> readLines(String file) throws IOException {
    
    return Files.readAllLines(Paths.get(file));
    
  }
}
