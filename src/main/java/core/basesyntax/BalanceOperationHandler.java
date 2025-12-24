package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void handle(Transaction transaction, Inventory inventory) {
        String fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        inventory.setFruitQuantity(fruit, quantity);
    }
}
