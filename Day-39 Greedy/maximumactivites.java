//simple java sol using comparator interface;

import java.util.*;

  class Meeting{
      int pos;
      Integer start;
      Integer end;
      public Meeting(int x, Integer y, Integer z){
          pos = x;
          start = y;
          end = z;
      }
  }

class Sortbyend implements Comparator<Meeting>{
    public int compare(Meeting a, Meeting b){
        return a.end - b.end;
    }
}











public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        List<Meeting> meet = new ArrayList<Meeting>();
        
        for(int i = 0; i < start.size(); i++){
            meet.add(new Meeting(i , start.get(i), end.get(i)));
        }
        Collections.sort(meet, new Sortbyend());
        int answer = 1;
        int endtime = meet.get(0).end;
        for(int i = 1; i < meet.size(); i++){
            if(endtime <= meet.get(i).start){
                endtime = meet.get(i).end;
                answer++;
            }
        }
        return answer;
    }
}