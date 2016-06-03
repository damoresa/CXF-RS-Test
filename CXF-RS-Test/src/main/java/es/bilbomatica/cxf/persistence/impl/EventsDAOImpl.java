package es.bilbomatica.cxf.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.bilbomatica.cxf.model.EventVO;
import es.bilbomatica.cxf.persistence.EventsDAO;

@Repository("EventsDAOImpl")
public class EventsDAOImpl implements EventsDAO {
	
	private static final List<EventVO> eventList = new ArrayList<EventVO>();
	private static final Integer NO_TEST_CASES = 10;
	
	static
	{
		for (int noEvent = 1; noEvent <= NO_TEST_CASES; noEvent++)
		{
			EventVO event = new EventVO();
			event.setId(Long.valueOf(noEvent));
			event.setName("Event " + noEvent);
			event.setCode("EVT_" + String.format("%04d", noEvent));
			event.setContactEmail("evt" + noEvent + "@test.com");
			
			eventList.add(event);
		}
	}

	@Override
	public List<EventVO> getEvents() {
		return eventList;
	}

	@Override
	public EventVO getEvent(Long idEvent) {
		EventVO result = null;
		
		for (EventVO event : eventList)
		{
			if (idEvent.equals(event.getId()))
			{
				result = event;
				break;
			}
		}
		
		return result;
	}

}
