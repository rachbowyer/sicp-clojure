; 
; Exercise 3.2
;
(ns sicp-clojure.exercises.3-2)

(defn make-monitored [f] 
  (let [num-times (atom 0)]
    (fn [x]
        (condp = x
          :how-many-calls? @num-times
          :reset-count (reset! num-times 0)
          (do 
            (swap! num-times inc)
            (f x))))))

(def s (make-monitored #(Math/sqrt %)))

(println (s 100))

(println (s :how-many-calls?))

