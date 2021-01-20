import java.util.*;
import java.io.*;
public class TSP {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner n = new Scanner(System.in);
    ArrayList<String> cities = new ArrayList<String>();
    int[][] distances = new int[9][9];
    while (n.hasNextLine()) {
      Scanner l = new Scanner(n.nextLine());
      String jia = l.next();
      l.next();
      String yi = l.next();
      if (!cities.contains(jia)) {
        cities.add(jia);
      }
      if (!cities.contains(yi)) {
        cities.add(yi);
      }
      l.next();
      int d = l.nextInt();
      distances[cities.indexOf(jia)][cities.indexOf(yi)] = d;
      distances[cities.indexOf(yi)][cities.indexOf(jia)] = d;
    }

    //Print out cities arraylist
    System.out.println("Cities:");
    System.out.print("[");
    for (int i = 0; i < cities.size(); i++) {
      System.out.print(cities.get(i) + ", ");
    }
    System.out.println("]");
    System.out.println();

    //Print out  distances 2D array
    System.out.println("Distances");
    for (int i = 0; i < 9; i++) {
      System.out.print("{");
      for (int j = 0; j < 9; j++) {
        System.out.print(distances[i][j] + ", ");
      }
      System.out.println("}");
    }
    System.out.println();
  }
}
