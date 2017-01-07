package com.rakangsoftware.criteria;

import java.util.ArrayList;
import java.util.List;

public class NameCriterion implements Criterion<String> {

    private String mQuery;

    public NameCriterion(final String query) {
        mQuery = query;
    }

    @Override
    public List<String> meet(final List<String> objects) {
        List<String> result = new ArrayList<>();
        for (String name : objects) {
            if (name.toLowerCase().contains(mQuery)) {
                result.add(name);
            }
        }
        return result;
    }

    @Override
    public boolean meet(final String name) {
        return name.toLowerCase().contains(mQuery);
    }
}