package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class DefCommand implements ICommand{

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 2){
    		return "Def needs 2 operands\n";
    	}
		try {
			float op1 = Float.parseFloat(stack.pop());
			String op2 = (stack.pop());
			if(op2.substring(0, 1).equals("/")) {
				definedConstantsMap.put(op2.substring(1), op1);
			} else {
				return "Constant must be like /constant\n";
			}
		} catch (NumberFormatException e) {
			return "Def need /constant float\n";
		} catch (EmptyStackException e) {
        	return "Error pop(): Stack is empty\n";
		}
		return null;
	}

}
