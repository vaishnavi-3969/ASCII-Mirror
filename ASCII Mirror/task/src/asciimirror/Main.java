package asciimirror;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input the file path:");
        List <String> anim = new ArrayList <String>();

        try (Scanner sc = new Scanner(new File(new Scanner(System.in).nextLine()))) {
            int maxL = 0;
            while (sc.hasNext()) {
                anim.add(sc.nextLine());
                maxL = Math.max(maxL, anim.get(anim.size() - 1).length());
            }
            for(String line : anim) {
                line += " ".repeat(maxL - line.length());
                String rev = revLine(line);
                System.out.println(line + " | " + rev);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    public static String revLine(String line) {
        char[] str = line.toCharArray();
        char[] revStr = new char[str.length];
        int j=0;
        for(int i=line.length()-1; i>=0; i--){
            revStr[j]=line.charAt(i);
            if(revStr[j]=='('){
                revStr[j]=')';
            }else if(revStr[j]==')'){
                revStr[j]='(';
            }else if(revStr[j]=='/'){
                revStr[j]='\\';
            }else if(revStr[j]=='\\') {
                revStr[j] = '/';
            }else if(revStr[j]=='['){
                revStr[j]=']';
            }else if(revStr[j]==']'){
                revStr[j]='[';
            }else if(revStr[j]=='<'){
                revStr[j]='>';
            }else if(revStr[j]=='>'){
                revStr[j]='<';
            }else if(revStr[j]=='{'){
                revStr[j]='}';
            }else if(revStr[j]=='}'){
                revStr[j]='{';
            }
            j++;
        }
        return String.valueOf(revStr);
    }
}