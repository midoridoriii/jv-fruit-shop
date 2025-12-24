package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;

public class StrategyImpl implements Strategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        OperationHandler operationHandler = operationHandlerMap.get(operation);
        if (operationHandler == null) {
            throw new RuntimeException("No handler registered for operation: " + operation);
        }
        return operationHandler;
    }
}
