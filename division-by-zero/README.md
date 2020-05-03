# Division by Zero

## Run from the command line

```shell
cd division-by-zero
./gradlew clean :use-plugin:shadowJar
java -jar use-plugin/build/libs/use-plugin-all.jar
```

This will print an error message:

```shell
Division by zero being attempted!
```
