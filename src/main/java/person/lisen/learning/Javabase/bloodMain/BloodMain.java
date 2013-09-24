package person.lisen.learning.Javabase.bloodMain;

/**
 * 
Slove the problem of Main 

Q:What if the main method is declared as private?
A:The program compiles properly but at run time it will give "Main method not public." message.

Q: What if the static modifier is removed from the signature of the main method?
A: Program compiles. But at run time throws an error "NoSuchMethodError".

Q: What if I write static public void instead of public static void?
A:  Program compiles and runs properly.

Q: What if I do not provide the String array as the argument to the method?
A:  Program compiles but throws a run time error "NoSuchMethodError".

Q: What is the first argument of the String array in main method?
A:  The String array is empty. It does not have any element. This is unlike C/C++（读作plus plus) where the first element by default is the program name.

Q: If I do not provide any arguments on the command line, then the String array of Main method will be empty or null?
A:  It is empty. But not null.

Q: How can one prove that the array is notnull but empty using one line of code?
A:  Print args.length. It will print 0. That means it is empty. But if it would have been null then it would have thrown a NullPointerException on attempting to print args.length.
 * 
 * @author user
 *
 */
public class BloodMain {
	
	static void  main(String argc[]){
		System.out.println("The hope is in our hand!");
		System.out.println(argc.length);
		return;
	}
	
}
