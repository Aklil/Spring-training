package getting_started.without.flexible;

public class SimpleMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
