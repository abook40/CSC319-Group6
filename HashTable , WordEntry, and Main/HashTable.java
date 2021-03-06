

public class HashTable{
  private WordEntry []Word;
  private int size;
  
  public HashTable(int size){
    this.size = size;
    Word = new WordEntry [size];
  }
  
  private int computeHash(String s){
    String a = s.toUpperCase();
    int x = 7;
    for(int i=0;i<a.length();i++){
      int h = a.charAt(i);
      x = (x*27+h)%size;
    }
    return x;
  }
  
  public void put(String s , int score){
    if(contains(s)){
      Word[computeHash(s)].addNewAppearance(score);
     // System.out.println("***** "+  s + " Total Appearances : " + Word[computeHash(s)].numAppearances );
    }
    else {
      // int count =0;
      int hash = computeHash(s);
      while(true){
        if(Word[hash]==null){
          //System.out.println(" Insert the word : " +s + " in " + hash);
          Word[hash] =new WordEntry(s,score);
          break;
        }
        //count++;
//System.out.println(" Collision occured at : " + hash +"  With the word  "+" | " + s +" | " + " and " +" | " + Word[hash].getWord()+" | " + " getting to hash : " + (hash+1) + " number of changes : "+ count);
        hash++;
        if(hash ==size){
          hash=0;
        }
      }
    }
  }
  
  
  public double getAverage(String s){
    if(contains(s)){
      return Word[search(s)].getAverage();
    }
return 2.0;
  }
  
  
  public int search(String s){
    String a = s.toUpperCase();
    int hash = computeHash(s);
    while(Word[hash]!=null){
      String b = Word[hash].getWord().toUpperCase();
      if(b.equals(a))
        return hash;
      else
        hash++;
      if(hash==size){
        hash=0;
      }
    }
    return hash;
  }
  
  
  public boolean contains(String s){
    String a =s.toUpperCase();
    int hash = computeHash(s);
    while(Word[hash]!=null){
      String b = Word[hash].getWord().toUpperCase();
      if(b.equals(a))
        return true;
      else{
        hash++;
        if(hash==size){
          hash=0;
        }
      }
    }
    return false;
  }
  
}
