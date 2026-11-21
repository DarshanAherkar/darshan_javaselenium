# Selenium + TestNG Framework

Basic Maven project structure for Java UI automation with Selenium WebDriver and TestNG.

## Requirements

- JDK 11+
- Maven 3.6+
- Google Chrome (Selenium Manager downloads the matching driver automatically)

## Project layout

```
.
├── pom.xml
└── src
    ├── main
    │   ├── java                        # reusable framework code (Page Objects, utils)
    │   └── resources                   # framework config, test data
    └── test
        ├── java
        │   └── com/example/tests
        │       ├── BaseTest.java          # browser setup/teardown
        │       └── SauceDemoTest.java     # sample smoke test (saucedemo.com)
        └── resources
            └── testng.xml                 # TestNG suite definition
```

## Commands

```bash
# compile tests only
mvn test-compile

# run the TestNG suite
mvn test

# run headless (no visible browser)
mvn test -Dheadless=true

# run a single class
mvn test -Dtest=SauceDemoTest
```

## Adding tests

1. Create a class in `src/test/java/com/example/tests` that extends `BaseTest`.
2. Add `@Test` methods using the inherited `driver`.
3. Register the class in `src/test/resources/testng.xml` (or run it with `-Dtest`).

For a larger suite, add `pages` (Page Objects) and `utils` packages under
`src/main/java`, plus config/test data under `src/main/resources`.
