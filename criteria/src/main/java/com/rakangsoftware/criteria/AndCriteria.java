package com.rakangsoftware.criteria;

public class AndCriteria<K> extends Criteria<K> {

    private final Criterion<K>[] mCriterion;

    public AndCriteria(Criterion<K>... criterion) {
        mCriterion = criterion;
    }

    @Override
    public boolean meet(final K object) {
        for (Criterion<K> criterion : mCriterion) {
            if (!criterion.meet(object)) {
                return false;
            }
        }

        return true;
    }
}