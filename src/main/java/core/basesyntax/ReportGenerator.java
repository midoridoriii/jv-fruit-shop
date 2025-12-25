package core.basesyntax;

import java.util.List;

public interface ReportGenerator {
    public List<String> getReport(Inventory inventory);
}
