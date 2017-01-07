package com.rakangsoftware.criteria;

import java.util.List;

public class AndCriteria<K> implements Criteria<K> {

    private Criteria<K> mFirstCriteria;
    private Criteria<K> mSecondCriteria;

    public AndCriteria(Criteria<K> firstCriteria, Criteria<K> secondCriteria) {
        mFirstCriteria = firstCriteria;
        mSecondCriteria = secondCriteria;
    }

    @Override
    public List<K> meet(List<K> objects) {
        List<K> firstCriteriaItems = mFirstCriteria.meet(objects);

        return mSecondCriteria.meet(firstCriteriaItems);
    }

    @Override
    public boolean meet(final K object) {
        return mFirstCriteria.meet(object) && mSecondCriteria.meet(object);
    }
}
