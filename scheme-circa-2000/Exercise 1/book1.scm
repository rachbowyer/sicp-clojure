;Excercise 1.3
;=============


(define sum-squares 
  (lambda (x y)
    (+ (* x x) (* y y))))


(define (square-largest x y z)
  (cond 
    ((and (<= z x) (<= z y)) (sum-squares x y))
    ((and (<= y x) (<= y z)) (sum-squares x z))
     ((and (<= x y) (<= x z)) (sum-squares y z))))


;Exercise 1.4
;============

(define (a-plus-abs-b a b)
  ((if (< b 0) - +) a b))

;Exercise 1.5
;============


(define (p) (p))

(define (test x y)
  (if (= x 0) 0 y))

; It recurses infintitely on an applicative-order interpreter


;Exercise 1.6
;============

(define (new-if predicate then-clause else-clause)
  (cond (predicate then-clause)
  (else else-clause)))







