
public class Sort1 {

	public static void main(String[] args) {
		int[] list = {1,5,2,4,3};
		printList(list);
		printList(new Sort1().sort(list));
	}

	public static void printList(int[] list) {
		for(int number : list)
			System.out.print(number+", ");
		System.out.println();
	}

	public int[] sort(int[] numbers) {

		for(int i = 0; i < numbers.length; i++) {
			for(int j = i; j < numbers.length; j++) {
				
				if (numbers[j] < numbers[i]) {
					int tmp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = tmp;
				}

			}
		}
		return numbers;
	}
}