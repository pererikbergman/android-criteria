package com.rakangsoftware.criteria;

import java.util.ArrayList;
import java.util.List;

public class NotCriterion<K> implements Criterion<K> {

    private final Criterion<K> mCriterion;

    public NotCriterion(Criterion<K> criterion) {
        mCriterion = criterion;
    }

    @Override
    public List<K> meet(List<K> objects) {
        List<K> result = new ArrayList<>();
        for (K object : objects) {
            result.add(object);
        }
        List<K> invertedResult = mCriterion.meet(objects);

        for (K object : invertedResult) {
            if (result.contains(object)) {
                result.remove(object);
            }
        }

        return result;
    }

    @Override
    public boolean meet(final K object) {
        return !mCriterion.meet(object);
    }
}