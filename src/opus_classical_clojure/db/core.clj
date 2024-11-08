(ns opus-classical-clojure.db.core
  (:require
   [next.jdbc :as jdbc]
   [hikari-cp.core :as hikari]
   [honey.sql :as sql]
   [opus-classical-clojure.config :refer [db-spec]]))

(defonce datasource
  (delay (hikari/make-datasource (db-spec))))

(defn get-connection []
  (jdbc/get-connection @datasource))

(defn init-db! []
  @datasource)

(defn query-honey
  [honey-query]
  (with-open [conn (get-connection)]
    (let [results (jdbc/execute! conn (sql/format honey-query))]
      (vec results))))