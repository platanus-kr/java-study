package main;

import config.AppContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInformationPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongIdPasswordException;


public class MainForSpring {

    private static ApplicationContext context = null;

    public static void main(String[] args) throws IOException {
        context = new AnnotationConfigApplicationContext(AppContext.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Input command:");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("program halt.");
                break;
            }
            if (command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            } else if (command.startsWith("list")) {
                processListCommand();
                continue;
            } else if (command.startsWith("info ")) {
                processInformationCommand(command.split(" "));
                continue;
            } else if (command.startsWith("version")) {
                processVersionPrinter();
                continue;
            }
            printHelp();
        }
    }

    private static void processVersionPrinter() {
        VersionPrinter versionPrinter = context.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }

    private static void processInformationCommand(String[] s) {
        if (s.length != 2) {
            printHelp();
            return;
        }
        MemberInformationPrinter informationPrinter =
            context.getBean("memberInformationPrinter", MemberInformationPrinter.class);
        informationPrinter.printMemberInfo(s[1]);
    }

    private static void processListCommand() {
        MemberListPrinter listPrinter =
            context.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    private static void processNewCommand(String[] arg) {
        if (arg.length != 5) {
            printHelp();
            return;
        }
//        MemberRegisterService registerService = assembler.getMemberRegisterService();
        MemberRegisterService registerService =
            context.getBean("memberRegisterService", MemberRegisterService.class);
        RegisterRequest request = new RegisterRequest();
        request.setEmail(arg[1]);
        request.setName(arg[2]);
        request.setPassword(arg[3]);
        request.setConfirmPassword(arg[4]);

        if (!request.isPasswordEqualToConfirmPassword()) {
            System.out.println("invalid password.");
            return;
        }
        try {
            registerService.register(request);
            System.out.println("added user.");
        } catch (DuplicateMemberException e) {
            System.out.println("exist email.");
        }
    }

    private static void processChangeCommand(String[] arg) {
        if (arg.length != 4) {
            printHelp();
            return;
        }

//        ChangePasswordService changePasswordService= assembler.getChangePasswordService();
        ChangePasswordService changePasswordService = context
            .getBean("changePasswordService", ChangePasswordService.class);
        try {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("changed password");
        } catch (MemberNotFoundException e) {
            System.out.println("no exist email.");
        } catch (WrongIdPasswordException e) {
            System.out.println("invalid id and password.");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("invalid command. check under arguments");
        System.out.println(">> commands list");
        System.out.println("new email name password passwordRepeat");
        System.out.println("change email nowPassword newPassword");
        System.out.println("info email");
        System.out.println("list");
        System.out.println();
    }

}
