import java.util.Random;
import java.util.Scanner;

public class Generator {
	boolean IncludeUpper=false;
	boolean IncludeLower=false;
	boolean IncludeNum=false;
	boolean IncludeSym=false;
	Alphabet Alphabet;
	
	public Generator(boolean IncludeUpper,boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
		Alphabet=new Alphabet(IncludeUpper,IncludeLower,IncludeNum,IncludeSym);
	}
	
	public Password GeneratePassword(int Length) {
		String Pass="";
		char Char;
		int n=Alphabet.PoolSize;
		
		int max = n-1; 
        int min = 0; 
        int range = max - min + 1; 
        
		
		
		for(int i=0;i<Length;i++) {
			int index=(int)(Math.random() * range) + min; 
			Char=Alphabet.Pool.charAt(index);
			Pass=Pass+Char;
		}
		
		return new Password(Pass);
		
	}
	
	
	public static void UsefulInfo() {
		System.out.println();
		System.out.println("Use a minimum password length of 8 or more characters if permitted");
		System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
		System.out.println("Generate passwords randomly where feasible");
		System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
		System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\nusernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
		System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
		System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
	}
	
	
	
	
	
	public static void PasswordRequestError() {
		System.out.println("You have entered something incorrect let's go over it again \n");		
	
	}
	
	
	public static void PasswordCheck() {
		String Input;
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter your password:");
		Input = in.nextLine();
		
		Password P=new Password(Input);
		System.out.println(P.CalculateScore());
	}
	



}
