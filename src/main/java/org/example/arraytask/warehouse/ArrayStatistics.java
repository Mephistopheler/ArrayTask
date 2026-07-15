package org.example.arraytask.warehouse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public record ArrayStatistics(
        Optional<BigInteger> sum,
        Optional<BigDecimal> average,
        Optional<BigInteger> maximum,
        Optional<BigInteger> minimum,
        int count
) {
}