package org.example.arraytask.builder;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.arraytask.entity.ArrayWrapper;
import org.junit.jupiter.api.Test;

class IntegerArrayBuilderTest {
    @Test
    void shouldBuildArrayWrapper() {
        ArrayWrapper wrapper = new IntegerArrayBuilder()
                .name("built")
                .addValue(1)
                .addValue(2)
                .build();

        assertEquals("built", wrapper.getName());
        assertArrayEquals(new int[] {1, 2}, wrapper.getValues());
    }
}