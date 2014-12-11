package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class PopCommand implements ICommand{

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 1){
    		return "Pop needs 1 operand\n";
    	}
		try {
			stack.pop();
		} catch (EmptyStackException e) {
        	return "Error pop(): Stack is empty\n";
		}
		return null;
	}

}
