# 🧱 Minimum Stack (O(1) getMin Implementation)

## 🎯 Objective
Design a special stack data structure that supports:

- Standard stack operations: `push()`, `pop()`, and `peek()`
- An additional operation: `getMin()` — retrieves the minimum element
- **All in constant time — O(1)**

Normally, finding the minimum in a stack requires scanning all elements (**O(n)**).  
This design achieves the same result in **O(1)** using an auxiliary structure.

---

## ⚙️ Core Logic
We use **two stacks**:

- **Main Stack (`st`)** — stores all elements
- **Min Stack (`minSt`)** — tracks the current minimum after each push/pop

**Invariant (always true):**
> The top of `minSt` always represents the minimum value of the current `st`.

---

## 🧩 Operations

### 🔹 Push(x)
1. Push `x` onto `st`
2. If `minSt` is empty or `x <= minSt.peek()`, push `x` to `minSt`
3. Otherwise, push `minSt.peek()` again to keep the current minimum unchanged

### 🔹 Pop()
- Pop from **both** `st` and `minSt` to keep them aligned

### 🔹 getMin()
- Simply return `minSt.peek()` — retrieves the current minimum in **O(1)** time

---

## 🧠 Example Operation Flow

| Operation | Stack (`st`)        | Min Stack (`minSt`) | Current Min |
|------------|--------------------|---------------------|--------------|
| push(18)   | [18]               | [18]                | 18           |
| push(19)   | [18, 19]           | [18, 18]            | 18           |
| push(29)   | [18, 19, 29]       | [18, 18, 18]        | 18           |
| push(15)   | [18, 19, 29, 15]   | [18, 18, 18, 15]    | 15           |
| push(16)   | [18, 19, 29, 15, 16]| [18, 18, 18, 15, 15]| 15           |

---

## 🧪 Testing
JUnit tests are used to verify correctness of:
- Stack operations (`push`, `pop`, `peek`)
- Minimum retrieval logic (`getMin()`)
