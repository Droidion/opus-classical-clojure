# Opus Classical Clojure

[![Clojure CI](https://github.com/Droidion/opus-classical-clojure/actions/workflows/cicd.yml/badge.svg)](https://github.com/Droidion/opus-classical-clojure/actions/workflows/cicd.yml)

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

Running locally will use ring with hot reloading.

```sh
lein ring server
```

## Run with Docker in production mode

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
