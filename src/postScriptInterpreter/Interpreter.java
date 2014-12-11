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
     * @pre la variable commandsMap est initialis�e.
     * @post les commandes sont instanci�es et associ�es � leur repr�sentation textuelle.
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
     * @pre les Map commandsMap et definedConstantsMap sont initialis�es. La variable stack l'est �galement.
     * @post La chaine de caract�res commandString est interpr�t�e comme �tant une commande du mini langage PostScript.
     * Les token num�riques et boolean qu'elle contient sont ajout�s � la pile.
     * Les token textuels sont trait�s de mani�re diff�rente selon leur nature.
     * S'il s'agit d'une commande pr�sente dans la Map commandsMap, elle sera ex�cut�e.
     * S'il s'agit d'une constante pr�sente dans la Map definedConstantsMap, sa valeur associ�e sera ajout�e dans la pile.
     * S'il s'agit d'une chaine de carat�res qui n'est pr�sente dans aucune des deux map, elle est ajout�e telle quelle � la pile.
     * La valeur retourn�e est une chaine de caract�re contenant les r�sultats des commandes qui doivent �tre imprim�s dans le fichier le sortie. Cette chaine de carat�res peut �tre vide. Elle peut �galement contenir les messages d�taill�s les erreurs rencontr�es lors de l'ex�cution des commandes.
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
