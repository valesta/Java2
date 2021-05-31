package Lesson5;

import java.io.*;
import java.util.ArrayList;

public class AppData
{
    private String[] header;
    private Integer[][] data;

    public AppData()
    {
        header = new String[]{"value1", "value2", "value3"};
        data = new Integer[][]{{11, 22, 33}, {44, 55, 66}, {77, 88, 99}};
    }

    public String[] getHeader()
    {
        return header;
    }

    public Integer[][] getData()
    {
        return data;
    }

    public void save(String fileName)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            writer.write(rowToString(header));

            for (Integer[] array : data)
            {
                writer.write(rowToString(array));
            }
            writer.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private <T> String rowToString(T[] row)
    {
        String result = "";

        for (int i = 0; i < row.length; i++)
        {
            if (i < row.length - 1)
            {
                result = result + row[i] + ";";
            }
            else
            {
                result = result + row[i];
            }
        }
        result += "\n";
        return result;
    }

    public void load(String fileName)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            header = reader.readLine().split(";");
            String line;
            ArrayList<Integer[]> arrayList = new ArrayList<>();

            while ((line = reader.readLine()) != null)
            {
                String[] arr = line.split(";");
                Integer[] intArr = new Integer[arr.length];

                for (int i = 0; i < arr.length; i++)
                {
                    intArr[i] = Integer.parseInt(arr[i]);
                }
                arrayList.add(intArr);
            }
            data = arrayList.toArray(new Integer[][]{});
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
