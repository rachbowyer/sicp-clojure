(ns sicp-clojure.exercises.2-54)

(defn equal? [a b]
  (or
    (and (nil? a) (nil? b))

    (and (symbol? a) (symbol? b) (= a b))

    (and (seqable? a) (seqable? b) (empty? a) (empty? b))

    (and (seqable? a)
         (seqable? b)
         (= (first a) (first b))
         (equal? (rest a) (rest b)))))
