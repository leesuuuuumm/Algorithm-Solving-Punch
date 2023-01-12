import java.util.*;

class Solution {
    public int solution(int[] order) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=1;i<=order.length;i++){
            que.offer(i);
        }
        
        a: for(int i=0;i<order.length;i++){
            while(true){
                if(stack.size()!=0 && que.size()==1 && stack.peek()!=order[i] && que.peek()!=order[i]) break a;
                
                if(stack.size()!=0 && stack.peek() == order[i]){
                    result++;
                    stack.pop();
                    break;
                }
                
                if(que.size()!=0 && que.peek() == order[i]){
                    result++;
                    que.poll();
                    break;
                }
                
                if(que.size()!=0 && que.peek()!=order[i]){
                    stack.push(que.poll());
                }
            }
        }

        return result;
    }
}
