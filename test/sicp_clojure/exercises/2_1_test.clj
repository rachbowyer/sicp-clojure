; 
; Exercise 2.1
;
(ns sicp-clojure.exercises.2-1-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercises.2-1 :refer :all]))

(deftest make-rat-test
  (testing "make-rat"
    (is (= (make-rat 4 6) '(2 3)))
    (is (= (make-rat -4 6) '(-2 3)))
    (is (= (make-rat 4 -6) '(-2 3)))
    (is (= (make-rat -4 -6) '(2 3)))))

