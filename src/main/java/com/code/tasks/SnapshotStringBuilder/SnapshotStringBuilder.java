package com.code.tasks.SnapshotStringBuilder;


// originator
public class SnapshotStringBuilder {
    private StringBuilder state = new StringBuilder();
    /* если нам важно восстановление последенего снимка и сохранение инкапсуляции, то логично держать исторю изменений
    внутри "создателя" */
    private final EditHistory history = new EditHistory();

    public SnapshotStringBuilder() {
    }

    public SnapshotStringBuilder(String str) {
        state = new StringBuilder(str);
    }

    public SnapshotStringBuilder append(Object obj) {
        history.saveState(this.getSnapshot());
        state.append(obj);
        return this;
    }

    public SnapshotStringBuilder insert(int start, Object obj) {
        history.saveState(this.getSnapshot());
        state.insert(start, obj);
        return this;
    }

    public SnapshotStringBuilder replace(int start, int end, String obj) {
        history.saveState(this.getSnapshot());
        state.replace(start, end, obj);
        return this;
    }

    public SnapshotStringBuilder undo() {
        if (!history.isEmpty()){
            this.state = new StringBuilder(history.getLastState().getMemento());
        }
        return this;
    }

    public SnapshotStringBuilder restore(BuilderMemento state){
        this.state = new StringBuilder(state.getMemento());
        return this;
    }

    public String toString(){
        return state.toString();
    }

    private BuilderMemento getSnapshot() {
        return new BuilderMemento(new StringBuilder(this.state));
    }
}