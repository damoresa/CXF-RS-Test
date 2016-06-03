package es.bilbomatica.cxf.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@WebService
public interface EventsRestService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEvents")
	public Response getEvents();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEventDetail")
	public Response getEventDetail(@QueryParam("eventId") Long eventId);
}
