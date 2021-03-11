(ns sicp-clojure.exercises.mcons)

(defn mcons [h t]
  [(atom h) (atom t)])

(defn mcar [mcons]
  (-> mcons first deref))

(defn set-car! [mcons h]
  (swap! (first mcons) (constantly h))
  mcons)
