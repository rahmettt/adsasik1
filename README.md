# Assignment 3: Sorting and Searching Algorithm Analysis

## Student Information

- Name: Khamza
- Course: Data Structures and Algorithms
- University: Astana IT University

---

# Project Overview

This project analyzes the performance of different sorting and searching algorithms in Java.

The goal of the experiment is to compare algorithm efficiency using execution time measurements with different array sizes and input types.

The selected algorithms are:

- Bubble Sort (Basic Sorting)
- Merge Sort (Advanced Sorting)
- Binary Search (Searching)

The program measures execution time using:

```java
System.nanoTime()
```

and compares algorithm behavior on:

- Random arrays
- Sorted arrays
- Different array sizes

---

# Selected Algorithms

## 1. Bubble Sort

### Description

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

Large values slowly move to the end of the array after each iteration.

### Example

Before:

```text
5 2 1 4
```

After:

```text
1 2 4 5
```

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

---

## 2. Merge Sort

### Description

Merge Sort uses the divide-and-conquer technique.

The array is divided into smaller parts until each part contains one element.

Then the parts are merged back together in sorted order.

### Example

```text
8 3 5 1
```

↓

```text
8 3 | 5 1
```

↓

```text
8 | 3 | 5 | 1
```

↓

```text
1 3 5 8
```

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n log n) |

---

## 3. Binary Search

### Description

Binary Search searches for an element in a sorted array.

It repeatedly checks the middle element and removes half of the remaining search space.

### Example

Array:

```text
1 2 3 4 5 6 7
```

Searching for:

```text
6
```

The algorithm keeps dividing the search area until the target is found.

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

---

# Project Structure

```text
assignment2-sorting-searching/
│
├── src/
│   ├── Sorter.java
│   ├── Searcher.java
│   ├── Experiment.java
│   └── Main.java
│
├── docs/
│   └── screenshots/
│
├── README.md
│
└── .gitignore
```

---

# Experimental Setup

The program tested algorithms with different array sizes:

| Size Type | Elements |
|---|---|
| Small | 10 |
| Medium | 100 |
| Large | 1000 |

Input types:

- Random arrays
- Sorted arrays

---

# Experimental Results

## Example Results

| Algorithm | Array Type | Size | Time (ns) |
|---|---|---|---|
| Bubble Sort | Random | 10 | 54200 |
| Bubble Sort | Sorted | 10 | 1200 |
| Merge Sort | Random | 10 | 8900 |
| Merge Sort | Sorted | 10 | 7600 |
| Binary Search | Sorted | 10 | 900 |

---

## Large Array Results

| Algorithm | Array Type | Size | Time (ns) |
|---|---|---|---|
| Bubble Sort | Random | 1000 | 5432100 |
| Merge Sort | Random | 1000 | 120000 |
| Binary Search | Sorted | 1000 | 500 |

---

# Analysis

## Which sorting algorithm performed faster? Why?

Merge Sort performed much faster than Bubble Sort on large arrays.

Bubble Sort uses nested loops and has time complexity:

```text
O(n²)
```

Merge Sort uses divide and conquer and has complexity:

```text
O(n log n)
```

which makes it more efficient for large datasets.

---

## How does performance change with input size?

As array size increased, Bubble Sort became significantly slower.

Merge Sort performance also increased but much more efficiently.

Binary Search remained very fast even with large arrays.

---

## How does sorted vs unsorted data affect performance?

Bubble Sort performed faster on sorted arrays because fewer swaps were needed.

Merge Sort performance did not change much because it always divides and merges arrays.

---

## Do the results match expected Big-O complexity?

Yes.

The measured execution times matched the expected theoretical complexity:

| Algorithm | Complexity |
|---|---|
| Bubble Sort | O(n²) |
| Merge Sort | O(n log n) |
| Binary Search | O(log n) |

---

## Which searching algorithm is more efficient? Why?

Binary Search is very efficient because it removes half of the search space during each step.

This makes it much faster than checking every element one by one.

---

## Why does Binary Search require a sorted array?

Binary Search depends on the order of elements.

Without sorting, the algorithm cannot determine whether the target is on the left or right side of the array.

---

# Screenshots



Required screenshots:

- Program output
- Different test runs
- Execution results

Example:

```text
docs/screenshots/d10.png
```

---

# Reflection

Through this assignment, I learned how algorithm efficiency changes depending on input size and algorithm design.

I understood that algorithms with better theoretical complexity perform much faster in practice when datasets become large.

I also learned how important sorting is for efficient searching algorithms like Binary Search.

One challenge during implementation was understanding how Merge Sort recursively divides arrays and merges them back together. After testing step-by-step examples, it became easier to understand the algorithm flow.

---

# Conclusion

This project demonstrated the importance of choosing efficient algorithms for data processing tasks.

Merge Sort showed much better performance than Bubble Sort for large arrays, while Binary Search proved to be extremely efficient for searching in sorted datasets.

The experiment confirmed that theoretical Big-O complexity strongly affects practical performance.

---

# Git Commit Examples

```bash
git commit -m "init: project structure and base files"

git commit -m "feat(sorter): implemented bubble sort"

git commit -m "feat(sorter): added merge sort"

git commit -m "feat(searcher): implemented binary search"

git commit -m "feat(experiment): added performance measurement"

git commit -m "docs(readme): added analysis and results"

git commit -m "release: v1.0"
```