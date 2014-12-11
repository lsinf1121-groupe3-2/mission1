package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class ExchCommand implements ICommand {

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 2){
    		return "Exch needs 2 operands\n";
    	}
		try {
			String op1 = stack.pop();
			String op2 = stack.pop();
			stack.push(op1 );
			stack.push(op2);
		} catch (EmptyStackException e) {
        	return "Error pop(): Stack is empty\n";
		}
		return null;
	}

}
