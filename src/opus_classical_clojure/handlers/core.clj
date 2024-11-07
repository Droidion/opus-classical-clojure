(ns opus-classical-clojure.handlers.core)

(defn html-response [body]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body body})