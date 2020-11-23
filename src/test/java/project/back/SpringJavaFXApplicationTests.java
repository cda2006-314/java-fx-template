package project.back;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import project.back.back.model.Member;
import project.back.back.repository.MemberRepository;
import project.back.back.services.MemberServices;
import project.front.javafx.JavaFXApplication;
import project.front.javafx.JavaFXMain;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringJavaFXApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberServices memberServices;


//Ce test ne passe pas à cause de la configuration
/*à essayer
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Navigation.class, loader = FXMLDocumentController.class)
@WebIntegrationTest
 */

    @Test
    void updateMember(Member member){

        Member member1 = memberServices.findById(1);


    member1.setMemberEmail("blabla");
           memberServices.createMember(member1);

            assertEquals(member1.getMemberId(), member1.getMemberId());
}


    public static void main(String[] args) {
        JavaFXMain.main(args);
    }

}
