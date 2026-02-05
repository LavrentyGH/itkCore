package org.example.core;

import org.example.collections.FilterImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilderEditor editor = new StringBuilderEditor();
        StringBuilderEditorHistory history = new StringBuilderEditorHistory(editor);
        editor.write(new StringBuilder("1  "));
        history.saveState();
        editor.write(new StringBuilder("2  "));
        history.saveState();
        editor.write(new StringBuilder("3  "));
        history.saveState();
        System.out.println(editor.getData().toString());
        history.undo();
        System.out.println(editor.getData().toString());
        history.undo();
        System.out.println(editor.getData().toString());
    }

}