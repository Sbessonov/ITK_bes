package com.code.tasks.SnapshotStringBuilder;


// originator
public class SnapshotStringBuilder {
    private StringBuilder state = new StringBuilder();
    private final EditHistory history = new EditHistory();

    public SnapshotStringBuilder() {}

    public SnapshotStringBuilder append(Object obj) {
        history.saveState(this.getSnapshot());
        state.append(obj);
        return this;
    }

    public SnapshotStringBuilder undo() {
        this.state = history.getLastState().getMemento();
        return this;
    }

    private BuilderMemento getSnapshot() {
        return new BuilderMemento(state);
    }
}