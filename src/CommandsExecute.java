import DragonChar.DragonCollection;

import java.io.IOException;

public class CommandsExecute {
    public static DragonCollection ExecuteCommand(String command, DragonCollection Collection) throws IOException {
        switch (command){
            case "help":
                CommandList.helpCommand();
                break;
            case "info":
                String creationDate = ""+Collection.getCreationDate();
                String size = ""+Collection.getSize();
                CommandList.infoCommand(creationDate, size);
                break;
            case "show":
                CommandList.showCommand(Collection);
                break;
            case "insert":
                return CommandList.insertCommand(Collection);
            case "update":
                return CommandList.updateCommand(Collection);
            case "remove":
                return CommandList.remove_keyCommand(Collection);
            case "clear":
                return CommandList.clearCommand(Collection);
            case "save":
                CommandList.saveCommand( Collection );
                break;
            case "execute_script":
                String fileName = Console.InputFileName();
                CommandList.execute_scriptCommand(fileName, Collection);
                break;
            case "exit":
                CommandList.exitCommand();
                break;
            case "replace_if_greater":
                return CommandList.replace_if_greaterCommand(Collection);
            case "remove_greater":
                return CommandList.remove_greaterCommand(Collection);
            case "remove_lower":
                return CommandList.remove_lowerCommand(Collection);
            case "remove_all_by":
                return CommandList.remove_all_byCommand(Collection);
            case "filter_less_than_type":
                CommandList.filter_less_thanCommand(Collection);
                break;
            case "print_descending":
                CommandList.print_descendingCommand( Collection);
                break;

    }
    return Collection;
    }
}
