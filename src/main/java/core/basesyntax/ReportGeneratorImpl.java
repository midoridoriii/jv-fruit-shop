package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public List<String> getReport(Inventory inventory) {
        List<String> report = new ArrayList<>();
        report.add("fruit, quantity");

        Map<String, Integer> fruits = inventory.getAllFruits();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
