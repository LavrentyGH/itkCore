package org.example.core;

public class StringBuilderEditor {

    private StringBuilder data;

    public StringBuilderEditor() {
        this.data = new StringBuilder();
    }
    public StringBuilder getData() {
        return new StringBuilder(data);
    }

    public void write (StringBuilder data) {
        this.data.append(data);
    }
    public StringBuilderEditorSnapshot save() {
        return new StringBuilderEditorSnapshot(data.toString());
    }

    public void setData(StringBuilderEditorSnapshot snapshot) {
        this.data = new StringBuilder(snapshot.getState());
    }
}
