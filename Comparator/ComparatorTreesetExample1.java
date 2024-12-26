import java.util.Comparator; 
import java.util.TreeSet; 
  
  
// Main class 
// TreeSetDemo class 
public class ComparatorTreesetExample1  
{ 
  
    // Main driver method 
    public static void main(String[] args) 
    { 
  
        // Creating an empty TreeSet of string type 
        TreeSet<String> tree_set = new TreeSet<String>((astr,bstr)-> bstr.compareTo(astr)); 
  
        // Adding elements to our TreeSet object 
        // using add() method 
        tree_set.add("G"); 
        tree_set.add("E"); 
        tree_set.add("E"); 
        tree_set.add("K"); 
        tree_set.add("S"); 
        tree_set.add("4"); 
  
        
		System.out.println("The elements sorted in descending order:" + tree_set); 
    } 
}