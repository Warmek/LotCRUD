This file is a short comment about my design decision regarding this project.

I created the project to be as faithfull to the design documet as possible, but this came with some limitations. Particularly, the mappings were made significantly harder and less performent, as the connections between classed are mostly defined by couple of Strings.
This leads to 3 problems:

- Mapping by String is not performent
- It creates more complexity
- It leads to data duplication

The better way to do it would be to store a reference to connnected class in the main class [Example]. This would solve all tree of the problems.

[Example]
```java
public class mainClass{
    ...
    SecoundaryClass secondaryClass;
    ...
}
```

It would also made much easier creating relations on databases using Spring framework
