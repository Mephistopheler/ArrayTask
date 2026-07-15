package org.example.arraytask.observer;

import org.example.arraytask.entity.ArrayWrapper;

public class ArrayEvent {
    private final ArrayWrapper source;

    public ArrayEvent(ArrayWrapper source) {
        this.source = source;
    }

    public ArrayWrapper getSource() {
        return source;
    }
}