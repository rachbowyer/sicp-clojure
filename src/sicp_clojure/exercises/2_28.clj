;
; Exercise 2.28
;

(ns sicp-clojure.exercises.2-28)

(defn fringe [x]
  (cond
    (nil? x)              nil
    (not (seq? x))        (list x)
    (empty? x)            nil
    :else                 (concat (fringe (first x))
                                  (fringe (rest x)))))
