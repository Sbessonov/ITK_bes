package com.code;

import com.code.tasks.arraymapping.CollectionMapper;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        String[] strings = {"1", "2", "3"};
        String[] result = CollectionMapper.map(strings, (el) -> el + " new");
        for (String str : result) {
            System.out.print(str);
        }

        System.out.println();

        List<String> list = List.of("1", "2", "3");
        List<String> resultList = CollectionMapper.map(list, (el) -> el + " new");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s -> %s, ", list.get(i), resultList.get(i));

        }
    }
}