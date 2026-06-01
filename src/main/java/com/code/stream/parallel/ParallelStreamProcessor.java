package com.code.stream.parallel;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class ParallelStreamProcessor {

    public static Map<String, BigDecimal> getAverageGrades(List<Student> students) {

        return students.parallelStream()
                .flatMap(student -> student.grades().entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, averagingInt(Map.Entry::getValue)))
                .entrySet().stream()
                .collect(
                        toMap(
                                Map.Entry::getKey,
                                entry -> BigDecimal
                                        .valueOf(entry.getValue())
                                        .setScale(0, RoundingMode.HALF_UP)
                        )
                );

    }
}
