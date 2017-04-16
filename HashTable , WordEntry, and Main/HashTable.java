
public class HashTable{
  private WordEntry []Word;
  private int size;
  
  public HashTable(int size){
    this.size = size;
    Word = new WordEntry [size];
  }
  
  public int computeHash(String s){
    int x = 2;
    s = s.toUpperCase();
        for(int i=0;i<s.length();i++){
          x = (x*2)+(int)s.charAt(i);
    }
        return x%size;
  }
  
  public void put(String s , int score){
    if(contains(s))
        Word[computeHash(s)].addNewAppearance(score);
       else
        Word[computeHash(s)] =new WordEntry(s,score);
  }
  
  public double getAverage(String s){
    double x =2.0;
    if(contains(s)){
        x=Word[computeHash(s)].getAverage();
    }
    return x;
  }
  
  public boolean contains(String s){
    boolean x = false;
    if(Word[computeHash(s)]!=null){
      x=true;
    }
    return x;
  }
  
  public String get(int x){ // just for testing.
    String w = "";
    if(Word[x]!=null){
      w = Word[x].getWord();
    }
    
    return w;
  }
}