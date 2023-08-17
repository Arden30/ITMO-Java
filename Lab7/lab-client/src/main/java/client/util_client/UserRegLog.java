package client.util_client;

import common.util_common.Request;
import common.util_common.RequestType;
import common.util_common.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserRegLog {
    private final Scanner sc = new Scanner(System.in);
    private final ClientSocket clientSocket;
    public UserRegLog(ClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }
    public List<String> authentication() {
        try {
            System.out.println("Do you want to register(1) or authorize(2)? Choose 1 or 2");
            String answer = sc.nextLine().trim();
            if ("1".equals(answer)) {
                return registerUser();
            } else if ("2".equals(answer)) {
                return loginUser();
            } else {
                System.out.println("Invalid input, enter 1 or 2!");
                authentication();
            }
            return null;
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
            return null;
        }
    }

    private List<String> registerUser() {
        try {
            String login;
            String password;
            int minLen = 5;
            while (true) {
                System.out.println("Enter login you want (more than 4 symbols):");
                login = sc.nextLine().trim();
                if (login.length() < minLen) {
                    System.out.println("Login is too small, try again!");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("Enter password you want (more than 4 symbols):");
                password = sc.nextLine().trim();
                if (password.length() < minLen) {
                    System.out.println("Password is too small, try again!");
                    continue;
                }
                break;
            }
            try {
                clientSocket.sendRequest(new Request(login, password, RequestType.REGISTER));
                return receiveUsersResponse(login, password);
            } catch (IOException e) {
                System.out.println("An error occurred while serializing the request, try again");
            } catch (ClassNotFoundException e) {
                System.out.println("The response came damaged");
            }
            return null;
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
            return null;
        }
    }

    private List<String> loginUser() {
        try {
            String login;
            String password;
            int minLen = 5;
            while (true) {
                System.out.println("Enter your login (more than 4 symbols):");
                login = sc.nextLine().trim();
                if (login.length() < minLen) {
                    System.out.println("Login is too small, try again!");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("Enter your password (more than 4 symbols):");
                password = sc.nextLine().trim();
                if (password.length() < minLen) {
                    System.out.println("Password is too small, try again!");
                    continue;
                }
                break;
            }
            try {
                clientSocket.sendRequest(new Request(login, password, RequestType.LOGIN));
                return receiveUsersResponse(login, password);
            } catch (IOException e) {
                System.out.println("An error occurred while serializing the request, try again");
            } catch (ClassNotFoundException e) {
                System.out.println("The response came damaged");
            }
            return null;
        } catch (NoSuchElementException e) {
            System.out.println("An invalid character has been entered, forced shutdown!");
            System.exit(1);
            return null;
        }
    }
    private List<String> receiveUsersResponse(String login, String password) throws ClassNotFoundException, IOException {
        Response response = clientSocket.receiveResponse();
        System.out.println(response.getMessageToResponse());
        if (response.isSuccess()) {
            List<String> listToReturn = new ArrayList<>();
            listToReturn.add(login);
            listToReturn.add(password);
            return listToReturn;
        }
        return null;
    }


}
