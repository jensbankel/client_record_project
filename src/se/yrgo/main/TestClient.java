package se.yrgo.main;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import se.yrgo.record.Record;

public class TestClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient(); 
        
//        WebTarget target = client.target
//                ("http://localhost:8080/RecordManagement/webservice/records/1");
//        Invocation invocation = target.request().buildGet();
//        Response response = invocation.invoke();
                
//          Response response = client.target("http://localhost:8080/RecordManagement/webservice/records/1") 
//                                    .request()
//                                    .buildGet()
//                                    .invoke();
          
//          Record rec = response.readEntity(Record.class);
//          System.out.println(rec);
      
//          System.out.println(response.readEntity(String.class));
      
          Response response = client.target("http://localhost:8080/RecordManagement/webservice/records")
                                    .request()
                                    .buildGet()
                                    .invoke();
          
//          System.out.println(response.readEntity(String.class));
          
          List<Record> records = response.readEntity(new GenericType<List<Record>>() {});
          
          for (Record r : records) {
              System.out.println(r);
          }
          
         
    }   
}


