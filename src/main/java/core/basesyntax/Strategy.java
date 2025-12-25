package core.basesyntax;

public interface Strategy {
    public OperationHandler getOperationHandler(Operation operation);
}
