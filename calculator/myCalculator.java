import java.util.Scanner;
import java.util.TreeMap;
class inputCheck{                                                       //Check an validate the input entry
    static String entryKind = "0" ;                                     // set entryKind arabic or roman
    static void now (String input){
       input = input.trim();
       String[] inputSplited = input.split(" ");  //Split the entry
       try{             
        if( isNumeric(inputSplited[0]) && isNumeric(inputSplited[2]) //check if splited are arabic number     
            && inputSplited.length == 3                             //check if the length is 3
            && (Integer.parseInt(inputSplited[0]) >= 1 &&  Integer.parseInt(inputSplited[0]) <= 10)//number between 1 and 10
            && (Integer.parseInt(inputSplited[2]) >= 1 &&  Integer.parseInt(inputSplited[2]) <= 10)  
            && isOperator(inputSplited[1])    ){            //check if we have operator +,-,*,/
                            entryKind = ("arabic");
            }
           else if(isRomanNumber(inputSplited[0]) && isRomanNumber(inputSplited[2]) 
                     && inputSplited.length == 3
                     && isOperator(inputSplited[1]) ){
                            entryKind = ("roman");
                }
           else System.out.println ("Bad Entry. RESPECT the input rule");  //Throw bad Entry
       }
        catch (Exception e) {
            System.out.println("Something went wrong.");            // Throw error
        }
   } 
   
   static boolean isNumeric(String strNum) {                            //Method to Check if string is a number
            try {
                int d = Integer.parseInt(strNum);
            } catch (NumberFormatException | NullPointerException nfe) {
                return false;
            }
            return true;
    }

    static boolean isOperator(String myOp) {                            //Method to Check if we have operator +,-,*,/
        String[] op = {"+","-","*","/"};
        for (int i = 0; i < op.length ; i++){
            if (myOp.equals(op[i])){
                //System.out.println("operator ok");
                return true ;
            }
        }
        return false ;
    }
    
    static boolean isRomanNumber(String myNumb){                        //Method to Check if number is Roman Number
        String[] romanNumbers = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        for(int i = 0 ; i < romanNumbers.length ; i++ ){
            if(myNumb.equals(romanNumbers[i])){
                return true ;
            }
        }
        return false ;
    }
}
//------------------------------------------------------------------------------------------------------
class splitArabic{                                      //Split roman entry input
    static int a ;                                      // attributes are: a,b,operator
    static int b ;
    static String operator ;
  
    static void now(String input){
            input = input.trim();               //This Method splits the input
            String[] myInputSplited = input.split(" ");   //to set:  a,b,operator
            a = Integer.parseInt(myInputSplited[0]);    //set a and b through String to integer 
            b = Integer.parseInt(myInputSplited[2]);
            operator = myInputSplited[1];
    } 
}

class splitRoman {                                      //Split roman entry input 
    static String[] romanNumbers = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};
    static String aRoman ;
    static String bRoman ;
    static String operator ;

    static void now (String input){                          //Split the input and set 
            input = input.trim();
            String[] mySplit = input.split(" ");                // a,b,operator
            aRoman = mySplit[0];
            bRoman = mySplit[2];
            operator = mySplit[1];
    }
}

//------------------------------------------------------------------------------------------------------
class calculateMe{                      //make the calculation with 4 attributes:
    static int result ;
    
    static int now (int a , int b , String operator){    //Method to START the calculation depending of
        if (operator.equals("+")){                       // the operator +,-,*,/                     
                result = add.me( a , b );
        }
        else if (operator.equals("-")){
                result = remove.me( a , b );
        }
        else if (operator.equals("*")){
                result = multiply.me( a , b );
        }
        else if (operator.equals("/")){
                result = divide.me( a , b );    
        }
        else{System.out.println("UNKNOW OPERATOR");} // Show this in case of bad operator
        
        return result ;
        //System.out.println(calculateMe.result);
    }
}
class convertRomanToArabic{                                 //Convert Roman to Arabic
    static String[] romanNumbers = splitRoman.romanNumbers ;

        static int myIndex(String myRomanNumber){  
        int index =  0 ;
        for (int i = 0 ; i < romanNumbers.length ; i++ ){
            if ( romanNumbers[i].equals(myRomanNumber)){
                index = i ;
                break;
            }
        }
        return index ;
    }
        static int now (String input){         //This Method to set a,b as arabic numbers
            int numb = myIndex(input);
            return numb ;
        }
}

class convertArabicToRoman {                             // Convert Arabic Number to roman
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

 final static String now(int number) {
     if (number > 0){
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + now(number-l);
     }
     else if (number < 0){
          int l =  map.floorKey(-number);
        if ( -number == l ) {
            return "-" + map.get(-number);
        }
        return "-" + map.get(l) + now(-number-l);
     }
     else return "0" ;
    }

}
//------------------------------------------------------------------------------------------------------
class add{                                  //get the addition
    static int me(int a , int b){
    return a + b ;
    }
}
class remove{                              //get the remove
    static int me(int a , int b){
    return a - b ;
    }
}
class multiply{                             //get the multiplication
    static int me(int a , int b){
    return a * b ;
    }
}
class divide{                                //get the division
    static int me(int a , int b){
    return a / b ;
    }
}

//------------------------------------------------------------------------------------------------------
public class myCalculator{                             //public class
    
    public static void main(String[] args){   //Main
        //String input = "  I * I " ;
         System.out.println("Enter the operation : ");          //initialize the input field
         Scanner inputField = new Scanner(System.in);
         String input = inputField.nextLine(); 

        inputCheck.now(input); 
        if(inputCheck.entryKind == "arabic" ){              //Check if entry is with arabic numbers
            splitArabic.now(input);                 
            int a = splitArabic.a ;                         //set a
            int b = splitArabic.b ;                         //set b
            String operator = splitArabic.operator ;           //set the operator
            int result =  calculateMe.now(a , b , operator);
            System.out.println("The result is = " + result);
        }
        else if (inputCheck.entryKind == "roman" ){         //Check if entry is with roman numbers
            splitRoman.now(input);
            String aRoman = splitRoman.aRoman;
            String bRoman = splitRoman.bRoman;
            String operator = splitRoman.operator;
            int a = convertRomanToArabic.now(aRoman);       // set a
            int b = convertRomanToArabic.now(bRoman);       // set b
            int arabicResult = calculateMe.now(a , b , operator) ; //set the operator
           System.out.println("The result is = " + convertArabicToRoman.now(arabicResult));

        } 
    }
}

        
