package JAVA;

import java.util.Scanner;

class operation{
    int count;
    
    public void convertToUppercase(String s) {
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        String s1 = new String(chars);
        System.out.println(s1);
        
        //return s.toUpperCase();
    }
    
    public void convertToLowercase(String s) {
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        String s1 = new String(chars);
        System.out.println(s1);
        
        //return s.toLowerCase();
    }
    
    public void compare(String s1, String s2) {
         if(s1.length()!=s2.length()){
        System.out.println("Strings are not equal");
        return;
    }
    for(int i=0;i<s1.length();i++){
        if(s1.charAt(i) != s2.charAt(i)){
            System.out.println("Strings are not equal");
            return;
        }
    }
    System.out.println("Strings are equal");
    
    //return s1.equals(s2);
}

   public void countletter(String s) {
        s = s.trim();
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == ' ') {
				
            } else {
                count++;
            }
        }
        System.out.println(count);
        
        //return s.chars().filter(Character::isLetter).count();
    }
    
    public boolean search(String s1, String p) {
    s1 = s1.trim();
    int n = s1.length();
    int m = p.length();

    if (m > n){
        return false;
    }
    
    for (int i = 0; i <= n - m; i++) {
        int j;
        for (j = 0; j < m; j++) {
            if (s1.charAt(i + j) != p.charAt(j)) {
                break;
            }
        }
        if (j == m) {
            return true;
        }
    }
    return false;
    
    //return s1.contains(p);
   }
   
   public void reverse(String s){
        String temp ="";
        for(int i=s.length()-1;i>=0;i--){
            temp = temp + s.charAt(i);
        }
        System.out.println("string : " + temp);
        
        //Direct method to reverse string :- 
        // return new StringBuilder(s).reverse().toString();
        

    }
    
    public void extractdigits(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!(s.charAt(i)>='0' && s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
        }
        System.out.println("Original string : "+s);
        System.out.println("Updated string : "+sb.toString());
        
        // return s.replaceAll("\\d", "");
    }
    
    public void replace(String s,String old , String news){
        //StringBuilder sd = new StringBuilder(s);
        //sd.replace(old,news);
        String sd = s.replace(old,news); 
        System.out.println(sd);
        
    }
    
    public void countWord(String s){
        int count = 0;
    boolean isWord = false;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != ' ') {
            if (!isWord) {
                count++;
                isWord = true;
            }
        } else {
            isWord = false;
        }
    }

    System.out.println("The number of words are: " + count);
    }
    
    //String s1=s.trim();
	//	 if(s.isEmpty())
	//{count=0;
	//}
	//	 return count=s.split("\\s+").length;
}

class Strings {
    public static void main(String[] args) {
        System.out.print("Enter String : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        operation o = new operation();
        int choice;
        
        do{
           
            System.out.println("\nOperations :-");
            System.out.println("1.Convert to Uppercase ");
            System.out.println("2.Convert to Lowercase ");
            System.out.println("3.Compare strings ");
            System.out.println("4.Count letters ");
            System.out.println("5.Search Pattern in String ");
            System.out.println("6.Reverse String ");
            System.out.println("7.Extract digits from string");
            System.out.println("8.Replace Oldstring with Newstring");
            System.out.println("9.Count word in string");
            System.out.println("10.Exit");
            System.out.print("\nEnter your choice : ");
            
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    o.convertToUppercase(s);
                    break;
                case 2:
                    o.convertToLowercase(s);
                    break;
                case 3:
                    System.out.print("Enter string to compare : ");
                    String s1 = sc.nextLine();
                    o.compare(s,s1);
                    break;
                case 4:
                    o.countletter(s);
                    break;
                case 5:
                    System.out.print("Enter Pattern to search : ");
                    String p = sc.nextLine();
                    boolean b = o.search(s,p);
                    System.out.println("The pattern "+p+" is present in the string is "+b);
                    break;
                case 6:
                    o.reverse(s);
                    break;
                case 7:
                    o.extractdigits(s);
                    break;
                case 8:
                     System.out.print("Enter word in string to replace : ");
                     String old = sc.nextLine();
                     System.out.print("Enter word to replace : ");
                     String news = sc.nextLine();
                     o.replace(s,old,news);
                     break;
                case 9:
                    
                     o.countWord(s);
                     break;
                case 10:
                    System.out.println("-x- Exit -x-");
                    break;
            }
            
        }
        while(choice!=10);
        sc.close();
    }
}
