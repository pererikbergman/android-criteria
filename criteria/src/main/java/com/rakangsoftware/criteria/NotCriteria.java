package com.rakangsoftware.criteria;

import java.util.ArrayList;
import java.util.List;

public class NotCriteria<K> implements Criteria<K> {

    private final Criteria<K> mCriteria;

    public NotCriteria(Criteria<K> criteria) {
        mCriteria = criteria;
    }

    @Override
    public List<K> meet(List<K> objects) {
        List<K> result         = new ArrayList<>();
        for (K object : objects) {
            result.add(object);
        }
        List<K> invertedResult = mCriteria.meet(objects);

        for (K object : invertedResult) {
            if (result.contains(object)) {
                result.remove(object);
            }
        }

        return result;
    }

    @Override
    public boolean meet(final K object) {
        return !mCriteria.meet(object);
    }
}