package getting_started.without;

/**
 *  Externalize message content
 *  Read it in at run time
 *  === Can change message without changing code
 */
public class MessageFromCommandLine {
    public static void main(String[] args) {
        if(args.length > 0){
           for(var arg : args){
               System.out.println(arg);
           }
        }
        else {
            System.out.println("Hello World!");
        }
    }
}

/**
 * Problem
 *  the component responsible for rendering the message is also responsible for obtaining the message
 *  Tight coupling - main both obtains and renders message
 */

/**
 * Refactor
 *  Rendering and message retrieval logic in to separate components
 *  More refactoring that scales
 *      Let components implement and define interdependence between them
 *
 */
