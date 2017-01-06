package com.rakangsoftware.criteria;

import java.util.List;

public class OrCriteria<K> implements Criteria<K> {

    private final Criteria mFirstCriteria;
    private final Criteria mSecondCriteria;

    public OrCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        mFirstCriteria = firstCriteria;
        mSecondCriteria = secondCriteria;
    }

    @Override
    public List<K> meetCriteria(List<K> objects) {
        List<K> firstCriteriaItems = mFirstCriteria.meetCriteria(objects);
        List<K> otherCriteriaItems = mSecondCriteria.meetCriteria(objects);

        for (K object : otherCriteriaItems) {
            if (!firstCriteriaItems.contains(object)) {
                firstCriteriaItems.add(object);
            }
        }
        return firstCriteriaItems;
    }

    @Override
    public boolean meetCriteria(final K object) {
        return mFirstCriteria.meetCriteria(object) || mSecondCriteria.meetCriteria(object);
    }
}