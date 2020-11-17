package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Invitation;
import project.back.back.repository.InvitationRepository;

@Service
public class InvitationServices {

    @Autowired
    InvitationRepository invitationRepository;

    public void createInvitation(Invitation invitation){invitationRepository.save(invitation);}

    public void showInvitationStatus(Integer invitationId){invitationRepository.findStatus(invitationId);}

}
