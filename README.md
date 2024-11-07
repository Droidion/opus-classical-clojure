# Opus Classical Clojure

Opus Classical now uses Clojure.

## Installation

Have Java installed.

Recommend using [SDKMan](https://sdkman.io/) to install Java.

Recommend using Java 23.

```sh
sdk install java 23.0.1-tem
```

Have Leiningen installed.

```sh
sdk install lein
```

Have Clojure installed: https://clojure.org/guides/install_clojure

Install dependencies:

```sh
lein deps
```

## Run locally

```sh
lein run
```

## Run with Docker

```sh
docker compose up
```

## Build jar file

```sh
$ lein uberjar
$ java -jar target/opus-classical-clojure-0.1.0-standalone.jar
```

## Tests

```sh
lein test
```
