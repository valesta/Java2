package Lesson2;

public class Main
{
    public static void main(String[] args)
    {
        String[][] array = {{"1","2","3","4"},{"5","6","7","8"},{"9","s","10","11"},{"12","13","14","15"}};
        System.out.println(converting(array));
    }

    public static int converting(String[][] array)
    {
        if (array.length != 4)
        {
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i].length != 4)
            {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < array[i].length; j++)
            {
                try
                {
                    sum += Integer.parseInt(array[i][j]);

                }
                catch (NumberFormatException e)
                {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}
