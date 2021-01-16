package main;

import assembler.Assembler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.WrongIdPasswordException;

public class MainForAssembler {
 
    private static Assembler assembler = new Assembler();

    public static void main(String[] args) throws IOException {
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
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] arg) {
        if (arg.length != 5) {
            printHelp();
            return;
        }
        MemberRegisterService registerService = assembler.getMemberRegisterService();
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

        ChangePasswordService changePasswordService = assembler.getChangePasswordService();

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
        System.out.println("new email name password passwordRepeat");
        System.out.println("change email nowPassword newPassword");
        System.out.println();
    }

}
