import java.awt.Point;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Convex {
	
	boolean x;
	boolean y;

	public Convex(boolean x, boolean y) {
		this.x = x;
		this.y = y;
	}

	public static void Sol(Point arr[]) {
		// creating an arraylist to hold the solution,
		// in order to delete the duplicate points
		ArrayList<Point> list = new ArrayList<Point>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				Point pt1 = arr[i];
				Point pt2 = arr[j];
				int gt = 0;
				int lt = 0;
				// System.out.println(pt1);
				// System.out.println(pt2);

				// a = y2-y1
				int a = (int) (pt2.getY() - pt1.getY());
				// b = x2-x1
				int b = (int) (pt1.getX() - pt2.getX());
				// c = x1y2-x2y1
				int c = (int) ((pt1.getX() * pt2.getY()) - (pt2.getX() * pt1.getY()));

				for (int k = 0; k < arr.length; k++) {
					// if(arr[i]== arr[k] || arr[j]== arr[k]){
					// System.out.println("bad");
					// }
					// else{

					if (a * arr[k].getX() + b * arr[k].getY() > c) {
						lt = lt + 1;
					} else if (a * arr[k].getX() + b * arr[k].getY() < c) {
						gt = gt + 1;
					} else {

					}

				}
				if (lt == 0) {
					list.add(pt1);
					list.add(pt2);

					// System.out.println(arr[i]);
					// System.out.println(arr[j]);
				} else if (gt == 0) {
					list.add(pt1);
					list.add(pt2);

				} else {

				}

			}

		}
		// creating a new array that will re-sort the convex hall points to the
		// original order that the user gave.
		ArrayList<Point> best = new ArrayList<Point>();
		for (int g = 0; g < arr.length; g++) {
			if (list.contains(arr[g])) {
				best.add(arr[g]);

			}
		}
		// converting to a linked hashset in order to remove the duplicates
		Set<Point> s = new LinkedHashSet<>(best);
		Iterator<Point> itr = s.iterator();
		while (itr.hasNext()) {
			Point t = itr.next();
			// Point p = itr.next();

			System.out.println(t.x + " " + t.y);
		}

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Point inSize[] = new Point[scan.nextInt()];
		for (int i = 0; i < inSize.length; i++) {
			inSize[i] = new Point(scan.nextInt(), scan.nextInt());

		}
		scan.close();
		if (inSize.length >= 1 && inSize.length <= 100) {
			Sol(inSize);
		} else {

		}

	}

}