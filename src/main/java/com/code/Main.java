package com.code;


import com.code.tasks.SnapshotStringBuilder.SnapshotStringBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SnapshotStringBuilder snapshotStringBuilder = new SnapshotStringBuilder("1");
        System.out.println(snapshotStringBuilder);

        snapshotStringBuilder.append("2");
        System.out.println(snapshotStringBuilder);

        snapshotStringBuilder.append("3");
        System.out.println(snapshotStringBuilder);

        snapshotStringBuilder.append("4");
        System.out.println(snapshotStringBuilder);

        snapshotStringBuilder.replace(1,2,"5");
        System.out.println(snapshotStringBuilder);

        System.out.println(snapshotStringBuilder.undo().undo().undo().undo().undo());
    }
}