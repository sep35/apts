import java.util.*;

public class AllWordLadders {
      public int[] solve(String[] words,  String from, String to) {
              ArrayList<String> wordList = new ArrayList<String>();
              for (int i=0;i<words.length;i+=1){
                      wordList.add(words[i]);
              }
              if (!wordList.contains(to)){
                      wordList.add(to);
              }              
              HashMap<String,Integer> wordLadder = new HashMap<String,Integer>();
              Queue<String> wordQueue = new LinkedList<String>();
              HashMap<String,Integer> shortLadder = new HashMap<String,Integer>();
              wordQueue.add(from);
              wordLadder.put(from,1);
              shortLadder.put(from,1);
              String current=from;
              while (!wordQueue.isEmpty()){
                      for (String word:wordList){
                              if (isOneAway(current,word) && (current!=from || word!=to)){
                                      if (!wordLadder.containsKey(word)){
                                              wordLadder.put(word,1);
                                              shortLadder.put(word,shortLadder.get(current)+1);
                                              wordQueue.add(word);
                                      } else if (shortLadder.get(word)==shortLadder.get(current)+1){
                                              wordLadder.put(word,wordLadder.get(word)+1);
                                              wordQueue.add(word);
                                      } else if (shortLadder.get(current)+1<shortLadder.get(word)){
                                              wordLadder.put(word, 1);
                                              shortLadder.put(word,shortLadder.get(current)+1);
                                              wordQueue.add(word);
                                      }
                              }
                      }
                      current=wordQueue.poll(); //Retrieves and removes head
              }
              int[] ans = new int[2];
              if (shortLadder.containsKey(to)){
                      ans[0]=shortLadder.get(to);
                      ans[1]=wordLadder.get(to)/2;
                      return ans;
              } else {
                      ans[0]=0;
                      ans[1]=0;
                      return ans;
              }
      }
      
      public boolean isOneAway(String a, String b){
              int diff=0;
              for (int i=0;i<a.length();i+=1){
                      if (a.charAt(i)!=b.charAt(i)) diff+=1;
              }
              if (diff==1) return true;
              else return false;
      }
   }