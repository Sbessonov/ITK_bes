package com.code.tasks.SnapshotStringBuilder;

// memento
record BuilderMemento(StringBuilder snapshot) {
    public StringBuilder getMemento() {
        return snapshot;
    }
}