package MakeMoneyTransferApp;

import MakeMoneyTransferApp.exception.ProcessingExceptions;
import MakeMoneyTransferApp.model.TransferOperations;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ProcessingExceptions {
        TransferOperations.transferOperation();
    }
}