package project.back;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.back.back.model.Member;
import project.back.back.repository.MemberRepository;
import project.back.back.services.MemberServices;
import project.back.back.util.MultipartFileUploadClient;
import project.front.javafx.JavaFXApplication;

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

@Test
public void sendAPicture(){

        MultipartFileUploadClient mp =  new MultipartFileUploadClient();
        mp.sendFile("C:\\Users\\Charlène\\Downloads\\outils-de-cuisine.png");
}


    public static void main(String[] args) {
        JavaFXApplication.main(args);
    }

}
