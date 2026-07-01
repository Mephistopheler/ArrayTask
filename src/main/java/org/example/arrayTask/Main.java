package org.example.arrayTask;


import org.example.arrayTask.entity.AbstractArrayWrapper;
import org.example.arrayTask.exception.ArrayProcessingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public void run() {
        logger.info("Application started");

        try {
            demonstrateFactoryMethod();
            demonstrateBuilder();
        } catch (ArrayProcessingException e) {
            logger.error("Processing error: {}", e.getMessage());
        }

        logger.info("Application finished");
    }

    private void demonstrateFactoryMethod() throws ArrayProcessingException {
        logger.info("=== Factory Method Demonstration ===");

        ArrayWrapperFactory intFactory = new IntegerArrayFactory();
        AbstractArrayWrapper<?> intArray = intFactory.createArrayWrapper(
                new Object[]{5, 2, 8, 1, 9}, "IntegerArray");

        ArrayWrapperFactory doubleFactory = new DoubleArrayFactory();
        AbstractArrayWrapper<?> doubleArray = doubleFactory.createArrayWrapper(
                new Object[]{3.14, 2.71, 1.41, 1.73}, "DoubleArray");

        ArrayProcessingService service = new ArrayProcessingServiceImpl();

        logger.info("Integer array: {}", intArray);
        logger.info("Sum: {}", service.calculateSum(intArray));
        logger.info("Average: {}", service.calculateAverage(intArray));
        logger.info("Max: {}", service.findMaximum(intArray));
        logger.info("Min: {}", service.findMinimum(intArray));

        service.sortArray(intArray);
        logger.info("Sorted integer array: {}", intArray);

        logger.info("Double array: {}", doubleArray);
        logger.info("Sum: {}", service.calculateSum(doubleArray));
        logger.info("Average: {}", service.calculateAverage(doubleArray));
    }

    private void demonstrateBuilder() throws ArrayProcessingException {
        logger.info("=== Builder Demonstration ===");

        ArrayWrapperBuilder builder = new ArrayWrapperBuilder();
        AbstractArrayWrapper<?> builtArray = builder
                .setName("BuiltArray")
                .addElement(10)
                .addElement(20)
                .addElement(30)
                .addElement(40)
                .build();

        logger.info("Built array: {}", builtArray);

        ArrayProcessingService service = new ArrayProcessingServiceImpl();
        logger.info("Sum: {}", service.calculateSum(builtArray));
        logger.info("Average: {}", service.calculateAverage(builtArray));
    }

    public static void main(String[] args) {
        Main application = new Main();
        application.run();
    }
}