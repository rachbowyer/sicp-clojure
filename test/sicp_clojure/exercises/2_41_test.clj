;
; Exercise 2.41
; 
(ns sicp-clojure.exercises.2-41-test
  (:require [sicp-clojure.exercises.2-41 :refer :all]
            [clojure.test :refer :all]))

(def expected '([1 1 2] [1 2 1] [2 1 1]))

(deftest triples-less-or-equal-test
  (testing "with n=2 and s=4"
    (is (= expected (triples-less-or-equal 2 4)))))