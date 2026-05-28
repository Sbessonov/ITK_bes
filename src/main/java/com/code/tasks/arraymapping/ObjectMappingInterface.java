package com.code.tasks.arraymapping;

@FunctionalInterface
public interface ObjectMappingInterface<T> {
    T apply(T obj);
}
