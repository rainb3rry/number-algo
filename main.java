import java.util.Scanner;
import java.util.Arrays;

class Main {
    
  public static Scanner array_out_scanner = new Scanner(System.in);
  public static Scanner start_out_scanner = new Scanner(System.in);
    
  public static String[] array_out = array_out_scanner.nextLine().split(" ");
  public static int start_out = start_out_scanner.nextInt();

  public static void calc(String[] array_string, int start) {

    final int[] array = new int[array_string.length];
    for (int i=0; i < array_string.length; i++) {
      array[i] = Integer.parseInt(array_string[i]);
    }

    int current = array[start - 1];

    if (current <= Arrays.copyOfRange(array, start, array.length).length) {
      // to right

      if (current != 0) {
        calc(array_out, start + current); // recursive function
      } else {
        System.out.println("cozum var");
      }

    } else if (current <= Arrays.copyOfRange(array, 0, start - 1).length) {
      // to left

      if(Arrays.copyOfRange(array, 0, start - 1)[start - current - 1] != current) {
        calc(array_out, start - current); // recursive function
      } else {
        // infinty loop & impossible
        System.out.println("cozum yok");
      }

    } else {
      // impossible
      System.out.println("cozum yok");
    }

  } 

  public static void main(String[] args) {

    // System.out.println("Sayi dizisini giriniz :");
    // System.out.println("Baslangic noktasini giriniz :");

    // System.out.println(Arrays.toString());

    calc(array_out, start_out);

  }
    
}
