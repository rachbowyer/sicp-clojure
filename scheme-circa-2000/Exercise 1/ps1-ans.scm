Exercise2
=========

(define fact
  (lambda (n)
    (if (= n 0) 
	1 (* n (fact (- n 1))))))


(fact 243)
;Value: 57651072073405564859932599378988824389544612769748785289578514753791226660795447787952561780489668440613028916503471522241703645767996810695135226278296742637606115134300787052991319431412379312540230792060250137088708811794424564833107085173464718985508999858791970609491066045711874321516918150905413944789377156315207186998055591451670633898714567745386826936678840548225648089961727875705444538167142818292862812160000000000000000000000000000000000000000000000000000000000

Rewrite of fact that is iterative and is coded to use tail recursion

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


(fact2 243)
;Value: 57651072073405564859932599378988824389544612769748785289578514753791226660795447787952561780489668440613028916503471522241703645767996810695135226278296742637606115134300787052991319431412379312540230792060250137088708811794424564833107085173464718985508999858791970609491066045711874321516918150905413944789377156315207186998055591451670633898714567745386826936678840548225648089961727875705444538167142818292862812160000000000000000000000000000000000000000000000000000000000

Excercise 3
===========

(define comb 
  (lambda (n k)
    (/ (fact n) 
      (*	
        (fact k)
	(fact (- n k))))))


(comb 243 90)
;Value: 193404342391239489855973693417880600543891038618846567058277413638164


Exercise 4
==========

Copyright (c) 1985 Free Software Foundation


   Permission is granted to anyone to make or distribute verbatim copies
   of this document as received, in any medium, provided that the
   copyright notice and permission notice are preserved,
   and that the distributor grants the recipient permission
   for further redistribution as permitted by this notice.

   Permission is granted to distribute modified versions
   of this document, or of portions of it,
   under the above conditions, provided also that they
   carry prominent notices stating who last altered them.

Excercise 5
===========

Info file not available


Exercise 6
==========

:Unix conspiracy: /n./  [ITS] According to a conspiracy theory
   long popular among {{ITS}} and {{TOPS-20}} fans, Unix's growth is
   the result of a plot, hatched during the 1970s at Bell Labs, whose
   intent was to hobble AT&T's competitors by making them dependent
   upon a system whose future evolution was to be under AT&T's
   control.  This would be accomplished by disseminating an operating
   system that is apparently inexpensive and easily portable, but also
   relatively unreliable and insecure (so as to require continuing
   upgrades from AT&T).  This theory was lent a substantial impetus in
   1984 by the paper referenced in the {back door} entry.


:phase of the moon: /n./  Used humorously as a random parameter
   on which something is said to depend.  Sometimes implies
   unreliability of whatever is dependent, or that reliability seems
   to be dependent on conditions nobody has been able to determine.
   "This feature depends on having the channel open in mumble mode,
   having the foo switch set, and on the phase of the moon."  See
   also {heisenbug}.

   True story: Once upon a time there was a bug that really did depend
   on the phase of the moon.  There was a little subroutine that had
   traditionally been used in various programs at MIT to calculate an
   approximation to the moon's true phase.  GLS incorporated this
   routine into a LISP program that, when it wrote out a file, would
   print a timestamp line almost 80 characters long.  Very
   occasionally the first line of the message would be too long and
   would overflow onto the next line, and when the file was later read
   back in the program would {barf}.  The length of the first line
   depended on both the precise date and time and the length of the
   phase specification when the timestamp was printed, and so the bug
   literally depended on the phase of the moon!

   The first paper edition of the Jargon File (Steele-1983) included
   an example of one of the timestamp lines that exhibited this bug,
   but the typesetter `corrected' it.  This has since been
   described as the phase-of-the-moon-bug bug.

Exercise 7 - identifiers
========================

     the-word-recursion-has-many-meanings


Exercise 8 - re-indent
======================

`C-M-q' indents the expression to the right of point

In info under the Scheme users guide \ Edwin

Excerise 9 - Dos shell
======================

c:\>date
date
The current date is: Sat 04/22/2000 
Enter the new date: (mm-dd-yy)

Exercise 10 - Finger
====================


finger @cs.berkeley.edu
[cs.berkeley.edu]

Login       Name               TTY         Idle    When    Where
albrown  Alexander Brown       pts/1        18: Wed 16:48  jupiter.cs.berkeley.
root     IDSG Super-User       pts/3         3d Mon 09:19  celt.cs.berkeley.edu

finger albrown@cs.berkeley.edu
finger albrown@cs.berkeley.edu
[cs.berkeley.edu]

=== User albrown found in CS database ===
Mail Drop: albrown@imap.CS.Berkeley.EDU
[forwarding finger request to imap4.CS.Berkeley.EDU]
cannot connect to imap.CS.Berkeley.EDU: Connection refused

finger @whitehouse.gov
finger @whitehouse.gov
[whitehouse.gov]

-> finger: connect::ICMP network unreachable

Exercise 11
===========

Do not understand it


