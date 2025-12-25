package core.basesyntax;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.*;
import core.basesyntax.serviceImpl.*;
import core.basesyntax.strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // 1) Core компоненти
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();

        Inventory inventory = new Inventory();

        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(Operation.RETURN, new ReturnOperationHandler());

        Strategy strategy = new StrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy, inventory);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        // 2) Read
        String inputPath = "reportToRead.csv";
        List<String> lines = fileReader.read(inputPath);

        // 3) Convert
        List<Transaction> transactions = dataConverter.convert(lines);

        // 4) Process
        shopService.process(transactions);

        // 5) Report + Write
        List<String> reportLines = reportGenerator.getReport(inventory);
        String outputPath = "finalReport.csv";
        fileWriter.write(reportLines, outputPath);
    }
}
