# Android Criteria 
Criteria is a small and simple library for filtering in memory data.

## Project News 
 * Just released version 0.1.1.

## Features
 * List filtering
 * Single item verification
 * And, Or, Xor and Not support

Android 4.0.3 and above support

## Usage
Import into your gradle project:
 ``` java
dependencies {
    ...
    compile 'com.rakangsoftware.criteria:criteria:0.1.1'
    ...
}
```
First you need to have your model object. To make this example clean and easy I will use String as model. 

### Data to use
Let's setup a list with names.
 ``` java
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
```

### Implement a Criterion
Since Criteria don't implement any real filter classes we need to create one our self, here is one for checking if a name contains a string.
 ``` java
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
```

### How to use
This code snippet will return a list with all names containing the letter 'a'.
``` java
Criterion contains = new NameCriterion("a");
List<String> result = contains.meet(data);
```

### How to AndCriteria
This code snippet will return a list with all names containing the letters 'a' and 'r'.
``` java
Criterion contains = new AndCriteria(new NameCriterion("a"), new NameCriterion("r"));
List<String> result = contains.meet(data);
```         

This code snippet will return a list with all names containing the letters 'a', 'r' and 'p'.
``` java
Criterion contains = new AndCriteria(new NameCriterion("a"), new NameCriterion("r"), new NameCriterion("p"));
List<String> result = contains.meet(data);
```         

### How to OrCriteria
This code snippet will return a list with all names containing the letter 'a' or 'r'.
``` java
Criterion contains = new OrCriteria(new NameCriterion("a"), new NameCriterion("r"));
List<String> result = contains.meet(data);
```         

This code snippet will return a list with all names containing the letter 'a', 'r' or 'p'.
``` java
Criterion contains = new OrCriteria(new NameCriterion("a"), new NameCriterion("r"), new NameCriterion("p"));
List<String> result = contains.meet(data);
```         

### How to XorCriteria
This code snippet will return a list with all names containing the letter 'a' or 'r' but not both of them.
``` java
Criterion contains = new XorCriteria(new NameCriterion("a"), new NameCriterion("r"));
List<String> result = contains.meet(data);
```         

This code snippet will return a list with all names containing the any of the letters 'a', 'r' or 'p' but only one of them.
``` java
Criterion contains = new XorCriteria(new NameCriterion("a"), new NameCriterion("r"), new NameCriterion("p"));
List<String> result = contains.meet(data);
```     

### How to NotCriteria
This code snippet will return a list with all names not containing the letter 'a'.
``` java
Criterion    contains = new NotCriterion(new NameCriterion("a"));
List<String> result   = contains.meet(getNames());
``` 

### Nested criteria.
Let's say we want all name containing 'a' or 'e' but not 'c'.

``` java
AndCriterion
|-- NotCriterion
|	`-- NameCriterion ('c')
`-- OrCriterion
 	|-- NameCriterion ('a')
 	`-- NameCriterion ('r')
```

``` java
Criterion<String> orCriterion = new OrCriteria(new NameCriterion("a"), new NameCriterion("r"));
Criterion<String> notCriterion = new NotCriterion<>(new NameCriterion("c"));
Criterion<String> andCriterion = new AndCriteria<>(orCriterion, notCriterion);
List<String> result = andCriterion.meet(data);
```

## License

    Copyright 2017 Per-Erik Bergman

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
