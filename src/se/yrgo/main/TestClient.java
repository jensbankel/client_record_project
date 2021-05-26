package se.yrgo.main;

/**
 * @author jmlb
 */

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import se.yrgo.record.Record;


/**
 * @author Naoya Irikura
 * @author Alexander Gabay
 * @author Jens Bankel
 *
 * A client for testing connecting to the server from an external client. Testing
 * all methods implemented in the server
 * 
 */
public class TestClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        
        System.out.println("All records:");
        Response response = client.target("http://localhost:8080/RecordManagement/webservice/records")
                                   .request()
                                   .buildGet()
                                   .invoke();        
        List<Record> records = response.readEntity(new GenericType<List<Record>>() {});
         
        for (Record r : records) {
             System.out.println(r);
         }
        System.out.println("********");
        
        System.out.println("Records for ID 1:");
        response = client.target("http://localhost:8080/RecordManagement/webservice/records/1")
                .request()
                .buildGet()
                .invoke();     
        System.out.println(response.readEntity(Record.class));
        System.out.println("********");
                
        System.out.println("Records for Madonna:");
        response = client.target("http://localhost:8080/RecordManagement/webservice/records?artist=madonna")
                .request()
                .buildGet()
                .invoke();     
        System.out.println(response.readEntity(String.class));
        System.out.println("********");
      
        System.out.println("Album Nevermind:");
        response = client.target("http://localhost:8080/RecordManagement/webservice/records?title=nevermind")
                .request()
                .buildGet()
                .invoke();     
        System.out.println(response.readEntity(String.class));
        System.out.println("********");
         
        System.out.println("All pop albums:");
        response = client.target("http://localhost:8080/RecordManagement/webservice/records?genre=pop")
                .request()
                .buildGet()
                .invoke();     
        System.out.println(response.readEntity(String.class));
        System.out.println("********");
        
        System.out.println("Nonexistant ID:");
        Response resp = client.target("http://localhost:8080/RecordManagement/webservice/records/44")
                              .request("application/JSON")
                              .buildGet()
                              .invoke();
        System.out.println(resp.getHeaders().toString());
        System.out.println(resp.getStatus()); 
        System.out.println(resp.getStatusInfo());
        System.out.println(resp.readEntity(String.class));
        System.out.println("********");
        
        System.out.println("Deleting record ID 9");
        response = client.target("http://localhost:8080/RecordManagement/webservice/records/9")
                .request().buildDelete().invoke();
        System.out.println("Delete status was " + response.getStatus());
        response.close();
        System.out.println("********");
        
        System.out.println("Adding the best album of all times ever ever");
        Record rec = new Record();
        rec.setArtist("Nahid");
        rec.setGenre("Rock");
        rec.setTitle("Rock 'n' Roll Never Dies");
        rec.setBarCode("060075337576");
        Entity<Record> recEntity = Entity.entity(rec, "application/JSON"); 
        response = client.target("http://localhost:8080/RecordManagement/webservice/records")
                              .request()
                              .buildPost(recEntity)
                              .invoke();
        System.out.println(response.readEntity(Record.class).getTitle());
        System.out.println("********");
        
        System.out.println("Updating the best album of all times ever ever");
        Record newRecord = new Record();
        newRecord.setArtist("NAHID");
        newRecord.setTitle("ROCK 'N' ROLL NEVER DIES");
        newRecord.setBarCode("060075337576");
        newRecord.setGenre("Rock");
        Entity<Record> nahidEntity = Entity.entity(newRecord, "application/JSON");
        response = client.target("http://localhost:8080/RecordManagement/webservice/records/10")
                            .request()
                            .buildPut(nahidEntity)
                            .invoke();
        System.out.println("Update status was " + response.getStatus()); 
        System.out.println(response.readEntity(Record.class)); 
        
        response.close();
         
    }   
}


