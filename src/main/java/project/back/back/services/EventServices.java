package project.back.back.services;

import project.back.back.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.repository.EventRepository;

@Service
public class EventServices {

@Autowired
EventRepository eventRepository;

public void createEvent(Event event){eventRepository.save(event);}

public void hasComment(){}

//public int hasLike(){return ;}

public void isReported(Event event){}

public void isDeleted(Event event){eventRepository.delete(event);}
}
