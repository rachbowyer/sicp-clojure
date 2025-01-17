(ns sicp-clojure.exercises.2-33
  (:require [sicp-clojure.paragraphs.2-2-3 :refer [s-accumulate]]))

;;
;; Exercise 2.33
;;

(defn s-map [p sequence]
  (s-accumulate (fn [a b] (cons (p a) b)) nil sequence))

(defn s-append [seq1 seq2]
  (s-accumulate cons seq2 seq1))

(defn s-length [sequence]
  (s-accumulate (fn [_ acc] (inc acc)) 0 sequence))
