import java.io.*;
import java.security.Key;
import java.util.Scanner;

public class Console {
    public static String InputCommand() throws IOException {
        System.out.println("Please, Enter a command");
        Scanner in = new Scanner(System.in);
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String command = bufferedReader.readLine();
        return command;
    }


    public static String InputFileName() throws IOException {
        System.out.println("Please, Enter a filename");
        Scanner in = new Scanner(System.in);
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String command = bufferedReader.readLine();
        return command;
    }

    public static int InputKey() throws IOException {
        System.out.println("Please, Enter a Key");
        Scanner in = new Scanner(System.in);
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String command = bufferedReader.readLine();
        int Key ;
        try {
            Key = Integer.parseInt(command);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Please, Enter a NUMBER");
            Key = InputKey();
        }

        return Key;
    }

    public static int InputInt(String message) throws IOException {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String command = bufferedReader.readLine();
        int Key ;
        try {
            Key = Integer.parseInt(command);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Please, Enter a NUMBER");
            Key = InputInt(message);
        }

        return Key;
    }

    public static String InputAttribute(String AttributesName) throws IOException {
        System.out.println("Please, Enter a "+AttributesName);
        Scanner in = new Scanner(System.in);
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String string = bufferedReader.readLine();
        return string;
    }


    public static String Input(String massege) throws IOException {
        System.out.println(massege);
        Scanner in = new Scanner(System.in);
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String command = bufferedReader.readLine();
        return command;
}}
