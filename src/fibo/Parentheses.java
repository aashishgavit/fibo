package fibo;

//Valid Parentheses
import java.util.Stack;

public class Parentheses 
{
 public static void main(String[] args) 
 {
     String s = "(){}[]";
     Stack<Character> st = new Stack<>();

     for (char c : s.toCharArray()) 
     {
         if (c == '(' || c == '{' || c == '[')
             st.push(c);
         else if (st.isEmpty()) {
             System.out.println(false);
             return;
         } 
         else {
             char open = st.pop();
             if ((c == ')' && open != '(') ||
                 (c == '}' && open != '{') ||
                 (c == ']' && open != '[')) {
                 System.out.println(false);
                 return;
             }
         }
     }
     System.out.println(st.isEmpty());
 }
}
