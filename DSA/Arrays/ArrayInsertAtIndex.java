package DSA.Arrays;

public class ArrayInsertAtIndex {
    // You need to insert the given element at the given index.
    // After inserting the elements at index, elements
    // from index onward should be shifted one position ahead
    // You may assume that the array already has sizeOfArray - 1
    // elements.
    public void insertAtIndex(int arr[],int sizeOfArray,int index,int element)
    {
        for(int i = 0; i < sizeOfArray; i++) {
            if(index == i) {
                int temp = arr[i];
                arr[i] = element;
                element = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 0};
        int sizeOfArray = 6;
        int index = 5;
        int element = 90;
        new ArrayInsertAtIndex().insertAtIndex(arr, sizeOfArray, index, element);
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
