package core.basesyntax;

import core.basesyntax.Transaction;
import core.basesyntax.Inventory;

public interface OperationHandler {
    public void handle(Transaction transaction, Inventory inventory);
}
