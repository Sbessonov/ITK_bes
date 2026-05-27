package com.code.tasks.SnapshotStringBuilder;

import java.util.Stack;


//caretaker
class EditHistory {
    private final Stack<BuilderMemento> history = new Stack<>();

    public void saveState(BuilderMemento state) {
        history.push(state);
    }

    public BuilderMemento getLastState() {
        return history.pop();
    }
}
