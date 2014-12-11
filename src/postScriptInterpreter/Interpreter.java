/**
 * This package contains the logic needed to interprete a PostScript command.
 */
package postScriptInterpreter;

import java.util.HashMap;
import java.util.Map;

import postScriptInterpreter.command.AddCommand;
import postScriptInterpreter.command.DefCommand;
import postScriptInterpreter.command.DivCommand;
import postScriptInterpreter.command.DupCommand;
import postScriptInterpreter.command.EqCommand;
import postScriptInterpreter.command.ExchCommand;
import postScriptInterpreter.command.MulCommand;
import postScriptInterpreter.command.NeCommand;
import postScriptInterpreter.command.PopCommand;
import postScriptInterpreter.command.PstackCommand;
import postScriptInterpreter.command.SubCommand;

/**
 * This class is able to interpret a postScript command.
 * @author Tanguy
 */
public class Interpreter {
    IStack<String> stack;
    Map<String, Float> definedConstantsMap;
    Map<String, ICommand> commandsMap;
    
    /**
     * Default constructor.
     * Initialize the stack, the constants map and the commands map.
     */
    public Interpreter(){
        this.stack = new Stack(); //TODO class Stack that implements IStack interface
        this.definedConstantsMap = new HashMap<>();
        this.commandsMap = new HashMap<>();
        this.initializeCommands();
    }
    
    /**
     * @pre la variable commandsMap est initialisée.
     * @post les commandes sont instanciées et associées à leur représentation textuelle.
     * Cette association est maintenue dans la Map commandsMap.
     */
    private void initializeCommands(){
        this.commandsMap.put("add", new AddCommand());
        this.commandsMap.put("pstack", new PstackCommand());
        this.commandsMap.put("sub", new SubCommand());
        this.commandsMap.put("mul", new MulCommand());
        this.commandsMap.put("div", new DivCommand());
        this.commandsMap.put("dup", new DupCommand());
        this.commandsMap.put("exch", new ExchCommand());
        this.commandsMap.put("eq", new EqCommand());
        this.commandsMap.put("ne", new NeCommand());
        this.commandsMap.put("def", new DefCommand());
        this.commandsMap.put("pop", new PopCommand());
    }
    
    /**
     * Interprete a mini PostScript command an return a String that is the result of the command if needed.
     * @param commandString command to interprete as a mini PostScript command.
     * @return result of the command as a string or null if no result is send by the command.
     */
    /**
     * @pre les Map commandsMap et definedConstantsMap sont initialisées. La variable stack l'est également.
     * @post La chaine de caractères commandString est interprétée comme étant une commande du mini langage PostScript.
     * Les token numériques et boolean qu'elle contient sont ajoutés à la pile.
     * Les token textuels sont traités de manière différente selon leur nature.
     * S'il s'agit d'une commande présente dans la Map commandsMap, elle sera exécutée.
     * S'il s'agit d'une constante présente dans la Map definedConstantsMap, sa valeur associée sera ajoutée dans la pile.
     * S'il s'agit d'une chaine de caratères qui n'est présente dans aucune des deux map, elle est ajoutée telle quelle à la pile.
     * La valeur retournée est une chaine de caractère contenant les résultats des commandes qui doivent être imprimés dans le fichier le sortie. Cette chaine de caratères peut être vide. Elle peut également contenir les messages détaillés les erreurs rencontrées lors de l'exécution des commandes.
     */
    public String interprete(String commandString){
        //TODO: parse the command
    	String[] commands = commandString.split(" ");
        //TODO: for each "word" of the line, check if this is a command
        // if command, execute it
        // else it is an operande, add it to stack
    	String result = "";
        for (String token : commands) {
	        ICommand command = commandsMap.get(token);
	        if(command==null){
	            //TODO: add operandes to the stack
	        	Float constant = definedConstantsMap.get(token);
	        	if(constant != null){
	        		stack.push(constant.toString());
	        	}
	        	else {
	        		try {
	        			float tokenFloat = Float.parseFloat(token);
	        			stack.push("" + tokenFloat);
					} catch (Exception e) {
		        		stack.push(token);
					} 
	        	}
	        }
	        else {
	            String commandResult = command.execute(stack, definedConstantsMap);
	            if(commandResult != null && !commandResult.isEmpty())
	            	result += commandResult;
	        }
        }
        return result;
    }
    
}
