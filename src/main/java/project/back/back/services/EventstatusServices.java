package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import project.back.back.model.Eventstatus;
import project.back.back.repository.EventstatusRepository;

import java.util.List;

@Service
public class EventstatusServices {
@Autowired
    EventstatusRepository eventstatusRepository;

public void uptadeEventStatus(int eventId){eventstatusRepository.updateEventStatus(eventId);}

public List<Eventstatus> getList(){return eventstatusRepository.findAll();}

public void createEventStatus(Eventstatus eventstatus){eventstatusRepository.save(eventstatus);}




}
