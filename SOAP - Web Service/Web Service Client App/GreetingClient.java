package client;

import java.net.URL;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class GreetingClient {

    public static void main(String[] args) throws Exception {

        URL wsdlUrl = new URL("http://localhost:8080/webservice/greeting?wsdl");

        QName qname = new QName("http://jaxwsservice.com/",
                "MyWebServiceImplementationService");

        Service service = Service.create(wsdlUrl, qname);

        MyWebServiceInterface myService = service.getPort(MyWebServiceInterface.class);

        System.out.println(myService.myGreetingMessage("Alice"));

    }
}
