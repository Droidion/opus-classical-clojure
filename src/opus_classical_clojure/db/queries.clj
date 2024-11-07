(ns opus-classical-clojure.db.queries
  (:require [opus-classical-clojure.db.core :refer [query-honey]]))

(defn get-composers []
  (query-honey
   {:select [:id :name :year_start :year_end :slug]
    :from [:periods]}))