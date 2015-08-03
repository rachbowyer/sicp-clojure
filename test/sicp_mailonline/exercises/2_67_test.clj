;; Exercise 2.67
;; Define an encoding tree and sample message:
;;
;; (define sample-tree
;;   (make-code-tree (make-leaf 'A 4)
;;                   (make-code-tree
;;                    (make-leaf 'B 2)
;;                    (make-code-tree (make-leaf 'D 1)
;;                                    (make-leaf 'C 1)))))
;;
;; (define sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))
;;
;; Use the decode procedure to decode the message, and give the result.

(ns sicp-mailonline.exercises.2-67-test
  (:require [sicp-mailonline.examples.2-3-4 :refer :all]
            [clojure.test :refer :all]))

(def sample-tree
  (make-code-tree (make-leaf 'A 4)
                  (make-code-tree (make-leaf 'B 2)
                                  (make-code-tree
                                   (make-leaf 'D 1)
                                   (make-leaf 'C 1)))))
(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))

(deftest exercise2-67
  (testing "can decode sample message"
    (is (= '(A D A B B C A)
           (decode sample-message sample-tree)))))