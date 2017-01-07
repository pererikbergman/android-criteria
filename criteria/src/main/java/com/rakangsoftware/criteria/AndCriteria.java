package com.rakangsoftware.criteria;

import java.util.List;

public class AndCriteria<K> implements Criteria<K> {

    private Criteria mFirstCriteria;
    private Criteria mSecondCriteria;

    public AndCriteria() {
    }

    public void setFirstCriteria(Criteria firstCriteria) {
        mFirstCriteria = firstCriteria;
    }

    public void setSecondCriteria(Criteria secondCriteria) {
        mSecondCriteria = secondCriteria;
    }

    public AndCriteria(Criteria firstCriteria, Criteria secondCriteria) {
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
