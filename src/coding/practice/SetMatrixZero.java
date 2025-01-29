package coding.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetMatrixZero {
	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("===================================================");
		System.out.println("======== Input for brute force technique ==========");
		System.out.println("===================================================");

		System.out.print("Enter the number of rows :");
		int m = sc.nextInt();
		System.out.print("Enter the number of Columns :");
		int n = sc.nextInt();

		ArrayList<ArrayList<Integer>> matrixx = inputMatrix(sc, m, n);
		displayMatrix(matrixx);

		bruteForceTechnique(matrixx);
		displayMatrix(matrixx);

		System.out.println("===================================================");
		System.out.println("========== Input for better technique =============");
		System.out.println("===================================================");

		System.out.print("Enter the number of rows :");
		m = sc.nextInt();
		System.out.print("Enter the number of Columns :");
		n = sc.nextInt();

		matrixx = inputMatrix(sc, m, n);
		displayMatrix(matrixx);

		betterTechnique(matrixx);
		displayMatrix(matrixx);
	}

	private static void betterTechnique(ArrayList<ArrayList<Integer>> matrixx) {
		ArrayList<Integer> column = new ArrayList<>(
				Stream.generate(() -> 0).limit(matrixx.get(0).size()).collect(Collectors.toList()));

		ArrayList<Integer> row = new ArrayList<>(
				Stream.generate(() -> 0).limit(matrixx.size()).collect(Collectors.toList()));

		for (int i = 0; i < matrixx.size(); i++) {
			ArrayList<Integer> rows = matrixx.get(i);
			for (int j = 0; j < rows.size(); j++) {
				Integer integer = rows.get(j);
				if (integer == 0) {
					row.set(i, 1);
					column.set(j, 1);
				}
			}
		}

		System.out.println("Row Flag : " + row.toString());
		System.out.println("Column Flag : " + column.toString());

		for (int i = 0; i < matrixx.size(); i++) {
			ArrayList<Integer> rows = matrixx.get(i);
			for (int j = 0; j < rows.size(); j++) {
				if (row.get(i) == 1 || column.get(j) == 1) {
					matrixx.get(i).set(j, 0);
				}
			}
		}

		/*
		 * for (Iterator matrixIterator = matrixx.iterator(); matrixIterator.hasNext();)
		 * { ArrayList<Integer> rows = (ArrayList<Integer>) matrixIterator.next(); for
		 * (Iterator rowsIterator = rows.iterator(); rowsIterator.hasNext();) { Integer
		 * integer = (Integer) rowsIterator.next(); if (row.get(matrixx.indexOf(rows))
		 * == 1 || column.get(rows.indexOf(integer)) == 1) {
		 * matrixx.get(matrixx.indexOf(rows)).set(rows.indexOf(integer), 0); } } }
		 */
	}

	private static void bruteForceTechnique(ArrayList<ArrayList<Integer>> matrixx) {
		for (Iterator matrixIterator = matrixx.iterator(); matrixIterator.hasNext();) {
			ArrayList<Integer> rows = (ArrayList<Integer>) matrixIterator.next();
			for (Iterator rowsIterator = rows.iterator(); rowsIterator.hasNext();) {
				Integer integer = (Integer) rowsIterator.next();
				if (integer == 0) {
					markRow(matrixx, rows);
					markColumn(matrixx, rows.indexOf(integer));
				}
			}
		}

		System.out.println("===================================================");
		System.out.println("======= Matrix after marking row and cols ==========");
		System.out.println("===================================================");

		displayMatrix(matrixx);

		/*
		 * for (int i = 0; i < matrixx.size(); i++) { ArrayList<Integer> rows =
		 * matrixx.get(i); for (int j = 0; j < rows.size(); j++) { Integer integer =
		 * rows.get(j); if (integer == -1) { matrixx.get(i).set(j, 0); } } }
		 */

		for (Iterator matrixIterator = matrixx.iterator(); matrixIterator.hasNext();) {
			ArrayList<Integer> rows = (ArrayList<Integer>) matrixIterator.next();
			for (Iterator rowsIterator = rows.iterator(); rowsIterator.hasNext();) {
				Integer integer = (Integer) rowsIterator.next();
				if (integer == -1)
					matrixx.get(matrixx.indexOf(rows)).set(rows.indexOf(integer), 0);
			}
		}

	}

	private static void markColumn(ArrayList<ArrayList<Integer>> matrixx, int rowIndex) {
		// TODO Auto-generated method stub
		for (Iterator iterator = matrixx.iterator(); iterator.hasNext();) {
			ArrayList<Integer> rows = (ArrayList<Integer>) iterator.next();
			if (rows.get(rowIndex) != 0)
				rows.set(rowIndex, -1);
		}
	}

	private static void markRow(ArrayList<ArrayList<Integer>> matrixx, ArrayList<Integer> rows) {
		// TODO Auto-generated method stub
		for (Iterator rowsIterator = rows.iterator(); rowsIterator.hasNext();) {
			Integer integer = (Integer) rowsIterator.next();
			if (integer != 0)
				matrixx.get(matrixx.indexOf(rows)).set(rows.indexOf(integer), -1);
		}
	}

	private static void displayMatrix(ArrayList<ArrayList<Integer>> matrix) {
		System.out.println("Elements in matrix are :");
		for (ArrayList<Integer> row : matrix) {
			for (Integer element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	private static ArrayList<ArrayList<Integer>> inputMatrix(Scanner sc, int m, int n) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> rowElements = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				System.out.print("Enter element for matrix[" + i + "][" + j + "] :");
				int element = sc.nextInt();
				rowElements.add(element);
			}
			matrix.add(rowElements);
		}
		return matrix;
	}

}
