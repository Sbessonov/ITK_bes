package com.code.tasks.elementcalcualtion;

import java.util.HashMap;
import java.util.Map;

public class ElementCalculator {

    public static <K> Map<K,Long> getCountByElement(K[] array){
        Map<K,Long> countByElements = new HashMap<>();
        for (K key : array) {
            countByElements.merge(key, 1L, Long::sum);
        }
        return countByElements;
    }
}
