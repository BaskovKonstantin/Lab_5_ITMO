import DragonChar.DragonCollection;

import java.io.*;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws IOException {
            System.out.println("Welcome console appliaction for Lab_5");
            DragonCollection Collection = new DragonCollection();

            try {
                Collection = CSV_Parcer.readDragonCSV(args[0]);
            }
            catch ( IOException e){
                System.out.println("Something wrong with starFile");
            }

            while (true){
                String command = Console.InputCommand();
                Collection = CommandsExecute.ExecuteCommand(command, Collection);
                }
            }
}
