(ns sicp-clojure.core
  (:require [sicp-clojure.exercises.2-63 :refer [test-performance]])
  (:gen-class))

(defn -main [& _args]
  (test-performance))
