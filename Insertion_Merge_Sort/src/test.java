import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		String arr[][] = new String[25][3];
		int i = 0;
		int m = 0;
		
		//part_1_2();
		
		while (m < 2) {
			if (m == 0) {
				try {  
					File students = new File("student.txt");
					Scanner in = new Scanner(students);
					in.nextLine();
					while(in.hasNextLine()) {
						String line = in.nextLine();
						if (line != null) {
							String arr_test[] = line.split(",");
							arr[i][0] = arr_test[0];
							arr[i][1] = arr_test[1];
							arr[i][2] = arr_test[2];
							i++;
						}
					}
					in.close();
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				insertion_sort_2D(arr);
				
				System.out.println("INSERTION SORT");
				System.out.println("");
				
				for (int k = 0; k < 25; k++) {
					for (int j = 0; j < 3; j++) {
						System.out.print(arr[k][j] + " ");
					}
					System.out.println();
				}
			}
			
			else if (m == 1) {
				try {  
					File students = new File("student.txt");
					Scanner in = new Scanner(students);
					in.nextLine();
					while(in.hasNextLine()) {
						String line = in.nextLine();
						if (line != null) {
							String arr_test[] = line.split(",");
							arr[i][0] = arr_test[0];
							arr[i][1] = arr_test[1];
							arr[i][2] = arr_test[2];
							i++;
						}
					}
					in.close();
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				merge_sort_2D(arr, 0, 24);
				
				System.out.println("MERGE SORT");
				System.out.println("");
				
				for (int k = 0; k < 25; k++) {
					for (int j = 0; j < 3; j++) {
						System.out.print(arr[k][j] + " ");
					}
					System.out.println();
				}
			}
			System.out.println("");
			i = 0;
			m++;
		}
	}

	static void insertion_sort_2D(String arr[][]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = Integer.valueOf(arr[i][2]);
			String key_name = arr[i][0];
			String key_surname = arr[i][1];
			String key_number = arr[i][2];
			int j = i - 1;

			while (j >= 0 && Integer.valueOf(arr[j][2]) > key) {
				arr[j + 1][0] = arr[j][0];
				arr[j + 1][1] = arr[j][1];
				arr[j + 1][2] = arr[j][2];
				j = j - 1;
			}
			arr[j + 1][0] = key_name;
			arr[j + 1][1] = key_surname;
			arr[j + 1][2] = key_number;
		}
	}
	
	static void insertion_sort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	static void merge_sort_2D(String arr[][], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			merge_sort_2D(arr, l, m);
			merge_sort_2D(arr, m + 1, r);

			// Merge the sorted halves
			merge_2D(arr, l, m, r);
		}
	}
	
	static void merge_2D(String arr[][], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		String L[][] = new String[n1][3];
		String R[][] = new String[n2][3];

		for (int i = 0; i < n1; ++i) {
			L[i][0] = arr[l + i][0];
			L[i][1] = arr[l + i][1];
			L[i][2] = arr[l + i][2];
		}
			
		for (int j = 0; j < n2; ++j) {
			R[j][0] = arr[m + 1 + j][0];
			R[j][1] = arr[m + 1 + j][1];
			R[j][2] = arr[m + 1 + j][2];
		}
			
		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			int L_ctrl = Integer.valueOf(L[i][2]);
			int R_ctrl = Integer.valueOf(R[j][2]);
			if (L_ctrl <= R_ctrl) {
				arr[k][0] = L[i][0];
				arr[k][1] = L[i][1];
				arr[k][2] = L[i][2];
				i++;
			} else {
				arr[k][0] = R[j][0];
				arr[k][1] = R[j][1];
				arr[k][2] = R[j][2];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k][0] = L[i][0];
			arr[k][1] = L[i][1];
			arr[k][2] = L[i][2];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k][0] = R[j][0];
			arr[k][1] = R[j][1];
			arr[k][2] = R[j][2];
			j++;
			k++;
		}
	}
	
	static void merge_sort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			merge_sort(arr, l, m);
			merge_sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	static void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	static void part_1_2(){
		for (int j = 0; j < 2; j++) {
			int arr_1[] = {4, 3, 2, 10, 12, 1, 5, 6};

			if (j == 0) {
				insertion_sort(arr_1);
				System.out.println("PART 1");

				for (int i = 0; i < 8; i++) {
					System.out.print(arr_1[i] + " ");
				}
				
				System.out.println(" ");
			}
			
			else if (j == 1) {
				merge_sort(arr_1, 0, 7);
				System.out.println("PART 2");

				for (int i = 0; i < 8; i++) {
					System.out.print(arr_1[i] + " ");
				}
				System.out.println("");
			}
			
			System.out.println("");
		}
	}

}
