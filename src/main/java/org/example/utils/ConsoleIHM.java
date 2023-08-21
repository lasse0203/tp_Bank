package org.example.utils;

import org.example.model.BankAccount;
import org.example.model.Client;
import org.example.service.BankAccountService;
import org.example.service.BankTransactionService;
import org.example.service.ClientService;

import java.util.List;
import java.util.Scanner;

public class ConsoleIHM {

    private static ClientService clientService = new ClientService();
    private static BankAccountService bankAccountService = new BankAccountService();
    private static BankTransactionService bankTransactionService = new BankTransactionService();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Add Client");
            System.out.println("2. make a deposit ");
            System.out.println("3. make a withdrawal");
            System.out.println("4. Display all transactions");
            System.out.println("5. Display the pay ");
            System.out.println("6. Quit");
            System.out.print("Made a choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createClient();
                    break;
                case 2:
                    makeDeposit();
                    break;
                case 3:
                    makeWithdrawal();
                    break;
                case 4:
                    displayAllTransactions();
                    break;

                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }



    private static void displayAllTransactions() {
        displayClients(clientService.getAllClients());
        System.out.print("Please choose a client ! ");
        int clientId = scanner.nextInt();
        bankTransactionService.getAllbankTransactions(clientId);
    }

    private static void makeWithdrawal() {
        System.out.println("----Make a withdrawal---- ");
        displayClients(clientService.getAllClients());
        System.out.print("Please choose a client, client id = ");
        int clientId = scanner.nextInt();
        System.out.print("How much you want to withdrawal ? ");
        double amount = scanner.nextDouble();
    }

    private static void makeDeposit() {
        System.out.println("----Make a deposit---- ");
        displayClients(clientService.getAllClients());
        System.out.print("Please choose a client" +
                ", client id = ");
        int clientId = scanner.nextInt();
        //search bank accounts by client id
        List<BankAccount> bankaccounts = bankAccountService.getBankAccountsByClientId(clientId);
        int accountId;
        if (bankaccounts.size() > 1 ){
            displayBankAccounts(bankaccounts);
            System.out.print("Please choose an account" +
                    ",account id = ");
            accountId = scanner.nextInt();
        } else {
            accountId =bankaccounts.get(0).getId();
        }
        System.out.print("How much you want to deposit ? ");
        double amount = scanner.nextDouble();



    }

    private static void createClient() {
        System.out.print("----Create Client---- ");
        System.out.print(" please enter a First name : ");
        String firstName = scanner.nextLine();
        System.out.print("please enter a Last name : ");
        String lastName = scanner.nextLine();
        System.out.print("please enter a Phone number : ");
        String phoneNumber = scanner.nextLine();
        clientService.createClient(firstName,lastName,phoneNumber);
    }
    private static void displayClients(List<Client> clients){
        for (Client client:clients) {
            System.out.println(client.toString());
        }

    }
    private static void displayBankAccounts(List<BankAccount> bankAccounts){
        for (BankAccount bankAccount:bankAccounts) {
            System.out.println(bankAccount.toString());
        }

    }
}

