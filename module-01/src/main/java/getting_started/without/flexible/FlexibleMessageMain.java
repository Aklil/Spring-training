package getting_started.without.flexible;

public class FlexibleMessageMain {
    public static void main(String[] args) {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        MessageProvider provider = new SimpleMessageProvider();
        renderer.setMessageProvider(provider);
        renderer.render();
    }
}
