package core.basesyntax;

import core.basesyntax.Inventory;
import java.util.List;

public interface ReportGenerator {
    public List<String> getReport(Inventory inventory);
}
