(ns sicp-clojure.recursion-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.recursion :as r]))

(deftest fact-test
  (is (= [1 1 2 6 24]
         (for [i [0 1 2 3 4]] (r/fact i)))))
