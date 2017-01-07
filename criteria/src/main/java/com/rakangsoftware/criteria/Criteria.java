package com.rakangsoftware.criteria;

import java.util.List;

public interface Criteria<K> {
    List<K> meet(List<K> objects);

    boolean meet(K object);
}
