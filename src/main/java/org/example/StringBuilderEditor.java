package org.example;

public class StringBuilderEditor {

    private StringBuilder data;

    public StringBuilderEditor() {
        this.data = new StringBuilder();
    }
    public StringBuilder getData() {
        return data;
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
