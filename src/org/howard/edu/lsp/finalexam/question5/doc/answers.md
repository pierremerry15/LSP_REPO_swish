# Question 5 – Riel's Heuristics

**Name:** Pierre Merry

Heuristic 1:

Name: Minimize the Public Interface

A class should expose only what external clients need. Everything else should be private.

Explanation:
In lecture this was shown with getNextId() being public even though only used internally. External code could increment the counter without adding a request, corrupting the ID sequence.

---

Heuristic 2:

Name: Do Not Put Implementation Details in the Public Interface

A class should expose what it does, not how it does it.

Explanation:
In lecture this was discussed with returning a direct ArrayList reference. External code could modify the list without going through the class methods, breaking encapsulation.

---

Heuristic 3:

Name: A Class Should Capture One and Only One Key Abstraction

Each class should represent exactly one concept.

Explanation:
In lecture this was shown through the ETL pipeline refactoring. Splitting into Extractor, Transformer, Loader, and Pipeline gave each class one responsibility, making each independently testable.
