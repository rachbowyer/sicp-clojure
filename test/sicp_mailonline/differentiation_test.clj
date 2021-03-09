(ns sicp-mailonline.differentiation-test
  "Back when I was around 14 I first learnt the rules for differentiation. I
   thought a symbolic differentiation program would be really cool - and set
   about writing one in BBC Basic. I did not get very far :-(
   However, with a language geared to recursion and symbolic manipulation it is
   surprisingly straight forward."
  (:require [sicp-mailonline.differentiation :as smd]
            [clojure.test :refer :all]))

(def example
  "ax^2 + bx + c"
  '(+ (* a (** x 2)) (* b x) c))

(def result
  "2ax + b"
  '(+ (* a (* 2 x)) b))

(deftest variable?-test
 (are [x result] (= result (#'smd/variable? x))
    'a  true
    1   false
    :a  false))

(deftest same-variable?-test
  (are [v1 v2 result] (= result (#'smd/same-variable? v1 v2))
    'a 'a true
    'a 'b false))

(deftest makesum-test
  (are [x y result] (= result (#'smd/make-sum x y))
    0 'a    'a
    'a 0    'a
    2  3    5
    'a 'b   '(+ a b)))

(deftest addend-test
  (is (= 'a (#'smd/addend (#'smd/make-sum 'a 'b)))))

(deftest augend-test
  (are [sum result] (= result (#'smd/augend sum))
    '(+ 2 x)        'x
    '(+ 2 x y)      '(+ x y)
    '(+ 2 x y z)    '(+ x y z)))

(deftest sum?-test
  (are [x result] (= result (#'smd/sum? x))
       1                                             false
       'a                                            false
       (#'smd/make-sum 'a 2)                         true
       (#'smd/make-sum 'e (#'smd/make-sum 'b 'c))    true
       (#'smd/make-product 'a 2)                     false))

(deftest make-product-test
  (are [x y result] (= result (smd/make-product x y))
    0   'a        0
    'a  0         0
    1   'a        'a
    'a  1         'a
    2   3         6
    'a  'b        '(* a b))

  (is (= '(* a b c) (smd/make-product 'a 'b 'c))))

(deftest multiplier-test
  (is (= 'a (#'smd/multiplier (#'smd/make-product 'a 'b)))))

(deftest multiplicand-test
  (are [product result] (= result (#'smd/multiplicand product))
    '(* 2 x)        'x
    '(* 2 x y)      '(* x y)
    '(* 2 x y z)    '(* x y z)))

(deftest product?-test
  (are [x result] (= result (#'smd/product? x))
                  1                                               false
                  'a                                              false
                  (#'smd/make-product 'a 2)                       true
                  (#'smd/make-product 'e (#'smd/make-sum 'b 'c))  true
                  (#'smd/make-sum 'a 2)                           false))

(deftest exponentiation?-test
  (are [x result] (= result (#'smd/exponentiation? x))
                  1                                                       false
                  'a                                                      false
                  (#'smd/make-exponentiation 'x 2)                        true
                  (#'smd/make-exponentiation 'e (#'smd/make-sum 'b 'c))   true))

(deftest make-exponentiation-test
  (are [base exponent result] (= result (#'smd/make-exponentiation base exponent))
    'x  0  1
    'x  1  'x
    'x  'a '(** x a)))

(deftest deriv-test
  (are [exp var result] (= result (smd/deriv exp var))
    '(+ x 3) 'x                 1
    '(* x y) 'x                 'y
    '(* x y) 'y                 'x
    '(* x y (+ x 3)) 'x         '(+ (* x y) (* y (+ x 3)))
    '(** x 2) 'x                '(* 2 x)
    example 'x                  result
    '(** x 3) 'x                '(* 3 (** x 2))
    '(** x a) 'x                '(* a (** x (+ a -1)))))