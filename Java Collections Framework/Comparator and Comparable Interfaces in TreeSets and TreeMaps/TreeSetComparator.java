import java.util.Comparator;
import java.util.TreeSet;
class Comparaclass implements Comparator<String>{
 public int compare(String t1, String t2){             
     return t2.compareTo(t1); // Descending sort order
 }
}
public class TreeSetComparator {
 public static void main (String args[]){
     TreeSet<String> treeSetcolors = new TreeSet<String>(new Comparaclass());
     treeSetcolors.add("Red");
     treeSetcolors.add("Violet");
     treeSetcolors.add("Yellow");
     treeSetcolors.add("Blue"); 
     System.out.println("Colors in TreeSet in Descending order : "+treeSetcolors);       
 }
}
