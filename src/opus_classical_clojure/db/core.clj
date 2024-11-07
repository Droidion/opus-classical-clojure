(ns opus-classical-clojure.db.core
  (:require
   [next.jdbc :as jdbc]
   [hikari-cp.core :as hikari]
   [honey.sql :as sql]
   [environ.core :refer [env]]))

(def datasource-options
  {:adapter       "postgresql"
   :database-name (or (env :db-name) "opus_classical")
   :server-name   (or (env :db-host) "localhost")
   :username      (or (env :db-user) "postgres")
   :password      (or (env :db-password) "postgres")
   :port-number   (or (env :db-port) 5432)})

(defonce datasource
  (delay (hikari/make-datasource datasource-options)))

(defn get-connection []
  (jdbc/get-connection @datasource))

(defn init-db! []
  @datasource)

(defn query-honey
  [honey-query]
  (with-open [conn (get-connection)]
    (let [results (jdbc/execute! conn (sql/format honey-query))]
      (vec results))))