# java-testing
A small Java project used to spike and demonstrate testing libraries and techniques

## Dependencies

| Artifact Id | Use | Version |
| --------------------: | ---- |---- |
| [mockito-core](https://mvnrepository.com/artifact/org.mockito/mockito-core) | Consider using `mockito-junit-jupiter` instead as it supports JUnit 5 | 3.5.5 |
| [mockito-all](https://mvnrepository.com/artifact/org.mockito/mockito-all) | Deprecated as it contains mockito, hamcrest and objenesis. Use mockito-core instead. | **Deprecated** |
| [mockito-junit-jupiter](https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter) | Mocking framework for JUnit 5 (Jupiter) | 3.5.5 |
| [junit-jupiter-api](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api) | JUnit Jupiter API for writing tests and extensions. You need both `junit-jupiter-api` and `junit-jupiter-engine` to write and run JUnit5 tests | **Use junit-jupiter instead** |
| junit-jupiter-engine | JUnit Jupiter test engine implementation, only required at runtime. You need both `junit-jupiter-api` and `junit-jupiter-engine` to write and run JUnit5 tests | **Use junit-jupiter instead** |
| [junit-jupiter](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter) | This contains everything needed to write and run JUNit 5 tests. [JUnit 5.4 provides](https://hub.packtpub.com/junit-5-4-released-with-an-aggregate-artifact-for-reducing-your-maven-and-gradle-files/) much simpler Maven configuration if your intent is to write JUnit 5 tests. Simply specify the aggregate artifact named [`junit-jupiter`](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter). This aggregate artifact in turn pulls the following three artifacts automatically, for your convenience: junit-jupiter-api (a compile dependency) junit-jupiter-params (a compile dependency) junit-jupiter-engine (a runtime dependency) In your project, you will also end up with: junit-platform-commons-1.4.0.jar junit-platform-engine-1.4.0.jar The above is what you need to write and run JUnit 5 tests based on the new Jupiter paradigm. | 5.6.2 |
| junit-vintage-engine | JUnit Vintage test engine implementation that allows to run vintage JUnit tests, i.e. tests written in the JUnit 3 or JUnit 4 style, on the new JUnit Platform. You only need `junit-vintage-engine` if (a) you are running with JUnit5 **and** (b) your test cases use JUnit4 constructs/annotations/rules etc. **Simply including this dependency automatically includes junit4 tests to be included when running maven-surefire-plugin (mvn test)**. | 5.6.2 |
|  junit-jupiter-migrationsupport | Provideds an annotation (`@EnableJUnit4MigrationSupport`) which essentially registers a bundh of extensions, i.e. JUnit 4's @Ignore annotation. Don't bother using it and instead register these extensions directly. | 5.6.2 |
| powermock-module-junit4 | #1 of 2 required dependencies for PowerMocks | 2.0.7 |
| powermock-api-mockito2 | #2 of 2 required dependencies for PowerMocks | 2.0.7 |
| powermock-core | Various utilities for accessing internals of a class. | 2.0.7 |
| junit-platform-runner |      | 1.6.2 |
| junit-platform-launcher | | 1.6.2 |

## Test Naming Conventions

https://docs.google.com/document/d/1YJiB45TCK5Kh-ZvPxOLzcFpjp57sn9LZBJ4-KVUoy6o/edit?usp=sharing