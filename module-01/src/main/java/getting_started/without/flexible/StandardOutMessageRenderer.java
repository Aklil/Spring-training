package getting_started.without.flexible;

public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw  new RuntimeException("You must set the property messageProvider of class:"
                    + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());  // output to standard out
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}

/**
 * Problem:
 *  Changing the implementation of either the MessageRenderer or MessageProvider interface means a change to the code
 * Solution:
 *  Use simple factory - using the factory design pattern
 */
