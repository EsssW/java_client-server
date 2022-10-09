import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    private static String host="127.0.0.1";
    private static int port=8000;
    private static int personCount=20;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket=new Socket(host, port);

        ArrayList<Person> personList= GeneratePersons(personCount);// формирование списка работникв

        //=============Вывод коллекции как есть===============
        System.out.println("\n======Коллекция как есть=======");
        PrintPersonCollections(personList);

        //=============Передача серверу коллекции===============
        var output = new ObjectOutputStream(clientSocket.getOutputStream());
        output.writeObject(personList);
        output.flush();

        //=============Получение от сервера коллекции и печать===============
        ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
        var sortedPersonList = (ArrayList<Person>) input.readObject();
        System.out.println("\n======Коллекция после сортирови на сервере=======");
        PrintPersonCollections(sortedPersonList);

        // СОРТИРОВКА ПО ОПЫТУ
        personList.sort(Comparator.comparing(Person::getExperience));
        System.out.println("\n======Сортировка по Опыту=======");
        PrintPersonCollections(personList);
        //СОРТИРОВКА ПО ИМЕНИ
        personList.sort(Comparator.comparing(Person::getName));
        System.out.println("\n======Сортировка по Имени=======");
        PrintPersonCollections(personList);
        //СОРТИРОВКА ПО ПРОДЛОЖИТ-И ОТПУСКА
        personList.sort(Comparator.comparing(Person::getHoliday));
        System.out.println("\n======Сортировка по Продолжительности отпуска=======");
        PrintPersonCollections(personList);

        //Отчеты
        System.out.println("\n======Самый молодой Сотрудник=======");
        System.out.println(GetYoungestPerson(personList).toString());

        System.out.println("\n======Самый взрослый Сотрудник=======");
        System.out.println(GetOldestPerson(personList).toString());

        System.out.println("\n======Мало работающий Сотрудник=======");
        System.out.println(GetSmallWorkingPerson(personList).toString());

        System.out.println("\n======Долго работающий Сотрудник=======");
        System.out.println(GetLongWorkingPerson(personList).toString());

        input.close();
        output.close();
        clientSocket.close();
    }
    public static int GetRandomInt(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static void PrintPersonCollections(ArrayList<Person> personList){
        Iterator iterator3 = personList.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next().toString());
        }
    }
    public  static ArrayList<Person> GeneratePersons(int personCount){
        ArrayList<Person> personList=new ArrayList<>();
        for (int i=0; i<personCount;i+=2){
            personList.add(new Ispolnitel(
                    0+i,
                    "ФИО"+ i,
                    "Исполнитель "+i,
                    GetRandomInt(12,65),
                    GetRandomInt(1,15),
                    GetRandomInt(15000,50000),
                    GetRandomInt(3,40),
                    GetRandomInt(0,100)
            ));
            personList.add(new Rukovoditel(
                    1+i,
                    "ФИО"+ (1+i),
                    "Руководитель "+(i+1),
                    GetRandomInt(12,65),
                    GetRandomInt(1,120),
                    GetRandomInt(25000,100000),
                    GetRandomInt(3,40),
                    GetRandomInt(0,100)
            ));
        }
        return personList;
    }

    public static int[] GenerateIndexToRemovePersons(int indexCount, int personCount){
        int[] randindexArr=new int[indexCount];
        for (int i = 0; i <indexCount; i++) {
            randindexArr[i]=GetRandomInt(0,personCount);
        }
        return randindexArr;
    }

    public static boolean RemovePersonByIndex(ArrayList<Person> personList, int[] index){
        if(personList.size()<index.length)
            return false;
        for (int i = 0; i < index.length; i++) {
            if (personList.get(i).index == index[i]){
                personList.remove(i);
            }
        }
        return true;
    }
    public static Person GetYoungestPerson(ArrayList<Person> personList){
        personList.sort(Comparator.comparing(Person::getAge));
        return personList.get(0);
    }
    public static Person GetOldestPerson(ArrayList<Person> personList){
        personList.sort(Comparator.comparing(Person::getAge));
        return personList.get(personList.size()-1);
    }
    public static Person GetSmallWorkingPerson(ArrayList<Person> personList){
        personList.sort(Comparator.comparing(Person::getExperience));
        return personList.get(0);
    }
    public static Person GetLongWorkingPerson(ArrayList<Person> personList){
        personList.sort(Comparator.comparing(Person::getExperience));
        return personList.get(personList.size()-1);
    }
}
