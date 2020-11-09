package getting_started.without.flexible.factory;

import getting_started.without.flexible.MessageProvider;
import getting_started.without.flexible.MessageRenderer;

import java.util.Properties;

/**
 * Simple factory class
 *      Reads the implementation class names from a properties file and instantiates them on behalf of the application
 */
public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private Properties props;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        props = new Properties();

        try{
            // Reads a property list (key and element pairs) from the input byte stream
            props.load(this.getClass().getResourceAsStream("/message-support-factory.properties"));

            var renderClass = props.getProperty("renderer.class");
            var providerClass = props.getProperty("provider.class");

            // create renderer object
            renderer = (MessageRenderer) Class.forName(renderClass).getDeclaredConstructor().newInstance();

            // create provider object
            provider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    // Making the factory singleton
    public static MessageSupportFactory getInstance(){
        if(instance == null)
            instance = new MessageSupportFactory();

        return instance;
    }

    public MessageRenderer getMessageRenderer() { return renderer;}
    public MessageProvider getMessageProvider() { return provider;}

}
