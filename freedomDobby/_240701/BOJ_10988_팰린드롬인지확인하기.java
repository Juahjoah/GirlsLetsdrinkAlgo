import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        // 입력받은 str 저장
         String str = sc.nextLine();
        int len = str.length();
        // 배열에 str 저장
         char[] charArr = str.toCharArray();

        //배열 반대로 꺼내기 똑같은지
        StringBuilder str2 = new StringBuilder();
        for(int i = len-1; i >= 0; i--){
            str2.append(charArr[i]);
        }
        
        if (str2.toString().equals(str)) System.out.println(1);
       else System.out.println(0);    
    }
}