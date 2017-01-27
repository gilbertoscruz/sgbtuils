# SGBUtils - Biblioteca

Biblioteca para aplicativos Android


# utilizar

Arquivo: build.gradle (root)

```groovy

allProjects {
  repositories {
    // required to find the project's artifacts
    maven { url "https://www.jitpack.io" }
  }
}
```

Adicione a biblioteca a nivel do projeto no arquivo build.gradle

```groovy

  def sgbutils_version = "1.0.4"
  
  dependencies {
     ...
     compile 'com.github.gilbertoscruz:sgbtuils:${sgbutils_version}'
  }
```
