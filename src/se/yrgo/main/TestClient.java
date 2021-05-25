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
        
        // getting single result and printing as string
//        WebTarget target = client.target
//                ("http://localhost:8080/RecordManagement/webservice/records/1");
//        Invocation invocation = target.request().buildGet();
//        Response response = invocation.invoke();
//        System.out.println(response.readEntity(String.class));
                
        //get single result and store in Record object and printing the object
//          Response response = client.target("http://localhost:8080/RecordManagement/webservice/records/5") 
//                                    .request()
//                                    .buildGet()
//                                    .invoke();    
//          Record rec = response.readEntity(Record.class);
//          System.out.println(rec);
      
        //get all records store in objects in list and printing the list
//          Response response = client.target("http://localhost:8080/RecordManagement/webservice/records")
//                                    .request()
//                                    .buildGet()
//                                    .invoke();        
//          List<Record> records = response.readEntity(new GenericType<List<Record>>() {});
//          
//          for (Record r : records) {
//              System.out.println(r);
//          }
       /* 
        Record rec = new Record();
        rec.setArtist("Nahid");
        rec.setGenre("Punk");
        rec.setTitle("Rock 'n' roll never dies");
        rec.setBarCode("123456");
        
        Entity recEntity = Entity.entity(rec, "application/JSON");
        
        Response resp = client.target("http://localhost:8080/RecordManagement/webservice/records")
                              .request()
                              .buildPost(recEntity)
                              .invoke();
        System.out.println(resp.readEntity(Record.class).getId());*/
        
//        Response resp = client.target("http://localhost:8080/RecordManagement/webservice/records/44")
//                .request("application/JSON")
//                .buildGet()
//                .invoke();
//        
//        System.out.println(resp.getHeaders().toString());
//        System.out.println(resp.getStatus()); 
//        System.out.println(resp.getStatusInfo());
//        
//        System.out.println(resp.readEntity(String.class));
//        
//        resp.close();
        
        Response response = client.target("http://localhost:8080/RecordManagement/webservice/records")
                .request("application/JSON").buildGet().invoke();
        List<Record> records = response.readEntity(new GenericType<List<Record>>() {});
        
        for (Record e : records) { System.out.println(e);
        }
        
        response = client.target("http://localhost:8080/RecordManagement/webservice/records/9")
                .request().buildDelete().invoke();
        System.out.println("Delete status was " + response.getStatus());
        response.close();
        
        Record newRecord = new Record();
        newRecord.setArtist("Nahid");
        newRecord.setTitle("Nahids greatest");
        newRecord.setBarCode("1234");
        newRecord.setGenre("rock");
        
        Entity nahidEntity = Entity.entity(newRecord, "application/JSON");
        response = client.target("http://localhost:8080/RecordManagement/webservice/records/1")
                .request().buildPut(nahidEntity).invoke();
        
        System.out.println("Update status was " + response.getStatus()); 
        System.out.println(response.readEntity(String.class)); 
        
        
        response.close();
         
    }   
}


