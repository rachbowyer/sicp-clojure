(ns sicp-mailonline.paragraphs.1-1-2-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-1-2 :refer :all]))

(deftest size-test
  (testing "Testing size"
    (is (= 2 size))))

(deftest pi-test
  (testing "PI test"
    (is (< (Math/abs (- pi 3.1415926)) 1e-5))))