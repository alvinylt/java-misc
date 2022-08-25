# java-misc

This is a repository of some simple Java scripts.

## ShiftCipher

`ShiftCipher` is an implementation of Caesar cipher encryption.

By inputting a shift factor within the range from -26 to 25,
a string can be encrypted. The code also demonstrates to use of ASCII character
codes.

The characters are case-sensitive and are always retained. Numbers and
special characters are not shifted. 

### Example

With the inputs `Hello` and `3`, the output `Khoor` is expected.

## RoutePlanner: Nearest Neighbour Algorithm

Given a list of coordinates and a starting location, `calcuateRoute` in
`RoutePlanner` orders the coordinates using the Nearest Neighbour Algorithm.

### Example

Suppose we have a list of coordinates: `[(1.0,2.0),(3.0,3.0),(1.5,1.5)]`. Let
the starting point be `(0.0,0.0)`. Then, the route is `calculateRoute(0.0,0.0)
== [(1.5, 1.5), (1.0, 2.0), (3.0, 3.0)]`.

@author: Alvin Tang <dev@alvinylt.net>

@last-updated: 2022-08-25
