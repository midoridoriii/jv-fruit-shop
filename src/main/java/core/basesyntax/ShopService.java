package core.basesyntax;

import core.basesyntax.Transaction;

import java.util.List;

public interface ShopService {
    public void process(List<Transaction> transactions);
}
