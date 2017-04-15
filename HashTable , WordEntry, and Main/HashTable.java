package moviereview;

public class HashTable{
  private WordEntry []Word;
  private int size;
  
  public HashTable(int size){
    this.size = size;
    Word = new WordEntry [size];
  }
  
  private int computeHash(String s){
    return 0;
  }
  
  public void put(String s , int score){
    for(int i=0;i<size;i++){
       if(Word[i]!=null){
    if(Word[i].getWord().equalsIgnoreCase(s)){
        Word[i].addNewAppearance(score);
        break;
      }
       }
       else{
        Word[i] =new WordEntry(s,score);
        break;
       }
    }
  }
  
  public double getAverage(String s){
    double x =2.0;
    for(int i=0;i<size;i++){
      if(Word[i]!=null){
      if(Word[i].getWord().equalsIgnoreCase(s)){
        x=Word[i].getAverage();
        break;
      }
      }
    }
    return x;
  }
  
  public boolean contains(String s){
    boolean x = false;
    for(int i=0;i<size;i++){
      if(Word[i]!=null){
      if(Word[i].getWord().equals(s)){
        x=true;
        break;
      }
      }
    }
    return x;
  }
  
  public void print(){
    for(int i=0;i<size;i++){
      if(Word[i]!=null){
      System.out.println(i+" = "+Word[i].getWord());
      }
    }
  }
}