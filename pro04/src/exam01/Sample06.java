package exam01;

import java.util.Arrays;
import java.util.Iterator;

public class Sample06 {
public static void main(String[] args) {
	/*
	 * 배열의 깊은 복사 -> 반복문을 사용하여 값을 하나씩 배열에 저장
	 */
	int[] arr1 = new int[] {1,2,3,4,5};
	int[] arr2 = new int[arr1.length];
			
			for (int i = 0; i < arr1.length; i++) {
				arr2[i] = arr1[i];
			}
			for (int i = 0; i < arr1.length; i++) {
				System.out.println(arr2[i]);
			}
			//자바의 기본 기능을 사용한 깊은 복사
			int[] arr3 = new int[arr1.length];
					    //원본의 0번째,//복사본 0번째 //배열의 크기만큼
			System.arraycopy(arr1, 1, arr3, 0, arr1.length -1);
			
			arr1[0] = 10;
			for (int i = 0; i < arr1.length; i++) {
				System.out.printf("arr1[%d] - > %d, arr3[%d] -> %d\n", i, arr1[i], i, arr3[i] );
			}
			System.out.println("\n");

			//Arrays 객체를 사용한 깊은 복사
			int[] arr4 = Arrays.copyOf(arr1, arr1.length +3 );
			
			arr1[1] = 20;
			for (int i = 0; i < arr1.length; i++) {
				System.out.printf("arr1[%d] - > %d, arr4[%d] -> %d\n", i, arr1[i], i, arr4[i] );
			}		
			System.out.println("arr4[5] -> " +arr4[5]);
			System.out.println("arr4[6] -> " +arr4[6]);
			System.out.println("arr4[7] -> " +arr4[7]);
			System.out.println(" ");
			//.clone() 메서드를 사용한 깊은 복사
			int[] arr5 = arr1.clone();
			
			arr1[2] = 30;
			for (int i = 0; i < arr1.length; i++) {
				System.out.printf("arr1[%d] - > %d, arr5[%d] -> %d\n", i, arr1[i], i, arr5[i] );
			}		


}
}
