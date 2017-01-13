Fibonacci Java implementation
=============================

Problem
-------
This project implements the task of:

**Write a function (getValue(n)) that returns the n:th value in the following series:**
```
1,1,2,3,5,8,13,21,34,
```
Thus the n:th value is the sum of the two values before.

Examples: getValue(6) -> 8 and getValue(8) -> 21

Implementations
---------------

### BigNum

This is the most useful implementation since it theoretically works with no limitations and
practically works up until n = ~100 000 with acceptable performance (counting in seconds rather
than minutes on a modern desktop computer).

The implementation internally uses the Java BigInteger class to avoid overflow and accuracy errors.

The algorithm is in itself based on an Ordo(n) algorithm (same as below), but with the given
BigInteger implementation it can be observed experimentally to behave according to an Ordo(n*n)
behaviour.

### OrdoN
This is the simplest solution using an OrdoN algorithm. It loops through all values up to n,
remembering the last two result values for computing the next. Internally it uses the Java
long value making the math add computations maximum effective.

The implementation is extremely fast for low values of n and is only limited by the bit size
of the long value. Due to lackings in Java overflow mechanisms it refuses to accept any values
of n that would overflow the computations. Therefore it is rendered useless for n>93 and n<-93.

### Ordo1
This is the mathematical approach to the problem. This implementation uses the mathematics
of the golden ratio to calculate the results. This gives it an Ordo(1) performance which
makes it very attractable in theory.

However, the implementation is based on Java Double. Due to its precision limitations the
results becomes instable going beyond 64 bits (the Java Double is stored as 64 bit floating
point primitive) rendering results for n>70 or n<-68 potentially faulty.

This limitation makes the scalability benefits of the Ordo(1) algorithm severely limited and
the math computations needed are too expensive to make it competitive in the mid and foremost
the low range.

Negative values of n
--------------------
Although the fibonacci series normally applies for values of n>=0 it is possible to trace the
series backwards for numbers fulfilling the base criteria of fibonacci
( ```X(n)=X(n-1)+X(n-2)``` ).

All the current implementations support the negative scale of n either naturally (the Ordo1 impl.) or
using the likeness between the negative and the positive range - the negative range is
identical to the positive with the exception of an alternating negation.
E.g.

| n   | value | - n   | value |
| --- | ----- | ---- | ----- |
| 1   | 1     | -1   | 1     |
| 2   | 1     | -2   | -1    |
| 3   | 2     | -3   | 2     |
| 4   | 3     | -4   | -3    |

Running
-------
The code has been build using Gradle with a complete wrapper.
Only a Java JDK should be needed. However the code uses Java 8 features
(Lambda expressions). Hence the need for at least a JDK8 installed.

 To run the Main example just run it from the prompt using
```
 gradlew run
```

 To just make a build from scratch (including junit tests) execute:
```
 gradlew clean build
```

In case of any problems with java version, make sure that JAVA_HOME
points at the correct JDK.

Extensibility
-------------
It is possible to use some of the following techniques to extend or improve the implementations
further, although generally the basic arguments will normally apply albeit at a higher boundary.

* Using BigInteger (like in the BigNum impl) and similar solutions internally in stead of primitives
(there is a multitude of BigInt implementations with different strengths, weaknesses and price).
* Using more tweaked versions of formulas (there is several Math based versions that probably are
slightly easier to calculate)
* Handling known faulty values separately to increase supported span
* Tweaking the java code implementations for performance

