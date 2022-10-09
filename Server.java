import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Server {

    public static void RunServer(int port) throws IOException {


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port=8000;
        int count=0;
        ServerSocket serverSocket=new ServerSocket(port);

        while (true){
            System.out.println("Server is start");
            Socket clietnSocket = serverSocket.accept();

            System.out.println("Клиент подключен "+(++count)); // клиент подключился

            //=============Получение коллекции типа Person от клиента===============
            ObjectInputStream input = new ObjectInputStream(clietnSocket.getInputStream());
            var persons = (ArrayList<Person>) input.readObject();

            //=============Вывод в консоль (на сервере) полученной колекции с использованием Итератора===============
            Iterator iterator = persons.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }

            //=============Отпрака клиентку отсортированной (по возрасту) колекции через компаратор===============
            ObjectOutputStream output= new ObjectOutputStream(clietnSocket.getOutputStream());
            Collections.sort(persons);
            output.writeObject(persons);


            clietnSocket.close();
        }
    }
}
