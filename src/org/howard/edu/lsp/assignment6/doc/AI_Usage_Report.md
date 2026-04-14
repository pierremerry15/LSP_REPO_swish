# AI Usage Report – Assignment 6

**Name:** Pierre Merry
**Course:** CSCI 363 – Large Scale Programming
**Assignment:** 6 – JUnit 5 Testing for IntegerSet

---

## AI Tools Used
Tool: Claude (Anthropic) – claude.ai

---

## Conversation 1: Planning What to Test

**Prompt:**
"I need to write JUnit 5 tests for my IntegerSet class. Every method needs
a normal case and an edge case. Can you help me think through what edge
cases make sense for each method before I start writing?"

**Response Summary:**
Claude walked through every method and suggested specific edge cases for
each one. For add() it said to test adding a duplicate and confirm the
length stays the same. For remove() it said to test removing a value that
doesnt exist and make sure nothing breaks. For equals() it pointed out
that since sets are order independent I should test two sets with the same
values added in different orders. For largest() and smallest() it said to
test with a single element and also test that an exception gets thrown on
an empty set. For union() it suggested testing with one empty set. For
intersect() it said to test when there are no common elements. For diff()
it said to test when both sets are identical so the result should be empty.
For complement() it said to test with completely disjoint sets.

**What I used:**
This gave me a full roadmap before I wrote a single line of test code.
Almost every edge case Claude suggested matched exactly what the assignment
rubric required which made it easy to make sure I had full coverage.

---

## Conversation 2: JUnit 5 assertThrows Syntax

**Prompt:**
"How do I test that a method throws an exception in JUnit 5? I want to
make sure largest() throws IllegalStateException when the set is empty
but I've never used assertThrows before."

**Response Summary:**
Claude explained that assertThrows takes two arguments — the expected
exception class and a lambda that calls the method. It showed the exact
syntax: assertThrows(IllegalStateException.class, () -> set.largest()).
It also explained why lambdas are used here instead of just calling the
method directly — because you need to pass the behavior to assertThrows
so it can catch the exception rather than letting it crash the test.

**What I used:**
Used this exact pattern for both the largest() and smallest() exception
tests. Before asking I wasnt sure if I needed a try/catch block or if
assertThrows handled everything automatically — Claude confirmed assertThrows
handles it all on its own.

---

## Conversation 3: Import Errors in JUnit Test File

**Prompt:**
"My IntegerSetTest.java file has import errors. Line 4 says
'import x.jupiter.api.DisplayName' and it cant be resolved. How do I fix
the import for DisplayName in JUnit 5?"

**Response Summary:**
Claude immediately spotted that the import was wrong — x.jupiter should
be org.junit.jupiter. The correct import is:
import org.junit.jupiter.api.DisplayName;
It also reminded me that all three imports need to start with org.junit
and that the static import for Assertions needs the wildcard at the end.

**What I used:**
Fixed the broken import directly. This was causing 30+ errors in the file
because every single @DisplayName annotation was unresolved. One line fix
cleared all of them.

---

## Conversation 4: Test Organization and Structure

**Prompt:**
"Should I use @DisplayName annotations on my tests? And is there a clean
way to organize a large test file with this many methods?"

**Response Summary:**
Claude said @DisplayName is good practice because it makes the test output
in the console much easier to read — instead of seeing testClearNormal()
you see the full description like Test clear() on non-empty set. It
suggested grouping tests by method using comment headers as dividers so
the file is easy to navigate. It also said to name test methods
descriptively so the intent is clear even without the DisplayName.

**What I used:**
Added @DisplayName to every single test method and organized the file
into sections with comment headers for each method. Made the file a lot
cleaner to read and navigate especially with this many tests.

---

## Conversation 5: Verifying toString() Format

**Prompt:**
"The assignment says toString() must return values in ascending order
formatted exactly like [1, 2, 3] with no extra spaces. Does Java's
default ArrayList toString() already do that or do I need to format it
myself?"

**Response Summary:**
Claude confirmed that Java's List.toString() produces exactly the format
[1, 2, 3] with comma-space separators which matches the requirement.
However it warned that the output wont be sorted unless I explicitly sort
first. It suggested creating a copy of the list, sorting the copy with
Collections.sort(), and calling toString() on the copy so the original
set order is not changed as a side effect of printing.

**What I used:**
Wrote the toString() test using assertEquals("[1, 2, 3]", set.toString())
after adding elements out of order to confirm sorting works. Also wrote
the empty set test using assertEquals("[]", set.toString()) since the
assignment specifically called that out as a required edge case.

---

## External References
- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
- Java Collections docs: https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
- Java ArrayList docs: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
