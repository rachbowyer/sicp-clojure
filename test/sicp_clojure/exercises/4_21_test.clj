(ns sicp-clojure.exercises.4-21-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercises.4-21 :refer :all]))

(defn- test-helper [f]
  (are [n result] (= result (f n))
      0   true
      1   false
      2   true
      3   false))

(deftest test-f1
  (test-helper f1))

(deftest test-f2
  (test-helper f2))