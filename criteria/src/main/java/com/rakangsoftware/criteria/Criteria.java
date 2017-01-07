package com.rakangsoftware.criteria;

import java.util.ArrayList;
import java.util.List;

public abstract class Criteria<K> implements Criterion<K> {
    @Override
    public List<K> meet(final List<K> objects) {
        List<K> result = new ArrayList<>();

        for (K object : objects) {
            if (meet(object)) {
                result.add(object);
            }
        }

        return result;
    }
}
