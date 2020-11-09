package getting_started.without.flexible;

/**
 * components implement render() method to render as however they want
 * Delegate message retrieval to providers
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
