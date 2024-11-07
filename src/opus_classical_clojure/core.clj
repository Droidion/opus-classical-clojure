(ns opus-classical-clojure.core
  (:require
   [org.httpkit.server :as server]
   [ring.middleware.reload :refer [wrap-reload]]
   [opus-classical-clojure.db.core :refer [init-db!]]
   [opus-classical-clojure.routes :refer [router]])
  (:gen-class))

(def app
  (wrap-reload router {:dirs ["src/opus_classical_clojure"]}))

(defn -main [& _]
  (init-db!)
  (server/run-server app {:port 3000})) 
