import DragonChar.DragonCollection;

import java.io.IOException;

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
                try {
                String command = Console.InputCommand();
                if (command == null) {
                    System.out.println("Bad command");
                    break;
                }
                Collection = CommandsExecute.ExecuteCommand(command, Collection);
                }
                catch ( Exception exc){
                    System.out.println("Something wrong");
                }
                }
            }
}
