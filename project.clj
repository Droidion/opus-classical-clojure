(defproject opus-classical-clojure "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [ring/ring-jetty-adapter "1.13.0"]
                 [ring/ring-core "1.13.0"]
                 [ring/ring-devel "1.13.0"]
                 [http-kit "2.8.0"]
                 [metosin/reitit "0.7.2"]
                 [metosin/reitit-ring "0.7.2"]
                 [environ "1.2.0"]
                 [hiccup "2.0.0-RC3"]]
  :plugins [[lein-ancient "1.0.0-RC3"] [lein-ring "0.12.6"] [lein-environ "1.2.0"]]
  :ring {:handler opus-classical-clojure.core/app :port 3000}
  :main ^:skip-aot opus-classical-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
