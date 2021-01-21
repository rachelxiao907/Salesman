import java.util.*;
import java.io.*;
public class TSP {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner n = new Scanner(System.in);
    ArrayList<String> cities = new ArrayList<String>();
    ArrayList<String> lines = new ArrayList<String>();
    while (n.hasNextLine()) {
      String newLine = n.nextLine();
      lines.add(newLine);
      Scanner l = new Scanner(newLine);
      String jia = l.next();
      l.next();
      String yi = l.next();
      if (!cities.contains(jia)) {
        cities.add(jia);
      }
      if (!cities.contains(yi)) {
        cities.add(yi);
      }
    }
    //assign distances
    int[][] distances = new int[cities.size()][cities.size()];
    while (lines.size() > 0) {
      Scanner l = new Scanner(lines.remove(0));
      String jia = l.next();
      l.next();
      String yi = l.next();
      l.next();
      int d = l.nextInt();
      distances[cities.indexOf(jia)][cities.indexOf(yi)] = d;
      distances[cities.indexOf(yi)][cities.indexOf(jia)] = d;
    }

/*
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
    for (int i = 0; i < distances.length; i++) {
      System.out.print("{");
      for (int j = 0; j < distances.length; j++) {
        System.out.print(distances[i][j] + ", ");
      }
      System.out.println("}");
    }
    System.out.println();
*/

    //calculate permutations using factorial to get high probability of success
    int runs = 1;
    for (int i = 2; i <= cities.size(); i++) {
      runs = runs * i;
    }
    System.out.println(hmm(distances, runs * 5));
  }

  public static int hmm(int[][] data, int runs){
    int temp = 0;
    int temp2 = 0;
    int total = 0;
    int answer = 2147483647;
    ArrayList<Integer> totals = new ArrayList<>();
    ArrayList<Integer> A = new ArrayList<>();
    for(int i = 0;i < runs; i++){
      temp = (Math.round((int)(Math.random()*(data.length-1))));
      temp2 = temp;
      while(temp2 == temp){temp2 = (Math.round((int)(Math.random()*(data.length))));}
      A.add(temp);
      A.add(temp2);
      total += data[temp][temp2];
      for(int k = 0;k < data.length-1; k++){
        temp = temp2;
        while (A.contains(temp2) && k<data.length-2) {
          temp2 = (Math.round((int)(Math.random()*(data.length))));
        }
        total += data[temp][temp2];
        A.add(temp2);
      }
      totals.add(total);
      total = 0;
      A.clear();
    }
    Integer[] finall = new Integer[runs];
    totals.toArray(finall);
    for(int i = 0; i < finall.length; i++){
      if(finall[i]<answer){
        answer = finall[i];
      }
    }
    return answer;
  }
}
