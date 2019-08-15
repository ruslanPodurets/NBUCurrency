package com.fun.nbucurrency.modules.common;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

abstract class StackRepository implements IRepository {

    private final Map<Integer, Callback> tasks = new HashMap<>();


    void addTask(@NonNull Integer id, Callback callback) {
        tasks.put(id, callback);
    }

    Callback getCallback(@NonNull Integer id) {
        return tasks.get(id);
    }

    void removeTask(@NonNull Integer id) {
        tasks.remove(id);
    }

}
