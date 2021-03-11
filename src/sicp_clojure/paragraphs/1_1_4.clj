(ns sicp-clojure.paragraphs.1-1-4)

; 1.1.4

(defn square [x]
    (* x x))

(defn sum-of-squares [x y]
    (+ (square x) (square y)))




; (defn abs [x] 
;     (cond   (> x 0) x
;             (= x 0) 0
;             (< x 0) (0 - x)))


