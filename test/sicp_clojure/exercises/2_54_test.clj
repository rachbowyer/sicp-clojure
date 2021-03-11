(ns sicp-clojure.exercises.2-54-test
  (:require [sicp-clojure.exercises.2-54 :refer :all]
            [clojure.test :refer :all]))

(deftest equal?-test
  (are [a b c] (= (equal? a b) c)
               '()           'a             false
               '()           '()            true
               'a            'a             true
               'a           'b              false
               'a            ['a]           false
               ['a]           ['a]          true
               ['a]           ['b]          false
               ['a]           ['a 'b]       false
               ['a 'b]        ['a 'b]       true
               [['a 'b] 'c]   [['a 'b] 'c]  true
               [['a 'd] 'c]   [['a 'b] 'c]  false))