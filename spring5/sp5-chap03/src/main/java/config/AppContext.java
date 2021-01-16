package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInformationPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
public class AppContext {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao());
        return passwordService;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter() {
        // constructor 방식
        // 인자가 두 개 일때도 똑같이 넘기면 된다.
        // bean 객체를 생성하는 시점에 필요한 모든 의존 객체를 주입받는다.
        // 그래서 객체를 사용할 때 완전한 상태로 사용 할 수 있다.
        // 그러나 넘겨야하는 객체가 많을 때는 일일이 확인해야하는 단점이 있다.
        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInformationPrinter memberInformationPrinter() {
        // setter 방식
        // bean 객체를 생성하는 시점에 필요한 객체를 모두 알 수 있다.
        // 그러나 필요한 의존객체를 전달하지 않아도 bean 객체가 생성되기 때문에 NPE가 발생할 수 있다.
        MemberInformationPrinter informationPrinter = new MemberInformationPrinter();
        informationPrinter.setMemberDao(memberDao());
        informationPrinter.setPrinter(memberPrinter());
        return informationPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

}
