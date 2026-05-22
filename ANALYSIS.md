# Task 2 Analysis

## 1. Exact cause of ConcurrentModificationException

ConcurrentModificationException occurs when a collection
is modified while it is being iterated using an Iterator
or enhanced for-loop.

---

## 2. Most likely code pattern

```java
for (Transaction t : transactions) {
    transactions.remove(t);
}
```

---

## 3. Minimal safe fix

```java
Iterator<Transaction> it = transactions.iterator();

while (it.hasNext()) {

    Transaction t = it.next();

    if (condition) {
        it.remove();
    }
}
```