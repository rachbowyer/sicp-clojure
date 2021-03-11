(ns sicp-clojure.exercises.2-36
  (:require [sicp-clojure.paragraphs.2-2-3 :refer [s-accumulate]]
            [sicp-clojure.paragraphs.2-2-1 :refer [s-map]]))

(defn s-accumulate-n [op init seqs]
  (if (empty? (first seqs))
    nil
    (cons (s-accumulate op init (s-map #(first %) seqs))
          (s-accumulate-n op init (s-map #(rest %) seqs)))))

