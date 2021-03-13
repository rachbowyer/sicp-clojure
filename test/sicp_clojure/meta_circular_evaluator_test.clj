(ns sicp-clojure.meta-circular-evaluator-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.meta-circular-evaluator :as mce]))

(def ^:private example1
  '((QUOTE +) 1 1))

(def ^:private example2
  '((LAMBDA (x) x) 2))

(def ^:private example3
  '(((LAMBDA (x) (LAMBDA (y) y)) 2) 3))

(def ^:private example4
  '(((LAMBDA (x) (LAMBDA (y) ((QUOTE +) x y))) 2) 3))

(def ^:private example5
  'true)

(def ^:private example6
  '(COND (true 1) (ELSE 2)))

(def ^:private example7
  '(COND (false 1) (ELSE 2)))

(def ^:private all-examples
  [example1 example2 example3 example4 example5 example6 example7])

(def ^:private results
  [2 2 3 5 true 1 2])

(deftest meval-test
  (is (= results
         (for [ex all-examples] (mce/meval ex mce/init-env)))))
