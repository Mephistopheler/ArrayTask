package org.example.arraytask.specification;

public enum ComparisonType {
    LESS,
    EQUAL,
    GREATER;

    public boolean matches(int comparison) {
        return switch (this) {
            case LESS -> comparison < 0;
            case EQUAL -> comparison == 0;
            case GREATER -> comparison > 0;
        };
    }
}