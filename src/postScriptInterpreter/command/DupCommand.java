package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class DupCommand implements ICommand {

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 1){
    		return "Dup needs 1 operand\n";
    	}
		try {
			float op = Float.parseFloat(stack.pop());
			stack.push("" + op);
			stack.push("" + op);
		} catch (NumberFormatException e) {
			return "Dup needs a float\n";
		} catch (EmptyStackException e) {
        	return "Error pop(): Stack is empty\n";
		}
		return null;
	}

}
