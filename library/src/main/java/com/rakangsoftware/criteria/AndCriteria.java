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
        mFirstCriteria  = firstCriteria;
        mSecondCriteria = secondCriteria;
    }

    @Override
    public List<K> meetCriteria(List<K> objects) {
        List<K> firstCriteriaItems = mFirstCriteria.meetCriteria(objects);

        return mSecondCriteria.meetCriteria(firstCriteriaItems);
    }
}
