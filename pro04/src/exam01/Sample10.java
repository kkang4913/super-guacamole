package exam01;

import java.util.Arrays;

public class Sample10 {
public static void main(String[] args) {
	/*
	 * 동적 배열
	 * 		기존 배열의 크기보다 크거나 작은 새로운 배열을 만들어서 사용하는 형태
	 */
	int[] arr1 = new int[] { 1, 2, 3 };
	// 기존 arr1의 배열의 크기가 늘어나야 동적 배열이라고 말한다.

	System.out.println(Arrays.toString(arr1));

	// 동적 배얄
	int[] temp = new int[arr1.length + 1];
	for (int i = 0; i < arr1.length; i++) {
		temp[i] = arr1[i]; // 깊은 복사

	}
	arr1 = temp; // 얕은 복사 : 참조값을 저장 / 같은 참조값을 향하게
	
	
	System.out.println(Arrays.toString(arr1));
	
	//Arrays.copyOf 를 사용한 동적 배열
	temp = Arrays.copyOf(arr1, arr1.length + 1); //arr1의 배열크기를 1늘려서 복사 
	arr1 =temp;
	
	System.out.println(Arrays.toString(arr1));

	//system.arraycopy
	temp = new int[arr1.length + 1];
			System.arraycopy(arr1, 0, temp, 0, arr1.length);
	arr1 = temp;
	System.out.println(Arrays.toString(arr1));
	
	//앞부분 배열을 추가하는 방법 system.arraycopy
	temp = new int[arr1.length + 1];
	System.arraycopy(arr1, 0, temp, 1, arr1.length);
	arr1 = temp;
	System.out.println(Arrays.toString(arr1));
}
}
