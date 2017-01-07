package com.rakangsoftware.criteria;

import java.util.List;

public class XOrCriteria<K> implements Criteria<K> {

    private final Criteria mFirstCriteria;
    private final Criteria mSecondCriteria;

    public XOrCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        mFirstCriteria = firstCriteria;
        mSecondCriteria = secondCriteria;
    }

    @Override
    public List<K> meet(List<K> objects) {
        List<K> firstCriteriaItems = mFirstCriteria.meet(objects);
        List<K> otherCriteriaItems = mSecondCriteria.meet(objects);

        for (K object : otherCriteriaItems) {
            if (firstCriteriaItems.contains(object)) {
                firstCriteriaItems.remove(object);
            } else {
                firstCriteriaItems.add(object);
            }
        }
        return firstCriteriaItems;
    }

    @Override
    public boolean meet(final K object) {
        return mFirstCriteria.meet(object) || mSecondCriteria.meet(object);
    }
}