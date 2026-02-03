package org.example;

import java.util.Stack;

public class StringBuilderEditorHistory {

    private final Stack<StringBuilderEditorSnapshot> stack = new Stack<>();
    private final StringBuilderEditor editor;

    public StringBuilderEditorHistory(StringBuilderEditor editor) {
        this.editor = editor;
    }

    public void saveState() {
        stack.push(editor.save());
    }

    public void undo() {
        if (stack.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        stack.pop();

        if (stack.isEmpty()) {
            System.out.println("Empty");
            editor.setData(new StringBuilderEditorSnapshot(""));
        } else {
            StringBuilderEditorSnapshot snapshot = stack.peek();
            editor.setData(snapshot);

        }
    }
}
