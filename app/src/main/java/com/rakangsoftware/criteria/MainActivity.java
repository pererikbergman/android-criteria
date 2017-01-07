package com.rakangsoftware.criteria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import criteria.rakangsoftware.com.criteria.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testAndCriteria();
        testOrCriteria();
        testXorCriteria();
        testNotCriteria();
        testNestedCriteria();
    }

    private void testAndCriteria() {
        Criterion<String> contains = new AndCriteria<>(new NameCriterion("a"), new NameCriterion("r"));
        List<String>      result   = contains.meet(getNames());

        dumpArray("AndCriteria 1", result);

        contains = new AndCriteria<>(new NameCriterion("a"), new NameCriterion("r"), new NameCriterion("p"));
        result = contains.meet(getNames());

        dumpArray("AndCriteria 2", result);
    }

    private void testOrCriteria() {
        Criterion<String> contains = new OrCriteria<>(new NameCriterion("a"), new NameCriterion("r"));
        List<String>      result   = contains.meet(getNames());

        dumpArray("OrCriteria 1", result);

        contains = new OrCriteria<>(new NameCriterion("a"), new NameCriterion("r"), new NameCriterion("p"));
        result = contains.meet(getNames());

        dumpArray("OrCriteria 2", result);
    }

    private void testXorCriteria() {
        Criterion<String> contains = new XorCriteria<>(new NameCriterion("a"), new NameCriterion("r"));
        List<String>      result   = contains.meet(getNames());

        dumpArray("XorCriteria 1", result);

        contains = new XorCriteria<>(new NameCriterion("a"), new NameCriterion("r"), new NameCriterion("p"));
        result = contains.meet(getNames());

        dumpArray("XorCriteria 2", result);
    }

    private void testNotCriteria() {
        Criterion<String> contains = new NotCriterion<>(new NameCriterion("a"));
        List<String>      result   = contains.meet(getNames());

        dumpArray("NotCriterion", result);
    }

    private void testNestedCriteria() {
        Criterion<String> orCriterion  = new OrCriteria<>(new NameCriterion("a"), new NameCriterion("r"));
        Criterion<String> notCriterion = new NotCriterion<>(new NameCriterion("c"));
        Criterion<String> andCriterion = new AndCriteria<>(orCriterion, notCriterion);
        List<String>      result       = andCriterion.meet(getNames());

        dumpArray("NestedCriterion", result);
    }


    private void dumpArray(final String testName, final List<String> result) {
        Log.d(TAG, "-----" + testName + "-----");
        for (String name : result) {
            Log.d(TAG, "Name: " + name);
        }
    }

    private List<String> getNames() {
        List<String> data = new ArrayList<>();
        data.add("Silas");
        data.add("Carmen");
        data.add("Joan");
        data.add("Michele");
        data.add("Kari");
        data.add("Marjorie");
        data.add("Johnette");
        data.add("Jason");
        data.add("Marya");
        data.add("Ola");

        return data;
    }
}
