(ns opus-classical-clojure.views.pages.composers)

(defn composers-page [composers]
  [:div
   [:h1 "Periods"]
   [:div.composers-grid
    (for [{:periods/keys [name year_start year_end slug]} composers]
      [:div.composer {:key slug}
       [:h2 name]
       [:p (str year_start " - " year_end)]])]])