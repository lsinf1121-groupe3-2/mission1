package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class MulCommand implements ICommand {

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 2){
    		return "Mul needs 2 operands\n";
    	}
		try {
			float op1 = Float.parseFloat(stack.pop());
			float op2 = Float.parseFloat(stack.pop());
			float result = op1 * op2;
			stack.push("" + result);
		} catch (NumberFormatException e) {
			return "Mul needs 2 floats\n";
		} catch (EmptyStackException e) {
        	return "Error pop(): Stack is empty\n";
		}
		return null;
	}

}
