package coding.practice;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascalsTriangle {
	public static void main(String[] args) {
		int numRows = 15; // Number of rows in Pascal's Triangle
		List<List<Integer>> triangle = generatePascalsTriangle(numRows);

		// Print the generated Pascal's Triangle
		for (List<Integer> row : triangle) {
			for (Integer num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> generatePascalsTriangle(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();

		// Base case; first row is always [1]
		if (numRows >= 1) {
			triangle.add(new ArrayList<>());
			triangle.get(0).add(1);
		}

		// Generate each row of Pascal's Triangle
		for (int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(i - 1);

			// The first element of each row is always 1
			row.add(1);

			// Each element in the middle is the sum of the two elements above it
			for (int j = 1; j < i; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			// The last element of each row is always 1
			row.add(1);

			triangle.add(row);
		}

		return triangle;
	}
}
