public class WordEntry{
  private String Word;
  private int numAppearances=0;
  private int totalScore = 0;
  
  public WordEntry(String text,int score){
    Word = text;
    totalScore=score;
     numAppearances=1;
  }
  public void addNewAppearance(int s){
    totalScore+=s;
    numAppearances++;;
  }
  public String getWord(){
    return Word;
  }
  public double getAverage(){
    return (double)totalScore/numAppearances;
  }
}