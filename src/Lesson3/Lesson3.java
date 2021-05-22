package Lesson3;

import java.util.Arrays;

public class Lesson3
{
    public static void swapElements(int i, int j, Object[] array)
    {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main(String[] args)
    {
        Object [] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        swapElements(2,4, array);
        System.out.println(Arrays.toString(array));
    }
}
