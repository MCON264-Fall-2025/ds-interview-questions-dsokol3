# S7 - Min Stack

## Problem Statement

Design a special stack data structure that supports all standard stack operations (`push`, `pop`, `top/peek`) **plus** an additional operation to retrieve the minimum element — all in **constant time O(1)**.

### Why is this challenging?

Normally, finding the minimum element in a stack requires traversing through the entire stack, which takes **O(n)** time. The Min Stack solves this by maintaining the minimum in **O(1)** time.

---

## Solution Approach

### Data Structures Used

| Stack | Purpose |
|-------|---------|
| **Main Stack (`st`)** | Stores all the values |
| **Auxiliary Stack (`minSt`)** | Keeps track of the current minimums |

### Key Invariant

> Every time you push or pop from the main stack, you also update the min stack so that the **top of the min stack always shows the current smallest value**.

---

## How the Code Works

### `push(x)`
1. Add `x` to the main stack `st`
2. If `minSt` is empty **or** `x <= minSt.peek()`, push `x` to `minSt`
3. Otherwise, push `minSt.peek()` again (the current min remains the same)

### `pop()`
1. Remove the top element from **both** `st` and `minSt`
2. This keeps both stacks aligned

### `getMin()`
1. Return the top of `minSt` — gives the minimum **instantly** in O(1)

---

## Step-by-Step Example

| Operation | Stack (`st`) | Min Stack (`minSt`) | Current Min |
|-----------|--------------|---------------------|-------------|
| `push(18)` | [18] | [18] | 18 |
| `push(19)` | [18, 19] | [18, 18] | 18 |
| `push(29)` | [18, 19, 29] | [18, 18, 18] | 18 |
| `push(15)` | [18, 19, 29, 15] | [18, 18, 18, 15] | 15 |
| `push(16)` | [18, 19, 29, 15, 16] | [18, 18, 18, 15, 15] | 15 |

---

## Time & Space Complexity

| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| `push()` | O(1) | O(1) |
| `pop()` | O(1) | O(1) |
| `peek()` | O(1) | O(1) |
| `getMin()` | O(1) | O(1) |

**Overall Space Complexity:** O(n) — where n is the number of elements in the stack (due to the auxiliary min stack)

---

## References

- [GeeksforGeeks - Design a Stack that supports getMin() in O(1) time and O(1) extra space](https://www.geeksforgeeks.org/dsa/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/)
- [Java Language Specification - Assertions](https://docs.oracle.com/javase/specs/jls/se8/html/jls-14.html#jls-14.10)
