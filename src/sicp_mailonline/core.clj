(ns sicp-mailonline.core
  (:require [sicp-mailonline.exercises.2-63 :refer [test-performance]])
  (:gen-class))

(defn -main [& _args]
  (test-performance))
