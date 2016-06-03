package es.bilbomatica.cxf.service.impl;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.eclipse.jetty.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.bilbomatica.cxf.model.EventVO;
import es.bilbomatica.cxf.persistence.EventsDAO;
import es.bilbomatica.cxf.service.EventsRestService;

@WebService(endpointInterface = "es.bilbomatica.cxf.service.EventsRestService")
public class EventsRestServiceImpl implements EventsRestService {
	
	private static final Logger logger = Logger.getLogger(EventsRestServiceImpl.class);
	
	@Autowired
	@Qualifier("EventsDAOImpl")
	private EventsDAO eventsDAO;
	
	@Override
	public Response getEvents() {
		
		if (logger.isDebugEnabled())
		{
			logger.debug(" >> Querying EventsRestServiceImpl.getEvents ");
		}
		
		List<EventVO> eventList = eventsDAO.getEvents();
		
		return Response.ok(eventList).build();
	}

	@Override
	public Response getEventDetail(Long eventId) {
		
		if (logger.isDebugEnabled())
		{
			logger.debug(" >> Querying EventsRestServiceImpl.getEventDetail for event : " + eventId);
		}
		
		if (eventId == null)
		{
			return Response.status(HttpStatus.BAD_REQUEST_400).build();
		}
		
		EventVO event = eventsDAO.getEvent(eventId);
		
		return Response.ok(event).build();
	}
}
