# Question 2 – Design Explanation

The Template Method pattern is implemented through the abstract Report class, which defines the fixed workflow in generateReport() declared as final so no subclass can alter the sequence: loadData() then formatHeader() then formatBody() then formatFooter(). The four steps are declared protected abstract, forcing StudentReport and CourseReport to provide their own implementations. The Driver demonstrates polymorphism by storing both types in a List<Report> and calling generateReport() on each.
