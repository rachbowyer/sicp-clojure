(ns sicp-mailonline.core-test
  (:require [midje.sweet :refer :all]
            [sicp-mailonline.core :refer :all]))

;; 1.1.7 Example: Square Roots by Newton's Method
(defn average [ & rest]
  (/ (apply + rest) (count rest)))

(defn abs [n]
  (if (< n 0)
    (- 0 n)
    n))

(defn square [n] (* n n))

(defn square-improve [guess x]
  (average guess (/ x guess)))

(defn square-good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (square-good-enough? guess x)
    (double guess)
    (sqrt-iter (square-improve guess x)
               x)))

(defn sqrt [x]
  (sqrt-iter 1 x))

(sqrt 4)

;;; Exercie 1.6 - Seems to hang in Clojure...
(defn new-if [pred true-expr false-expr]
  (cond (pred) true-expr
        :else false-expr))

;;; Exercise 1.8

(defn cube [n] (* n n n))

(defn cube-good-enough? [guess x]
  (< (abs (- (cube guess) x)) 0.001))

(defn cube-improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

; Exercise 1.9 - First Recursive (keeps it's head, I think), Second Iterative.

; Exercise 1.10
(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1) (A x (- y 1)))))
(A 1 10)
(A 0 (A 1 9))
(A 0 (A 0 (A 1 8)))
(A 0 (A 0 (A 0 (A 1 7))))
(A 0 (A 0 (A 0 (A 0 (A 1 6)))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 1 5))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 4)))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 4)))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 3))))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 2)))))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2)))))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4))))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 8)))))))
(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 16))))))
(A 0 (A 0 (A 0 (A 0 (A 0 32)))))
(A 0 (A 0 (A 0 (A 0 64))))
(A 0 (A 0 (A 0 128)))
(A 0 (A 0 256))
(A 0 512)
(A 0 16)
;;;;
(A 2 4)
(A 1 (A 2 3))
(A 1 (A 1 (A 2 2)))
(A 1 (A 1 (A 1 (A 2 1))))
(A 1 (A 1 (A 1 2)))
(A 1 (A 1 (A 0 (A 1 1))))
(A 1 (A 1 (A 0 2)))
(A 1 (A 1 4))
(A 1 (A 0 (A 1 3)))
(A 1 (A 0 (A 0 (A 1 2))))
(A 1 (A 0 (A 0 (A 0 (A 1 1)))))
(A 1 (A 0 (A 0 (A 0 2))))
(A 1 (A 0 (A 0 4)))
(A 1 (A 0 8))
(A 1 16)
(A 1 16) => 16^2

(defn oneten-f [n] (A 0 n))
(= (oneten-f 12) (* 2 12))
; oneten-g -> to the power of
; oneten-h -> to the power of... to the power of
; oneten-k -> 5 times n squared

(defn oneeleven-recursive [n]
  (cond (< n 3) n
        :else (+
               (oneeleven (- n 1))
               (* 2 (oneeleven (- n 2)))
               (* 3 (oneeleven (- n 3)))))
  )
(oneeleven-recursive 40)

(defn cube-iter [guess x]
  (if (cube-good-enough? guess x)
    (double guess)
    (cube-iter (cube-improve guess x)
               x)))


(fact
  (= 1 1) => true)
