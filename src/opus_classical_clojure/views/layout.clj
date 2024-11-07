(ns opus-classical-clojure.views.layout
  (:require [hiccup.page :as page]))

(defn layout [title & content]
  (page/html5
   [:head
    [:title title]
    [:link {:rel "stylesheet" :href "styles.css"}]]
   [:body
    [:header
     [:h1 {:class "text-4xl"} title]]
    content]))