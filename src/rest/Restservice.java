package rest;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.monitoring.RequestEventListener;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;


import mongodb.dbConnection;
import mongodb.dbMethods;


@Path("/helloworld")
public class Restservice{

	@GET
	@Path("/place")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayPlainTextHello(@QueryParam("place") String place ) {
		System.out.println(place);
		//hello db=new hello();
		//db.print();
		dbMethods db1=new dbMethods();
		//db1.jsonInsert();
		//db1.print();
		DBObject busList=db1.findParticularKey(place);
		return Response.status(200).entity(busList)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();
	}
	@GET
	@Path("/Time")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlaceTime(@QueryParam("place") String place,@QueryParam("time") String time ) {
		System.out.println(place);
		//hello db=new hello();
		//db.print();
		dbMethods db1=new dbMethods();
		//db1.jsonInsert();
		//db1.print();
		DBObject busList= db1.findPlacetime(place,time);
		return Response.status(200).entity(busList)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayXMLHello() {
		dbMethods db1=new dbMethods();
		List<String> names=db1.getPlaces();
		return Response.status(200).entity(names)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();
	}

	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello World RESTful Jersey"
				+ "</title>" + "<body><h1>" + "Hello World RESTful Jersey Text_HTML"
				+ "</body></h1>" + "</html> ";
	}


}

