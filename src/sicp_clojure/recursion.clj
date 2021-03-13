(ns sicp-clojure.recursion
  "Recursion in lambda calculus.

   Without having def, it is possible to write
   recursive functions in lambda calculus as follows")

(def fact
  "Factorial function written in lambda calculus. If integer
   arithmetic was replaced with Church numerals then woud be
   pure lambda calculus"
  (fn [n]
    ((fn [exp]
       ((exp exp) n))
     (fn [expf]
       (fn [i]
         (if (= i 0)
           1
           (* i ((expf expf) (- i 1)))))))))
