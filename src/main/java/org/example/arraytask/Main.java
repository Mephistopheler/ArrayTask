package org.example.arraytask;

import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.arraytask.entity.ArrayWrapper;
import org.example.arraytask.exception.ArrayTaskException;
import org.example.arraytask.factory.ArrayFactory;
import org.example.arraytask.factory.IntegerArrayFactory;
import org.example.arraytask.parser.ArrayParser;
import org.example.arraytask.parser.IntegerArrayParser;
import org.example.arraytask.reader.ArrayFileReader;
import org.example.arraytask.reader.ArrayFileReaderImpl;
import org.example.arraytask.service.ArrayCalculationService;
import org.example.arraytask.service.ArrayCalculationServiceImpl;
import org.example.arraytask.service.ArraySortService;
import org.example.arraytask.service.ArraySortServiceImpl;
import org.example.arraytask.validator.ArrayDataValidator;
import org.example.arraytask.validator.IntegerArrayDataValidator;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public void run() {
        ArrayDataValidator validator = new IntegerArrayDataValidator();
        ArrayParser parser = new IntegerArrayParser(validator);
        ArrayFileReader reader = new ArrayFileReaderImpl();
        ArrayFactory factory = new IntegerArrayFactory();
        ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        try {
            List<String> lines = reader.readLines(Path.of("data", "arrays.txt"));
            int index = 1;
            for (String line : lines) {
                processLine(line, index, parser, factory, calculationService, sortService);
                index++;
            }

        } catch (ArrayTaskException e) {
            LOGGER.error("Application processing failed", e);
        }
    }

    private void processLine(
            String line,
            int index,
            ArrayParser parser,
            ArrayFactory factory,
            ArrayCalculationService calculationService,
            ArraySortService sortService) {
        try {
            ArrayWrapper arrayWrapper = factory.create(parser.parse(line), "file-array-" + index);
            LOGGER.info("Created array: {}", arrayWrapper);
            LOGGER.info("Minimum: {}", calculationService.findMinimum(arrayWrapper));
            LOGGER.info("Maximum: {}", calculationService.findMaximum(arrayWrapper));
            LOGGER.info("Sum: {}", calculationService.calculateSum(arrayWrapper));
            LOGGER.info("Average: {}", calculationService.calculateAverage(arrayWrapper));
            LOGGER.info("Bubble sorted: {}", sortService.sortByBubbleSort(arrayWrapper));
            LOGGER.info("Insertion sorted: {}", sortService.sortByInsertionSort(arrayWrapper));
        } catch (ArrayTaskException e) {
            LOGGER.warn("Line {} was skipped: {}", index, e.getMessage());
        }
    }



    public static void main(String[] args) {
        Main application = new Main();
        application.run();
    }
}