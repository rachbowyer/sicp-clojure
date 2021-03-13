(ns sicp-clojure.exercises.4-21)

(defn f1
  "Mutual recursion using letfn"
  [x]
  (letfn [(even? [n]
            (if (zero? n)
              true
              (odd? (dec n))))

          (odd? [n]
            (if (zero? n)
              false
              (even? (dec n))))]
    (even? x)))


(defn f2
  "Mutual recursion using just lambda calculus"
  [x]
  ((fn [even? odd?]
     (((even? even?) odd?) x))

   ;; Even
   (fn [even?]
     (fn [odd?]
       (fn [n]
         (if (zero? n)
           true
           (((odd? even?) odd?) (dec n))))))

   ;; Odd
   (fn [even?]
     (fn [odd?]
       (fn [n]
         (if (zero? n)
           false
           (((even? even?) odd?) (dec n))))))))