# AI Usage – Question 1

AI Tools Used: Claude (Anthropic)

Prompts Used:
1. What is a race condition in Java?
2. Why is synchronizing only getNextId() not enough?
3. How does AtomicInteger.getAndIncrement() work?

How AI Helped:
Claude clarified that thread safety must be considered at the level of complete operations not individual methods, and explained how AtomicInteger eliminates locking overhead.

Reflection:
I learned that java.util.concurrent offers cleaner alternatives to synchronized for simple atomic operations.
