package mongodb;

import com.mongodb.MongoClient;

import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;

public class dbConnection 
{
   DB db=null;
   public DB connectiondb() 
   {
	
      try{
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         db = mongoClient.getDB( "businfo" );
         System.out.println("Connect to database successfully");
         System.out.println("Authentication:");
         
        }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
      return db;
   }
}

