package es.bilbomatica.cxf.persistence;

import java.util.List;

import es.bilbomatica.cxf.model.EventVO;

public interface EventsDAO {
	
	public List<EventVO> getEvents();
	public EventVO getEvent(Long idEvent);
}
