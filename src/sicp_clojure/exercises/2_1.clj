; 
; Exercise 2.1
;
(ns sicp-clojure.exercises.2-1
  (:require [sicp-clojure.paragraphs.2-1-1 :refer [numer denom]]
            [sicp-clojure.abs :refer :all]
            [sicp-clojure.gcd :refer :all]))
 

(defn make-rat [n d]
  (defn pair [x y]
    (cons x (cons y nil)))

  (let  [g (gcd n d)  
         numer (abs (/ n g))
         denom (abs (/ d g))]
          
    (cond 
      (and (>= n 0) (>= d 0)) (pair numer denom)
      (and (< n 0) (< d 0))   (pair numer denom)
      :else                   (pair (- 0 numer) denom))))



