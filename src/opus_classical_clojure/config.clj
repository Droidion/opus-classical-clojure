(ns opus-classical-clojure.config
  (:require [aero.core :as aero]
            [clojure.java.io :as io]))

(defn config
  ([] (config {}))
  ([opts]
   (let [config-file (if (.exists (io/file "resources/config.edn"))
                       "config.edn"
                       "config.default.edn")]
     (aero/read-config (io/resource config-file) opts))))

;; Helper functions to get specific config values
(defn db-spec []
  (let [conf (config)
        db (:db conf)]
    {:adapter "postgresql"
     :database-name (:name db)
     :server-name (:host db)
     :username (:user db)
     :password (:password db)
     :port-number (:port db)}))