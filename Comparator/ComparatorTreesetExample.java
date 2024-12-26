import java.util.Comparator; 
import java.util.TreeSet; 
  
// Class 1 
// Comparator class 
class DComparator implements Comparator<String>
{ 
  
    // Method 
    // To compare two strings 
    public int compare(String str1, String str2) 
    { 
		return str2.compareTo(str1); 
    } 
} 
  
// Main class 
// TreeSetDemo class 
public class ComparatorTreesetExample
{ 
  
    // Main driver method 
    public static void main(String[] args) 
    { 
  
        // Creating an empty TreeSet of string type 
        TreeSet<String> tree_set = new TreeSet<String>(); 
  
        // Adding elements to our TreeSet object 
        // using add() method 
        tree_set.add("G"); 
        tree_set.add("E"); 
        tree_set.add("E"); 
        tree_set.add("K"); 
        tree_set.add("S"); 
        tree_set.add("4"); 
  
        // Printing elements in set before using comparator 
        System.out.println("Set before using the comparator: " + tree_set); 
  
        // Again creating an empty TreeSet of string type 
        // with reference to Helper class 
       TreeSet<String> tree_set1 = new TreeSet<String>(new DComparator()); 
		//DComparator d = new DComparator();
		//TreeSet<String> tree_set1 = new TreeSet<String>(d.reversed());
        // Adding elements to our TreeSet object 
        // using add() method 
        tree_set1.add("G"); 
        tree_set1.add("E"); 
        tree_set1.add("E"); 
        tree_set1.add("K"); 
        tree_set1.add("S"); 
        tree_set1.add("4"); 
  
        // Printing elements in set before using comparator 
        System.out.println("The elements sorted in descending order:" + tree_set1); 
    } 
}