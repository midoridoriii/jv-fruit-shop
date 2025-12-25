package core.basesyntax.serviceImpl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public Transaction convert(String lines) {
        if (lines.startsWith("type")) {
            return null;
        }
        Operation operation;
        String[] parts = lines.split(",");
        switch (parts[0]) {
            case "b":
                operation = Operation.BALANCE;
                break;
            case "s":
                operation = Operation.SUPPLY;
                break;
            case "p":
                operation = Operation.PURCHASE;
                break;
            case"r":
                operation = Operation.RETURN;
                break;
            default:
                throw new RuntimeException("Unknown operation: " + parts[0]);
        }
        String fruit = parts[1];
        Integer quantity = Integer.parseInt(parts[2]);
        return new Transaction(operation, fruit, quantity);
    }

    public List<Transaction> convert(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (String line : lines) {
            Transaction transaction = convert(line);
            if (transaction != null) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
