import DragonChar.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.TreeSet;


public class CommandList {

        public static void helpCommand (){
            System.out.println("help : вывести справку по доступным командам");
            System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
            System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
            System.out.println("insert null {element} : добавить новый элемент с заданным ключом");
            System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
            System.out.println("remove_key null : удалить элемент из коллекции по его ключу");
            System.out.println("clear : очистить коллекцию");
            System.out.println("save : сохранить коллекцию в файл");
            System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            System.out.println("exit : завершить программу (без сохранения в файл)");
            System.out.println("replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого");
            System.out.println("remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный");
            System.out.println("remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный");
            System.out.println("remove_all_by_age age : удалить из коллекции все элементы, значение поля age которого эквивалентно заданному");
            System.out.println("filter_less_than_type type : вывести элементы, значение поля type которых меньше заданного");
            System.out.println("print_descending : вывести элементы коллекции в порядке убывания");
        }
        public static void infoCommand (String CreationDate, String size){
            System.out.println("This is Hashtable collection");
            System.out.println("This collection create at " + CreationDate);
            System.out.println("This collection have " + size + " elements");

        }
    public static void showCommand (DragonCollection Collection){
            if (Collection.getSize()<1) System.out.println("Collection are empty");
        Enumeration<Integer> listKey = Collection.Enumeration();

        int Key = 0;
        while (listKey.hasMoreElements()){
            Key = listKey.nextElement();
                Dragon CurrentDragon = Collection.getDragon(Key);
                System.out.println("1.DragonID: "+ CurrentDragon.getId());
                System.out.println("2.Name: "+ CurrentDragon.getName());
                System.out.println("3.Coordinate ");
                System.out.println("X:" + CurrentDragon.getCoordinates().getX() + " Y: " + CurrentDragon.getCoordinates().getY());
                System.out.println("4.CreationDate: "+ CurrentDragon.getCreationDate());
                System.out.println("5.Age: "+ CurrentDragon.getAge());
                System.out.println("6.Description: " + CurrentDragon.getDescription());
                System.out.println("7.Weight: " + CurrentDragon.getWeight() );
                System.out.println("8.Type: "+ CurrentDragon.getType());
                System.out.println("9.Count of eyes: "+ CurrentDragon.getHead().getEyesCount());
                System.out.println("-------------------------------------------------------------");

            }

    }
    public static DragonCollection insertCommand (DragonCollection Collection) throws IOException {
    int Key =  Console.InputKey();
    Dragon emptyDragon = new Dragon("Unnamed",1,Long.valueOf(1),1,"This is empty dragon",1,"Fire",2);
    Dragon insertDragon = emptyDragon;

    Collection.putDragonToCollectionWithKey(insertDragon, Key);

    return Collection;
    }
    public static DragonCollection updateCommand (DragonCollection Collection) throws IOException {
        int Key =  Console.InputKey();
        String command = Console.Input("Enter a Attribut's name");
        switch (command){
            case "name":
                Collection.getDragon(Key).setName(Console.Input("Enter new name of dragon"));
                break;
                case "coordinates":
                    double x = Console.InputInt("Enter X");
                    long y = Long.valueOf(Console.Input("Enter Y"));
                    Coordinates newCoordinate = new Coordinates(x,y);
                Collection.getDragon(Key).setCoordinates(newCoordinate);
                break;
            case "age":
                Collection.getDragon(Key).setAge(Console.InputInt("Enter new age"));
                break;
            case "description":
                Collection.getDragon(Key).setDescription(Console.Input("Enter new description"));
                break;
            case "weight":
                Collection.getDragon(Key).setWeight(Console.InputInt("Enter new weight"));
            case "type":
                String type = Console.Input("Enter new type");
                switch (type){
                    case "Air":
                        Collection.getDragon(Key).setType(DragonType.AIR);
                        break;
                    case "Water":
                        Collection.getDragon(Key).setType(DragonType.WATER);
                        break;
                    case "Underground":
                        Collection.getDragon(Key).setType(DragonType.UNDERGROUND);
                        break;
                    case "Fire":
                        Collection.getDragon(Key).setType(DragonType.FIRE);
                        break;
                    default:
                        break;
                }
            case "head":
                DragonHead newHead = new DragonHead(Console.InputInt("Enter count of eyes"));
                Collection.getDragon(Key).setHead(newHead);
            default:
                System.out.println("Wrong Input");
                break;
        }
        return Collection;



    }
    public static DragonCollection remove_keyCommand (DragonCollection Collection) throws IOException {
            int Key = Console.InputKey();
            Collection.remove(Key);
            return Collection;
    }
    public static DragonCollection clearCommand (DragonCollection Collection){
            Collection.clear();
            return Collection;
    }
    public static void saveCommand (DragonCollection Collection) throws IOException {
        CSV_Parcer.saveDragonCSV(Collection);

    }

    public static void execute_scriptCommand (String FileName, DragonCollection Collection) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);

        int i;

        String word = "";

        while((i = bufferedInputStream.read())!= -1){
            if  (i!=13){
                word = word + (char)i;
            }
            else {
                System.out.println(word);
                CommandsExecute.ExecuteCommand(word, Collection);
            }

        }
        System.out.println("");


    }
    public static void exitCommand (){
        System.exit(0);
    }
    public static DragonCollection replace_if_greaterCommand (DragonCollection Collection) throws IOException {
            int minAge = Console.InputInt("Enter minimal Age");
            
            
            
            
            
            Enumeration<Integer> listKey = Collection.Enumeration();

            int Key = 0;
            while (listKey.hasMoreElements()){
                Key = listKey.nextElement();
                if (minAge > Collection.getDragon(Key).getAge()) Collection.getDragon(Key).setAge(minAge);
            }
            return Collection;

    }
    public static DragonCollection remove_greaterCommand (DragonCollection Collection) throws IOException{
        int maxKey = Console.InputInt("Enter maximal Key");
        Enumeration<Integer> listKey = Collection.Enumeration();

        int Key = 0;
        while (listKey.hasMoreElements()){
            Key = listKey.nextElement();
            if (maxKey < Key) Collection.remove(Key);
        }
        return Collection;
    }
    public static DragonCollection remove_lowerCommand (DragonCollection Collection) throws IOException{
        int minKey = Console.InputInt("Enter minimal Key");
        Enumeration<Integer> listKey = Collection.Enumeration();

        int Key = 0;
        while (listKey.hasMoreElements()){
            Key = listKey.nextElement();
            if (minKey > Key) Collection.remove(Key);
        }
        return Collection;
    }
    public static DragonCollection remove_all_byCommand (DragonCollection Collection) throws IOException{
        int remAge = Console.InputInt("Enter Age for removing");
        Enumeration<Integer> listKey = Collection.Enumeration();

        int Key = 0;
        while (listKey.hasMoreElements()){
            Key = listKey.nextElement();
            if (remAge == Collection.getDragon(Key).getAge()) Collection.remove(Key);
        }
        return Collection;
    }
    public static void filter_less_thanCommand (DragonCollection Collection) throws IOException {


        Enumeration<Integer> listKey = Collection.Enumeration();

        String TypeName = Console.Input("Enter a TypeName");
        String TypeDragon;

        int Key = 0;
        while (listKey.hasMoreElements()){
            Key = listKey.nextElement();

            Dragon CurrentDragon = Collection.getDragon(Key);
            TypeDragon = ""+CurrentDragon.getType();

            if (TypeName.equals(TypeDragon)){

            System.out.println("1.DragonID: "+ CurrentDragon.getId());
            System.out.println("2.Name: "+ CurrentDragon.getName());
            System.out.println("3.Coordinate ");
            System.out.println("X:" + CurrentDragon.getCoordinates().getX() + " Y: " + CurrentDragon.getCoordinates().getY());
            System.out.println("4.CreationDate: "+ CurrentDragon.getCreationDate());
            System.out.println("5.Age: "+ CurrentDragon.getAge());
            System.out.println("6.Description: " + CurrentDragon.getDescription());
            System.out.println("7.Weight: " + CurrentDragon.getWeight() );
            System.out.println("8.Type: "+ CurrentDragon.getType());
            System.out.println("9.Count of eyes: "+ CurrentDragon.getHead().getEyesCount());
            System.out.println("-------------------------------------------------------------");}

        }
    }
    public static void print_descendingCommand (DragonCollection Collection){
        System.out.println("In descending order of age");
        int maxAge = 0;
        int originSize = Collection.getSize();
        int currentKey = 0;
        TreeSet <Dragon> DragonSet = new TreeSet<Dragon>();


        for (int i = 1; i<=originSize; i++) {
            maxAge = 0;

            Enumeration<Integer> listKey = Collection.Enumeration();
            int Key = 0;
            while (listKey.hasMoreElements()) {
                Key = listKey.nextElement();
                Dragon CurrentDragon = Collection.getDragon(Key);
                CurrentDragon.compareTo(Collection.getDragon(Key));
                DragonSet.add(CurrentDragon);

                if (maxAge<CurrentDragon.getAge()) {
                    maxAge = (int) CurrentDragon.getAge();
                    currentKey = Key;
                }
            }
            System.out.println("1.DragonID: " + Collection.getDragon(currentKey).getId());
            System.out.println("2.Name: " + Collection.getDragon(currentKey).getName());
            System.out.println("3.Coordinate ");
            System.out.println("X:" + Collection.getDragon(currentKey).getCoordinates().getX() + " Y: " + Collection.getDragon(currentKey).getCoordinates().getY());
            System.out.println("4.CreationDate: " + Collection.getDragon(currentKey).getCreationDate());
            System.out.println("5.Age: " + Collection.getDragon(currentKey).getAge());
            System.out.println("6.Description: " + Collection.getDragon(currentKey).getDescription());
            System.out.println("7.Weight: " + Collection.getDragon(currentKey).getWeight());
            System.out.println("8.Type: " + Collection.getDragon(currentKey).getType());
            System.out.println("9.Count of eyes: " + Collection.getDragon(currentKey).getHead().getEyesCount());
            System.out.println("-------------------------------------------------------------");

            Collection.remove(currentKey);
        }

    }


}
