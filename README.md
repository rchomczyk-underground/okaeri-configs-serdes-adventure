# okaeri-configs-serdes-adventure
An additional pack of serializers / transformers for [okaeri-configs](https://github.com/OkaeriPoland/okaeri-configs) library to support kyori's [adventure](https://github.com/KyoriPowered/adventure).

#### Build and publish artifact
The most important step is to build final artifact and publish it into 
maven's cache, by use of `mvn clean install` command.

#### Include dependency in your project

### Gradle
```kotlin
repositories {
    mavenLocal()
}

dependencies {
    implementation("moe.rafal:okaeri-configs-serdes-adventure:2.1-SNAPSHOT")
}
```