package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;


/**
 * Implementation of the interface : ICommand
 */
public class PstackCommand implements ICommand{

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.isEmpty()){
    		return "Empty Stack\n";
    	}
		return stack.toString();
	}

}
