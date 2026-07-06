package org.example.arraytask.parser;

import org.example.arraytask.exception.ArrayTaskException;

import java.math.BigInteger;

public interface ArrayParser {
    BigInteger[] parse(String line) throws ArrayTaskException;
}