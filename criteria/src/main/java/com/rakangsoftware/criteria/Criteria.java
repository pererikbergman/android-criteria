package com.rakangsoftware.criteria;

import java.util.List;

public interface Criteria<K> {
    public List<K> meetCriteria(List<K> objects);
    public boolean meetCriteria(K object);
}
