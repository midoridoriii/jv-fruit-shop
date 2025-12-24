package core.basesyntax;

import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;

public interface Strategy {
    public OperationHandler getOperationHandler(Operation operation);
}
