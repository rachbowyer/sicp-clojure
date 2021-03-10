; 
; Paragraph 1.2.2
;
(ns sicp-mailonline.paragraphs.1-2-2-test
  (:require [clojure.test :refer :all]
            [sicp-mailonline.paragraphs.1-2-2 :refer :all]))

(deftest test-count-change
  (testing "Ways to make a dollar are correct"
    (is (= (count-change 100) 292))))