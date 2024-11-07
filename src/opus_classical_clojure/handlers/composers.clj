(ns opus-classical-clojure.handlers.composers
  (:require [opus-classical-clojure.handlers.core :refer [html-response]]
            [opus-classical-clojure.views.layout :refer [layout]]
            [opus-classical-clojure.views.pages.composers :refer [composers-page]]
            [opus-classical-clojure.db.queries :refer [get-composers]]))

(defn composers-handler [_]
  (html-response
   (layout "Composers" (composers-page (get-composers)))))