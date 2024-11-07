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

For building client-side assets, have [Node.js](https://nodejs.org/en) and [pnpm](https://pnpm.io/) installed.

Install pnpm packages:

```sh
pnpm install
```

## Run locally

Running locally will use ring with hot reloading.

Create git-ignored file `profiles.clj` and add environment variable for db connection:

```clojure
{:dev
 {:env {:db-name "opus_classical"
        :db-host "localhost"
        :db-user "your_username"
        :db-password "your_password"
        :db-port "5432"}}}
```

```sh
lein ring server
```

In separate terminal, run:

```sh
pnpm dev
```

## Build and run for production

Build client assets:

```sh
pnpm build
```

Build jar file:

```sh
$ lein uberjar
```

Run jar file:

```sh
$ java -jar target/opus-classical-clojure-0.1.0-standalone.jar
```

## Tests

```sh
lein test
```
