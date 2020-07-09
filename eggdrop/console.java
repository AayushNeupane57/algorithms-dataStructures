package eggdrop;
import java.util.ArrayList;
public class console {
	public static void log(int []arr) {
		System.out.printf("[ ");
		for(int elm:arr) {
			System.out.printf( elm+ ",");
		}
		System.out.println(" ] ");
	}
	public static void log(String s) {

		System.out.println(s);
	}
	public static void log(ArrayList<Integer>lst ) {
		System.out.println(lst.toString());

	}
	public static void log(int i) {
		System.out.println(i);

	}

}
