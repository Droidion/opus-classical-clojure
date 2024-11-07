(ns opus-classical-clojure.views.pages.composers
  (:require [environ.core :refer [env]]))

(defn composers-page []
  [:p (or (env :database-url) "No database URL configured")])