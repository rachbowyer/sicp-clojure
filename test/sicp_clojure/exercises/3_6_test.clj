;
; Exercise 3.6
;
(ns sicp-clojure.exercises.3-6-test
	(:require   [clojure.test :refer :all]
	            [sicp-clojure.exercises.3-6 :refer :all]
							[sicp-clojure.rand :refer :all]))

(deftest new-rand-2-test
	(testing "generate and reset"
		((new-rand-2 :reset) random-init)
		(is (new-rand-2 :generate) 1155484576)
		(is (new-rand-2 :generate) 723955400)
		((new-rand-2 :reset) random-init)
		(is (new-rand-2 :generate) 1155484576)
		(is (new-rand-2 :generate) 723955400)))
