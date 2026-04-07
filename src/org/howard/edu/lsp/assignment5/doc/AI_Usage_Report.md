cat > src/org/howard/edu/lsp/assignment5/doc/AI_Usage_Report.md << 'EOF'
# AI Usage Report – Assignment 5

**Name:** Pierre Merry
**Course:** CSCI 363 – Large Scale Programming
**Assignment:** 5 – IntegerSet Implementation

---

## AI Tools Used
Tool: Claude (Anthropic) – claude.ai

---

## Conversation 1: Understanding the Assignment

**Prompt:**
"Hey so I have this assignment where I need to build an IntegerSet class
in Java. It needs a bunch of methods like union, intersect, diff, complement,
equals, largest, smallest, add, remove, and toString. Can you break down
what each one is supposed to do?"

**Response Summary:**
Claude broke down each method in plain terms. The biggest thing that helped
was understanding the difference between diff and complement since I kept
mixing them up. It also reminded me that a set cant have duplicates which
I already knew but good to confirm before writing any code.

**What I changed:**
I mostly used this to make sure I understood the requirements before jumping
into coding. Did not copy any code from this conversation.

---

## Conversation 2: Class Structure

**Prompt:**
"Should I use an ArrayList or LinkedList for storing the integers inside
the IntegerSet class? And should it be private?"

**Response Summary:**
Claude said ArrayList was the better choice for this since its easier to
work with and faster for random access. It confirmed the list should be
private so nothing outside the class can mess with it directly.

**What I changed:**
I went with the ArrayList suggestion. The encapsulation part I already
knew from class but it confirmed I was on the right track.

---

## Conversation 3: The equals() Method

**Prompt:**
"I need equals() to return true even if the elements are in a different
order. Like [1,2,3] and [3,2,1] should be equal. How do I do that without
breaking anything else?"

**Response Summary:**
Claude said to sort both lists before comparing but to use copies so I
dont accidentally change the order of the actual sets. It suggested making
two temporary ArrayLists, sorting those, then using .equals() to compare.

**What I changed:**
I had originally sorted the real lists which was messing up my toString
output. Switched to sorting copies instead which fixed it.

---

## Conversation 4: remove() Not Working

**Prompt:**
"My remove method is deleting the wrong element. I wrote set.remove(2)
and instead of removing the value 2 it removed whatever was at index 2.
How do I fix this?"

**Response Summary:**
Claude explained that ArrayList.remove() is overloaded and when you pass
a plain int it removes by index not by value. The fix is to wrap it in
Integer.valueOf() so Java knows youre removing an object not an index.

**What I changed:**
Changed set.remove(item) to set.remove(Integer.valueOf(item)). This was
honestly really annoying to debug so glad I asked about it.

---

## Conversation 5: Union, Intersect, Diff, Complement Logic

**Prompt:**
"Can you walk me through union, intersect, diff and complement with an
example? I want to make sure I have the logic right before I code it.
Using Set1 = [1,2,3] and Set2 = [2,3,4]."

**Response Summary:**
Claude walked through all four with that exact example which matched what
was in the assignment. The main thing I took away was that all four need
to return a brand new IntegerSet and not touch the original sets at all.

**What I changed:**
I had union adding elements directly to this.set which was wrong. Switched
to creating a new IntegerSet result and adding to that instead.

---

## Conversation 6: toString() Format

**Prompt:**
"The assignment wants toString to return something like [1, 2, 3] in
ascending order. Java's default ArrayList toString already looks like that
so can I just return set.toString() directly?"

**Response Summary:**
Claude said the format is right but the order wont be guaranteed unless I
sort first. Suggested copying the list, sorting the copy, then calling
toString on the copy so the original doesnt get reordered.

**What I changed:**
Added a sorted copy before calling toString. Also added the @Override
annotation since the assignment specifically required it.

---

## Conversation 7: Exceptions for largest() and smallest()

**Prompt:**
"What should largest() and smallest() do if the set is empty? Should I
return like -1 or throw an exception?"

**Response Summary:**
Claude said throwing an exception is better than returning -1 because -1
could actually be a valid value in the set. Recommended IllegalStateException
with a message saying the set is empty.

**What I changed:**
Added the isEmpty() check at the top of both methods and threw
IllegalStateException. Made sense once Claude explained why -1 was a bad idea.

---

## Conversation 8: Javadocs

**Prompt:**
"Can you write Javadoc comments for my IntegerSet class? Here is the code."
(pasted full class)

**Response Summary:**
Claude generated Javadocs for everything including @param, @return, and
@throws tags. It also added @author and @version to the class header.

**What I changed:**
Reviewed all of it and rewrote some of the descriptions in my own words.
Kept the structure and tags but made sure the wording matched what my code
actually does.

---
