```bash
./gradlew test
```

```
> Task :test FAILED

MyControllerTest > hello() FAILED
    jakarta.servlet.ServletException at MyControllerTest.kt:17
        Caused by: java.lang.ClassCastException at MyControllerTest.kt:17

2 tests completed, 1 failed

FAILURE: Build failed with an exception.
```

Using `./gradlew test --info`, one can also see the exception:

```
MyControllerTest > hello() FAILED
    jakarta.servlet.ServletException: Request processing failed: java.lang.ClassCastException:
       class kotlinx.serialization.json.internal.StreamingJsonEncoder cannot be cast to class com.github.avrokotlin.avro4k.encoder.FieldEncoder
      (kotlinx.serialization.json.internal.StreamingJsonEncoder and com.github.avrokotlin.avro4k.encoder.FieldEncoder are in unnamed module of loader 'app')
```
