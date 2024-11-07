(ns opus-classical-clojure.core
  (:require
   [org.httpkit.server :as server]
   [ring.middleware.reload :refer [wrap-reload]]
   [opus-classical-clojure.routes :refer [router]]
   [environ.core :refer [env]])
  (:gen-class))

(def app
  (wrap-reload router {:dirs ["src/opus_classical_clojure"]}))

(defn -main [& _]
  (server/run-server app {:port 3000})) 
