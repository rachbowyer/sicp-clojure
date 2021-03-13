(ns sicp-clojure.meta-circular-evaluator
  "The metacircular evaluator described in the first 30 mins of
   Gerald Sussman's lecture
   https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-001-structure-and-interpretation-of-computer-programs-spring-2005/video-lectures/7a-metacircular-evaluator-part-1/

   Uses a very restricted subset of Clojure
   Implements barely more than lambda calculus

   But - here is the thing. With only a minor extension,
   we can write the metacircular evaluator in itself!

   Gerald Sussman viewed this as so magically, that he wore a suit jacket
   and fez for this part of the lecture

   Have implemented assq (as not supported in Clojure), a + primitive and made
   sure booleans work. Other than that, the code is the code shown in the
   lecture")

(declare lookup)
(declare evcond)
(declare mapply)
(declare evcond)
(declare evlist)
(declare primitive?)
(declare apply-primitive)
(declare mbind)

(def init-env
  '((('true true)
     ('false false))))

(def ^:private third
  (fn [v]
    (nth v 2)))

(def meval
  "3                          -> 3
   x                          -> 3
   'foo  => (QUOTE FOO)       -> foo
   (ƛ (x) (+ x y))            -> (CLOSURE ((x) (+ x y)) env)
   (COND (p1 b1) (p2 b2).. )
   (+ x 3) do add
  "
  (fn [exp env]
    (cond
      (or (boolean? exp) (number? exp))
      exp

      (symbol? exp)
      (lookup exp env)

      (= (first exp) 'QUOTE)
      (second exp)

      (= (first exp) 'LAMBDA)
      (list 'CLOSURE (rest exp) env)

      (= (first exp) 'COND)
      (evcond (rest exp) env)

      :else
      (mapply (meval (first exp) env)
              (evlist (rest exp) env)))))

(def ^:private mapply
  "proc is (CLOSURE ((args) body) env)
   args are (1 2)"
  (fn [proc args]
    (cond
      (primitive? proc)
      (apply-primitive proc args)

      (= (first proc) ' CLOSURE)
      (meval (second (second proc))         ;; body
             (mbind (first (second proc))   ;; arg spec
                    args
                    (third proc)))          ;; env

      :else
      (throw (Exception. (str "Unknown proc " proc))))))

(def ^:private evlist
  (fn [l env]
    (if (empty? l)
      '()
      (cons (meval (first l) env)
            (evlist (rest l) env)))))

(def ^:private evcond
  "((p1 b1) (p2 b2) ... (ELSE bn))
   ELSE is optional"
  (fn [clauses env]
    (cond (empty? clauses)
          '()

          (= (ffirst clauses) 'ELSE)
          (meval (second (first clauses)) env)

          (false? (meval (ffirst clauses) env))
          (evcond (rest clauses) env)

          :else
          (meval (second (first clauses)) env))))

(def ^:private pair-up
  "Basically zips the two lists together"
  (fn [vars vals]
    (cond
      (empty? vars)
      (cond
        (empty? vals)
        '()

        :else
        (throw (Exception. "Inconsistent list of vars and vals")))

      (empty? vals)
      (throw (Exception. "Inconsistent list of vars and vals"))

      :else
      (cons (list (first vars) (first vals))
            (pair-up (rest vars)
                     (rest vals))))))

(def ^:private mbind
  (fn [vars vals env]
    (cons (pair-up vars vals) env)))

(def ^:private assq
  "In Schema an alist - is an association list consisting of
   pairs (key val)
   Returns the first pair whose key matches sym or else
   returns an empty list"
  (fn [sym alist]
    (cond
      (empty? alist)
      '()

      (= (ffirst alist) sym)
      (first alist)

      :else
      (assq sym (rest alist)))))

(def ^:private lookup
  "Looks up the symbol in the environment. The environment
   consists of an alist"
  (fn [sym env]
    (cond
      (empty? env)
      (throw (Exception. (str "Empty environment - looking up - " sym)))

      :else
      ((fn [vcell]
         (cond
           (empty? vcell)
           (lookup sym (rest env))

           :else
           (second vcell)))
       (assq sym (first env))))))

(def ^:private primitive?
  (fn [sym]
    (cond
      (= sym '+)
      true

      :else
      false)))

(def ^:private apply-primitive
  (fn [sym args]
    (cond
      (= sym '+)
      (apply + args)

      :else
      (throw (Exception. (str "Unrecognised primitive: " sym))))))