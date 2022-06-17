
package client;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MyGreetingMessageResponse_QNAME = new QName("http://jaxwsservice.com/", "myGreetingMessageResponse");
    private final static QName _MyGreetingMessage_QNAME = new QName("http://jaxwsservice.com/", "myGreetingMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MyGreetingMessage }
     * 
     */
    public MyGreetingMessage createMyGreetingMessage() {
        return new MyGreetingMessage();
    }

    /**
     * Create an instance of {@link MyGreetingMessageResponse }
     * 
     */
    public MyGreetingMessageResponse createMyGreetingMessageResponse() {
        return new MyGreetingMessageResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyGreetingMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxwsservice.com/", name = "myGreetingMessageResponse")
    public JAXBElement<MyGreetingMessageResponse> createMyGreetingMessageResponse(MyGreetingMessageResponse value) {
        return new JAXBElement<MyGreetingMessageResponse>(_MyGreetingMessageResponse_QNAME, MyGreetingMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyGreetingMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxwsservice.com/", name = "myGreetingMessage")
    public JAXBElement<MyGreetingMessage> createMyGreetingMessage(MyGreetingMessage value) {
        return new JAXBElement<MyGreetingMessage>(_MyGreetingMessage_QNAME, MyGreetingMessage.class, null, value);
    }

}
