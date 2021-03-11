(ns sicp-clojure.exercises.2-34
  (:require [sicp-clojure.paragraphs.2-2-3 :refer [s-accumulate]]))

(defn horner-eval [x coefficient-sequence]
  (->> coefficient-sequence
       (s-accumulate (fn [this-coeff higher-terms]
                      (+ (* x higher-terms) this-coeff))
                   0)))




