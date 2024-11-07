(ns opus-classical-clojure.views.layout
  (:require [hiccup.page :as page]))

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