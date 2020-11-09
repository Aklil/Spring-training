package getting_started.without.flexible.factory;

import getting_started.without.flexible.MessageProvider;
import getting_started.without.flexible.MessageRenderer;

public class FlexibleWithFactoryMain {
    /**
     * Doesn't know the concrete implementations of MessageRenderers and MessageProviders
     *
     *
     */
    public static void main(String[] args) {
        MessageRenderer renderer = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider provider = MessageSupportFactory.getInstance().getMessageProvider();

        renderer.setMessageProvider(provider);
        renderer.render();
    }
}

/**
 * PROBLEM:
 *  a lot of glue code to piece a simple application together, while at the same time keeping the components loosely coupled
 *  MessageRenderer impl still needs an instance of MessageProvider manually
 *
 * SOLUTION:
 *  lets use Spring
 */
