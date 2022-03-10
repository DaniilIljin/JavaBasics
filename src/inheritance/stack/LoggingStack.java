package inheritance.stack;

import java.util.Stack;

public class LoggingStack extends Stack<Integer> {
    @Override
    public Integer push(Integer item) {
        System.out.println(item + " :was pushed to Loggingstack");
        return super.push(item);
    }

    @Override
    public Integer pop() {
        Integer popped = super.pop();
        System.out.println(popped + " :was popped from Loggingstack");
        return popped;
    }

    public void pushAll(Integer... numbers){
        for (Integer number : numbers) {
            push(number);
        }
    }
}
