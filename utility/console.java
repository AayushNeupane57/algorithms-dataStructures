package utility;

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
	public static void log(boolean i) {
		System.out.println(i);

	}
	public static void log(Point []arr) {
		
		System.out.printf("[");
		for(Point elm:arr) {
			System.out.printf( "("+elm.x+ "," +elm.y+ "),");
		}
		System.out.println(" ] ");
	}
	public static void log(Point elm) {	
		System.out.println( "("+elm.x+ "," +elm.y+ "),");
	}
	public static void log(Point []arr,int len) {
		
		System.out.printf("[");
		for(int i=0;i<len;i++) {
			System.out.printf( "("+arr[i].x+ "," +arr[i].y+ "),");
		}
		System.out.println(" ] ");
	}


}
