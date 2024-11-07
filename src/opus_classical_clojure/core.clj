(ns opus-classical-clojure.core
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]
            [org.httpkit.server :as server]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.reload :refer [wrap-reload]]
            [hiccup.page :as page])
  (:gen-class))

(defn html-response [body]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body body})

(defn layout [title & content]
  (page/html5
   [:head
    [:title title]
    [:script {:src "https://cdn.jsdelivr.net/npm/@unocss/runtime"}]
    [:link {:rel "stylesheet" :href "https://cdn.jsdelivr.net/npm/@unocss/reset/tailwind.min.css"}]]
   [:body
    [:header
     [:h1 {:class "text-4xl"} title]]
    content]))

(defn handler [_]
  (html-response
   (layout "Home"
           [:p "Welcodddme to my website"])))

(def app
  (-> (ring/ring-handler
       (ring/router
        [["/" {:get handler}]])
       (ring/create-default-handler))
      (wrap-reload {:dirs ["src/opus_classical_clojure"]})
      (wrap-resource "public")
      wrap-content-type))

(defn -main [& args]
  (server/run-server app {:port 3000})) 
