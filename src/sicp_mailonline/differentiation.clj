(ns sicp-mailonline.differentiation)

(defn- variable? [x]
  (symbol? x))

(defn- product? [x]
  (and (seq? x) (= (first x) '*)))

(defn- sum? [x]
  (and (seq? x) (= (first x) '+)))

(defn- exponentiation? [x]
  (and (seq? x) (= (first x) '**)))

(defn- expression? [exp]
  (or (number? exp)
      (variable? exp)
      (sum? exp)
      (product? exp)
      (exponentiation? exp)))

(defn- same-variable? [v1 v2]
  (and (variable? v1)
       (variable? v2)
       (= v1 v2)))

(defn make-sum [a1 a2]
  (cond
    (and (number? a1) (zero? a1))    ;; Note zero? does not handle fp correctly
    a2

    (and (number? a2) (zero? a2))
    a1

    (and (number? a1) (number? a2))
    (+ a1 a2)

    :else
    (list '+ a1 a2)))

(defn make-product
  [& args]
  (let [[m1 m2 & t] args]
    (cond
      (not (empty? t))
      (cons '* args)

      (or
        (and (number? m1) (zero? m1) )
        (and (number? m2) (zero? m2) ))
      0

      (and (number? m1) (= m1 1))
      m2

      (and (number? m2) (= m2 1))
      m1

      (every? number? [m1 m2])
      (* m1 m2)

      :else
      (list '* m1 m2))))

(defn make-exponentiation [base exponent]
  (cond
    (and (number? exponent) (zero? exponent))
    1

    (and (number? exponent) (= 1 exponent))
    base

    :else
    (list '** base exponent)))

(defn- addend [x]
  (second x))

(defn- augend [x]
  {:post [expression?]}
  (let [[_ _ & m]   x
        [h & t] m]
    (if (empty? t)
      h
      (cons '+ m))))

(defn- multiplier [x]
  (second x))

(defn- multiplicand [x]
  {:post [expression?]}
  (let [[_ _ & m]   x
        [h & t] m]
    (if (empty? t)
      h
      (cons '* m))))

(defn- base [x]
  {:pre [(exponentiation? x)]}
  (second x))

(defn- exponent [x]
  {:pre [(exponentiation? x)]}
  (nth x 2))

(defn deriv [exp var]
  {:pre [(expression? exp) (variable? var)]}
  (letfn [(derivv [e] (deriv e var))]
    (cond
      (number? exp)
      0

      (variable? exp)
      (if (same-variable? exp var) 1 0)

      (sum? exp)
      (make-sum (derivv (addend exp)) (derivv (augend exp)))

      (product? exp)
      (make-sum
        (make-product (multiplier exp) (derivv (multiplicand exp)))
        (make-product (derivv (multiplier exp)) (multiplicand exp)))

      (exponentiation? exp)
      (make-product
        (exponent exp)
        (make-product
          (make-exponentiation (base exp)
                               (make-sum (exponent exp) -1))
          (derivv (base exp))))

      :else
      (throw (Exception. (str "Invalid input - " exp))))))