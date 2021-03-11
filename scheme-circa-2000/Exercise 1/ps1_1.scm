;;; This is the code for ps1.




(define fold
  (lambda (x y)
    (* (spindle x)
       (+ (mutilate y)
	  (spindle x)))))

(define spindle
  (lambda (w) (* w w)))

(define mutilate
  (lambda (z)
    (+ (spindle z) z)))

(define fact
  (lambda (n)
    (if (= n 0) 
	1 (* n (fact (- n 1))))))




(define fact_iter
  (lambda (achieve i ivalue)
    (if (= achieve i) 
	ivalue
	(fact_iter achieve 
	  (+ i 1)
	  (* (+ i 1) ivalue)))))

(define fact2
  (lambda (achieve)
    (fact_iter achieve 0 1)))



