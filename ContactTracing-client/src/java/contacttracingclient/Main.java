package contacttracingclient;

import RemoteBeans.clientDBboonRemote;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.ejb.EJB;

public class Main {
    @EJB private static clientDBboonRemote DBboon;
    //https://stackoverflow.com/questions/33367725/stateless-ejb-throwing-nullpointerexception-in-enterprise-application-client
    //""In the client container, effectively only the main class is eligible for injection""
    public static void main(String[] args) {
               
       View v = new View(DBboon);
    }
    
}