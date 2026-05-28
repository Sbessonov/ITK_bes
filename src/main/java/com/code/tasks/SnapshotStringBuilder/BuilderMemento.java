package com.code.tasks.SnapshotStringBuilder;

// memento
public record BuilderMemento(StringBuilder snapshot) {
    public StringBuilder getMemento() {
        return snapshot;
    }
}