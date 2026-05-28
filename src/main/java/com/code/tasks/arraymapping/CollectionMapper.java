package com.code.tasks.arraymapping;

import java.util.Arrays;
import java.util.List;

public class CollectionMapper {

    public static <T> T[] map(T[] inputArray, ObjectMappingInterface<T> function){
        T[] result = Arrays.copyOf(inputArray, inputArray.length);

        for (int i = 0; i < inputArray.length; i++) {
            result[i] = function.apply(inputArray[i]);
        }

        return result;
    }


    public static <T> List<T> map(List<T> inputArray, ObjectMappingInterface<T> function){
        return inputArray.stream().map(function::apply).toList();
    }

}
