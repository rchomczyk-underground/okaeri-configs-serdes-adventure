# okaeri-configs-serdes-adventure
An additional pack of serializers / transformers for [okaeri-configs](https://github.com/OkaeriPoland/okaeri-configs) library to support kyori's [adventure](https://github.com/KyoriPowered/adventure).

### Usage

```kotlin
SerdesKyori(supportsMiniMessage)
```

### Gradle
```kotlin
repositories {
    maven { url = uri("https://repo.rafal.moe/snapshots/") }
}

dependencies {
    implementation("moe.rafal:okaeri-configs-serdes-adventure:1.3-SNAPSHOT")
}
```