import DragonChar.Dragon;
import DragonChar.DragonCollection;

import java.io.FileReader;
import java.util.Arrays;
import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;

public class CSV_Parcer {

    public static void saveDragonCSV(DragonCollection Collection) throws IOException {
        OutputStream saveFile = new FileOutputStream("D:\\saveFile.csv");
        OutputStreamWriter save = new OutputStreamWriter(saveFile);

        Enumeration<Integer> listKey = Collection.Enumeration();

        int Key = 0;
        while (listKey.hasMoreElements()){
            Key = listKey.nextElement();
            String name = Collection.getDragon(Key).getName();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);

            name = "" + Collection.getDragon(Key).getCoordinates().getX();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);

            name = "" + Collection.getDragon(Key).getCoordinates().getY();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);

            name = "" + Collection.getDragon(Key).getAge();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);

            name = "" + Collection.getDragon(Key).getDescription();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);

            name = "" + Collection.getDragon(Key).getWeight();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);

            name = "" + Collection.getDragon(Key).getType();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);

            name = "" + Collection.getDragon(Key).getHead().getEyesCount();

            for (int i = 0; i< name.length(); i++){
                char c = name.charAt(i);
                int outNum = c;
                save.write(outNum);
            }
            save.write(13);


            save.flush();

        }

    }


    public static DragonCollection readDragonCSV(String filename) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 2000);

        DragonCollection newDragonColletion = new DragonCollection();

        int i;
        int Counter = 1;

        while(true){



        String word = "";

        String name = "";

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=44){
                word = word + (char)i;
            }
            else {
                name = word;
                word = "";
                System.out.println(name+" get a name");

                break;
            }
        }

        double x = 2;

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=44){
                word = word + (char)i;
            }
            else {
                x = Integer.parseInt(word);
                word = "";
                System.out.println(x+" get a x Coordinate");

                break;
            }
        }

        Long y = Long.valueOf(2);

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=44){
                word = word + (char)i;
            }
            else {
                y = Long.valueOf(Integer.parseInt(word));
                word = "";
                System.out.println(y +" get a y Coordinate");

                break;
            }
        }

        long age = 1;

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=44){
                word = word + (char)i;
            }
            else {
                age = Long.valueOf(Integer.parseInt(word));
                word = "";
                System.out.println(name + " lived for "+ age +" years ");

                break;
            }
        }

        String description = "";
        while((i = bufferedInputStream.read())!= -1){
            if  (i!=44){
                word = word + (char)i;
            }
            else {
                description = word;
                word = "";
                System.out.println("This dragon ... " + description);

                break;
            }
        }


        int weight = 1;

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=44){
                word = word + (char)i;
            }
            else {
                weight = Integer.parseInt(word);
                word = "";
                System.out.println("This dragon have  weight equal " + weight + "kg");

                break;
            }
        }

        String Type = "Fire";

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=44){
                word = word + (char)i;
            }
            else {
                Type = word;
                word = "";
                System.out.println("This is "+ Type + " dragon");

                break;
            }
        }

        float eyes_count = 2;

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=13){
                word = word + (char)i;
            }
            else {
                eyes_count = Integer.parseInt(word);
                word = "";
                System.out.println("This dragon have a "+ eyes_count + " eyes" );

                break;
            }
        }

            if ((i = bufferedInputStream.read())== -1) break;


        Dragon newDragon = new Dragon(name, x, y, age, description, weight, Type, eyes_count);
        newDragonColletion.putDragonToCollection(newDragon);

        Counter++;}



        return newDragonColletion;

    }

}
