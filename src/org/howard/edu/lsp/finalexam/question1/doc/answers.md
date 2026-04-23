# Final Exam – Question 1 Answers

**Name:** Pierre Merry

## Part 1

Shared Resource #1: nextId — shared integer. Two threads can read the same value before either increments it, producing duplicate IDs.

Shared Resource #2: requests — shared ArrayList. Concurrent calls to addRequest() can corrupt the list.

Concurrency Problem: Race condition. Two threads call getNextId() simultaneously and both get the same ID.

Why addRequest() is unsafe: It performs two non-atomic operations — getNextId() and requests.add(). A thread can be interrupted between them.

## Part 2

Fix A: NOT correct. Synchronizing only getNextId() ensures unique IDs but does not protect requests.add() from concurrent modification.

Fix B: CORRECT. Synchronizing the entire addRequest() ensures both ID generation and list addition execute atomically.

Fix C: NOT correct. Only protects returning the list reference. Does nothing to prevent concurrent modification inside addRequest().

## Part 3

No, getNextId() should not be public. Per Riel's heuristics, minimize the public interface. It is only used internally by addRequest(). Making it public lets external code corrupt the ID sequence.

## Part 4

Description: Use AtomicInteger and CopyOnWriteArrayList. AtomicInteger.getAndIncrement() atomically reads and increments in one hardware operation without synchronized.

Code:
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new CopyOnWriteArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement();
        requests.add("Request-" + id + " from " + studentName);
    }
}
