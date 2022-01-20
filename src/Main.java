// Author : Sencer Yücel
// Section : 2
// Assignment : 1


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

//I only imported linked list to keep user inputs. I thought it would be better than keep them in a random sized array.
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean formChecker = false;
        Stack<Character> c2 = new Stack<Character>();
        Stack<Integer> c2Bracks = new Stack<Integer>();
        Scanner i1 = new Scanner(new FileReader("sampleinput2.txt"));
        LinkedList<String> list = new LinkedList<>();
        boolean isInputSize = true;
        int inputN = i1.nextInt(), finish;
        char temp, temp2;

        //Takes input from the txt file until text file ends.
        while(isInputSize){
            try{
                list.add(i1.next());
            }catch(NoSuchElementException e){
                isInputSize = false;
            }
        }
        //Checks the input whether it is valid or invalid.
        for(int k = 0; k < inputN; k++){
            System.out.println("Parsing expression #" + (k+1) +":");
            for(int i = 0; i < list.get(k).length(); i++){
                if(list.get(k).charAt(i) == '(' || list.get(k).charAt(i) == '[' || list.get(k).charAt(i) == '{' ||
                        list.get(k).charAt(i) == ')' || list.get(k).charAt(i) == ']' || list.get(k).charAt(i) == '}' ||
                        list.get(k).charAt(i) == '0' || list.get(k).charAt(i) == '1' || list.get(k).charAt(i) == '2' ||
                        list.get(k).charAt(i) == '3' || list.get(k).charAt(i) == '4' || list.get(k).charAt(i) == '5' ||
                        list.get(k).charAt(i) == '6' || list.get(k).charAt(i) == '7' || list.get(k).charAt(i) == '8' ||
                        list.get(k).charAt(i) == '9' || list.get(k).charAt(i) == '+' || list.get(k).charAt(i) == '-' ||
                        list.get(k).charAt(i) == '*' || list.get(k).charAt(i) == '/' || list.get(k).charAt(i) == ' '){
                }
                else{
                    System.out.println("Invalid Parse");
                    System.exit(0);
                }
            }
            //Pushes open brackets to the stack.
            for(int i = 0; i < list.get(k).length(); i++){
                //Trimming operation in order to avoid whitespaces in the input if exists any.
                list.get(k).trim();
                temp = list.get(k).charAt(i);
                if(temp == '(' || temp == '[' || temp == '{'){
                    c2.push(temp);
                    c2Bracks.push(i);
                }

                //If the stack is not empty, then we need to check closing brackets, if exists, we need to pop them.
                if(!c2.isEmpty()){
                    if(temp == ')' || temp == ']' || temp == '}'){
                        temp2 = c2.pop();
                        finish = c2Bracks.pop();
                        if(temp == ')' && temp2 == '(' || temp == ']' && temp2 == '[' || temp == '}' && temp2 == '{' ){
                            System.out.println(finish + "," + i + "," + list.get(k).substring(finish,i+1));
                            //If the stack is empty, then the expression is well-formed.
                            if(c2.isEmpty()){
                                formChecker = true;
                            }
                        }
                    }
                    //If the stack is not empty, then expression is not well-formed. We are equalizing our boolean value to false.
                }else{
                    formChecker = false;
                }
            }
            //If our boolean controller is true, then the expression is well-formed. So, these are the printing lines with respect to our bool value.
            if(formChecker){
                System.out.println("Given expression is well formed.");
            }else{
                System.out.println("Given expression is not well formed.");
            }
        }
    }
}










