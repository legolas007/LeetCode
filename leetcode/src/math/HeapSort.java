package math;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class HeapSort {
    private int[] array;
    private int currentIndex;
    private int maxSize;

    public HeapSort(int size) {
        maxSize = size;
        array = new int[maxSize];
        currentIndex = 0;
    }

    //插入数据项，并排好序
    public void insertSort(int[] source) {
        for (int aSource : source) {
            array[currentIndex] = aSource; //插入到节点尾
            tickedUp(currentIndex++); //向上重新排好序，使得满足堆的条件
        }
    }

    private void tickedUp(int index) {
        int parentIndex = (index - 1) / 2; //父节点的索引
        int temp = array[index]; //将新加的尾节点存在temp中
        while (index > 0 && array[parentIndex] < temp) {
            array[index] = array[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        array[index] = temp;
    }

    //取出最大值
    public int getMax() {
        int maxNum = array[0];
        array[0] = array[--currentIndex];
        trickleDown(0);
        return maxNum;
    }

    private void trickleDown(int index) {
        int top = array[index];
        int largeChildIndex;
        while (index < currentIndex / 2) { //while node has at least one child
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            //find larger child
            if (rightChildIndex < currentIndex &&  //rightChild exists?
                    array[leftChildIndex] < array[rightChildIndex]) {
                largeChildIndex = rightChildIndex;
            } else {
                largeChildIndex = leftChildIndex;
            }
            if (top >= array[largeChildIndex]) {
                break;
            }
            array[index] = array[largeChildIndex];
            index = largeChildIndex;
        }
        array[index] = top;
    }
}
