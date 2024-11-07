(ns opus-classical-clojure.core
  (:require [reitit.ring :as ring]
            [org.httpkit.server :as server]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [hiccup.page :as page])
  (:gen-class))

(defn html-response [body]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body body})

(defn handler [_]
  (html-response
   (page/html5                                 ; Using hiccup to generate HTML
    [:head
     [:title "My Clojure Website"]]
    [:body
     [:h1 "Hello World!"]
     [:p "Welcome to my website"]])))

(def app
  (ring/ring-handler
   (ring/router
    [["/" {:get handler}]])
   (ring/create-default-handler)
   {:middleware [[wrap-resource "public"]
                 wrap-content-type]}))

(defn -main [& args]
  (server/run-server app {:port 3000}))
