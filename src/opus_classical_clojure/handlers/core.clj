(ns opus-classical-clojure.handlers.core)

(defn security-headers []
  {"Content-Security-Policy" "default-src 'self'; script-src 'self' https://cdn.jsdelivr.net; style-src 'self' https://cdn.jsdelivr.net; img-src 'self'"
   "X-Content-Type-Options" "nosniff"
   "X-Frame-Options" "DENY"
   "X-XSS-Protection" "1; mode=block"
   "Strict-Transport-Security" "max-age=31536000; includeSubDomains"
   "Referrer-Policy" "strict-origin-when-cross-origin"
   "Permissions-Policy" "geolocation=(), microphone=(), camera=()"})

(defn html-response [body]
  {:status 200
   :headers (merge {"Content-Type" "text/html"} (security-headers))
   :body body})