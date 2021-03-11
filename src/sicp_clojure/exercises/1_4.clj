(ns sicp-clojure.exercises.1-4)

; Exercise 1.4
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))
