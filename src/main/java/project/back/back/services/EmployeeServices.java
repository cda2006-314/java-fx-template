package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.form.MemberForm;
import project.back.back.model.Employee;
import project.back.back.model.Member;
import project.back.back.model.Websitetheme;
import project.back.back.repository.CommentstatusRepository;
import project.back.back.repository.EmployeeRepository;
import project.back.back.repository.EventstatusRepository;
import project.back.back.repository.MemberstatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    MemberstatusRepository memberstatusRepository;
    @Autowired
    EventstatusRepository eventstatusRepository;
    @Autowired
    CommentstatusRepository commentstatusRepository;

    public void createEmployee(Employee employee){employeeRepository.save(employee);}

    public void deleteEmployee(Employee employee){employeeRepository.delete(employee);}

   public void changeUserStatus(Integer memberId){memberstatusRepository.updateMemberStatus(memberId);
       System.out.println("Le statut du membre " + memberId + "a été modifié");}

       public void moderateComment(Integer commentId){commentstatusRepository.updateCommentStatus(commentId);
        System.out.println("Le statut du commentaire " + commentId + "a été modifié"); ;}

   public void moderateEvent(Integer eventId){eventstatusRepository.updateEventStatus(eventId);
       System.out.println("Le statut de l'évenement a été modifié"); }

    public Websitetheme manageWebSiteTheme(){return new Websitetheme();}

    public boolean checkLogin(String login, String password){

        Optional<Employee> rechercheEmployee = employeeRepository.findEmployeeByEmployeeLogin(login);
        if(rechercheEmployee.isPresent()){
            Employee employeeVerif = rechercheEmployee.get();
            String passwordCheck = employeeVerif.getEmployeePassword();

            if(password.equals(passwordCheck)){
                return true;
            }
        return false;
        }
        return false;

       }

    public void accessSystem(){}

    public void accessLog(){}

    public Employee findById(int id){
        Employee employee;
        Optional<Employee> optionnalEmployee = employeeRepository.findById(id);
    if (optionnalEmployee.isPresent()) {
         employee = optionnalEmployee.get();
        return employee;
    }
    return null;
    }

    public Employee findByLogin(String login){
        Employee employee;
        Optional<Employee> optionnalEmployee = employeeRepository.findEmployeeByEmployeeLogin(login);
        if (optionnalEmployee.isPresent()) {
            employee = optionnalEmployee.get();
            return employee;
        }
        return null;
    }


    public List<Employee> getList(){return employeeRepository.findAll();}

    public Member validateMember(MemberForm memberForm){return new Member();}
}
