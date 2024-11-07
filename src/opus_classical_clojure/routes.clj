(ns opus-classical-clojure.routes
  (:require [reitit.ring :as ring]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [opus-classical-clojure.handlers.composers :refer [composers-handler]]))

(def routes
  [["/" {:get composers-handler}]])

(def router
  (-> (ring/ring-handler
       (ring/router routes)
       (ring/create-default-handler))
      (wrap-resource "public")
      wrap-content-type))