package core.basesyntax;

import core.basesyntax.Transaction;

public interface DataConverter {
    public Transaction convert(String line);
}
