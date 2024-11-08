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

Have Clojure installed: https://clojure.org/guides/install_clojure

Install dependencies:

```sh
clojure -P
```

For building client-side assets, have [Node.js](https://nodejs.org/en) and [pnpm](https://pnpm.io/) installed.

Install pnpm packages:

```sh
pnpm install
```

## Run locally

Running locally will use ring with hot reloading.

Create git-ignored file `resources/config.edn` and add environment variable for db connection:

```clojure
{:db {:name #or [#env DB_NAME "opusclassical"]
      :host #or [#env DB_HOST "neon.tech"]
      :user #or [#env DB_USER "user"]
      :password #or [#env DB_PASSWORD "password"]
      :port #or [#env DB_PORT "5432"]}

 :server {:port #or [#env PORT "3000"]}

 :profile #or [#env ENVIRONMENT "dev"]}
```

```sh
clojure -M:ring
```

In separate terminal, run:

```sh
pnpm dev
```

## Check for outdated dependencies

Check for outdated dependencies:

```sh
clojure -M:outdated
```

Update dependencies:

```sh
clojure -M:outdated --upgrade
```

## Build and run for production

Build client assets:

```sh
pnpm build
```

Build jar file:

```sh
clojure -T:build uber
```

Run jar file:

```sh
$ java -jar target/opus-classical-clojure-0.1.0-standalone.jar
```

## Tests

```sh
clojure -X:test
```
