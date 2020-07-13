package customApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    @Test
    void should_add_one_item_to_list() {

        //Arrange
        CustomArrayList<Integer> list = new CustomArrayList<>();
        //Act
        list.add(10);

        int expected_value = list.get(0);
        int expected_size = list.getSize();

        //Assert
       assertEquals(10,expected_value);
       assertEquals(1,expected_size);



    }

    @Test
    void should_add_100000_items_to_list(){

        //Arrange
        CustomArrayList<Integer> list = new CustomArrayList<>();

        for(int i = 1; i <= 100000; i++){
            list.add(i);
        }

        int expected_size = list.getSize();

        for(int i = 0 ; i < 99999; i++){
            assertEquals(i+1,list.get(i));
        }

        assertEquals(100000,expected_size);


    }

    @Test
    void should_insert_item_in_list(){
        //Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add(0,"Norway");

        String expected_value = "Norway";

        assertEquals(expected_value,list.get(0));


    }

    @Test
    void should_insert_item_inbetween_list(){
        //Arrange
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Norway");
        list.add("India");
        list.add(1,"Spain");


        String expected_value = "Spain";
        int expected_size = 3;
        String expected_shifted_value = "India";


        assertEquals(expected_value,list.get(1));
        assertEquals(expected_size,list.getSize());
        assertEquals(expected_shifted_value,list.get(2));


    }


    @Test
    void should_insert_item_inbetween_list_of_10(){
        //Arrange
        CustomArrayList<String> list = new CustomArrayList<>();


        list.add("Norway");
        list.add("India");
        list.add("Sweden");
        list.add("Ireland");
        list.add("Denmark");
        list.add("Switzerland");
        list.add("Italy");
        list.add("Greece");
        list.add("Croatia");
        list.add("Britain");

        list.add(9,"USA");



        String expected_value = "USA";
        int expected_size = 11;
        String expected_shifted_value = "Britain";


        for(int i = 0; i < list.getSize(); i++){
            System.out.println(list.get(i));
        }



        assertEquals(expected_value,list.get(9));
        assertEquals(expected_size,list.getSize());
        assertEquals(expected_shifted_value,list.get(10));


    }


    @Test
    void should_shift_items_added_in_same_index(){
        //Arrange
        CustomArrayList<Integer> list = new CustomArrayList<>();

       //Act
        list.add(0,10);
        list.add(0,100);
        list.add(0,150);

        assertEquals(150, list.get(0));
        assertEquals(100, list.get(1));
        assertEquals(10, list.get(2));


    }

    @Test
    void should_remove_first_item_from_list(){


        CustomArrayList<Integer> list = new CustomArrayList<>();

        //Act
        list.add(10);
        list.add(100);
        list.add(150);

        int actual = list.remove(0);


        assertEquals(10, actual);
        assertEquals(100, list.get(0));
        assertEquals(150, list.get(1));
        assertEquals(2, list.getSize());



    }


    @Test
    void should_remove_last_item_from_list(){


        CustomArrayList<Integer> list = new CustomArrayList<>();

        //Act
        list.add(10);
        list.add(100);
        list.add(150);

        int actual = list.remove(2);


        assertEquals(150, actual);
        assertEquals(10, list.get(0));
        assertEquals(100, list.get(1));
        assertEquals(2, list.getSize());



    }


    @Test
    void should_remove_middle_item_from_list(){


        CustomArrayList<Integer> list = new CustomArrayList<>();

        //Act
        list.add(10);
        list.add(100);
        list.add(150);

        int actual = list.remove(1);


        assertEquals(100, actual);
        assertEquals(10, list.get(0));
        assertEquals(150, list.get(1));
        assertEquals(2, list.getSize());



    }
}