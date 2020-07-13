package customApp;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    Object[] items = new Object[10];
    private int size = 0;

    @Override
    public boolean add(T item) {
        if (size == items.length) {
            expandArray(items);
        }
        items[size] = item;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("The Index is out of bound");
        }

        if (size == items.length) {
            expandArray(items);
        }

        if (items[index] != null) {


            Object[] tempArray = Arrays.copyOfRange(items, index, size);

            items[index] = item;
            size++;

            for (int i = 0; i < tempArray.length; i++) {
                index++;
                items[index] = tempArray[i];
            }


        } else {
            items[index] = item;
            size++;
        }


        return true;


    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) {
        return (T) items[index];
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {

        T returnVal = null;

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("The Index is out of bound");
        }

        if(items[index]!=null){
            returnVal = (T)items[index];

            if(index != size-1) {
                Object[] tempArray = Arrays.copyOfRange(items, index + 1, size);


                size--;

                for (int i = 0; i < tempArray.length; i++) {
                    items[index] = tempArray[i];
                    index++;
                }
            }
            else{
                size--;
            }



        }


        return returnVal;
    }

    private void expandArray(Object[] inputArray) {
        Object[] resizedArray = new Object[inputArray.length * 2];

        for (int i = 0; i < inputArray.length; i++) {
            resizedArray[i] = inputArray[i];
        }
        items = resizedArray;
    }


}
