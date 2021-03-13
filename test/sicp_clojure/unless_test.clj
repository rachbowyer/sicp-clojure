(ns sicp-clojure.unless-test
  (:require [sicp-clojure.unless :as u]
            [clojure.test :refer :all]))

(deftest unless-test
  (is (= 1
         (u/unless false 1 0)))

  (is (= 1
         (u/unless false 1 (1 / 0))))

  (is (= 0
         (u/unless true 1 0))))
