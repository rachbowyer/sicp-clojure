# sicp-clojure

    "Computer Science is not a science... It is also not really very much about computers"

    Hal Abelson, 1986.

I first came across _Structure and Interpretation of Computer Programs_ 
(["SICP"](https://mitpress.mit.edu/sites/default/files/sicp/full-text/book/book.html)) 
around the year 2000. At that time I was a software engineer at a large
investment bank. I was working on building multi-threaded real-time risk systems 
in C++. SICP and Scheme blew my mind. Here was a language that could create and
return functions!

<p style="text-align:center;">
<img src="https://github.com/rachbowyer/sicp-clojure/blob/rachbowyer/sicp_and_train_ticket.jpg" 
alt="Picture of train ticket and text from instructors Manual to SICP" width="250"/>
</p>

I have recently come across a copy of the Instructor's Manual for SICP, bookmarked
with a London Underground ticket dated June 2000, marking commentary on Church
Numerals. I first came across Church Numerals in a lecture at University. They
were presented as mathematical curiosity. To my then mind they were an example of 
pointless mathematical abstraction<sup>1</sup>! And yet here was a computer language 
which had so much power you could implement Church Numerals.

But LISP seemed hopelessly impractical<sup>2</sup>. At our investment bank, we 
had to get every ounce of performance from our hardware. And just how were 
we going to build a Windows GUI in MIT Scheme?

More forward to 2006-2008 and I got badly burnt on my then project. It was another
realtime risk system, this time implemented in Java 5. It was painful. The 
complexity of the system and the OO encapsulation meant we could not reason about
the concurrency of the system. We could ensure that shared data was protected, 
but we could not be certain there would be no deadlocks. And deadlocks there were!
In production! They got ironed out eventually, but it is not an experience I 
would like to repeat.

Then there were "stop the world" garbage collections ("GC"), which would mean that
our system would stop for 5-10mins at a time at random. In production. These too
were eventually tuned out.

There had to be a better way. The solution was not a better UAT environment that
allowed the ironing out and tuning before the code reached production. The solution
had to be a different way of constructing applications. A way in which there was
a guarantee of no deadlocks. A way in which there was a guarantee of maximum 
GC time.

Move forward to 2014, and the landscape had changed. I began to explore Elixir and
Clojure. Both languages "solved"<sup>3</sup> the problem of concurrency. Clojure 
has many different <sup>4</sup>approaches whereas Elixir offers just the one, actors.

Elixir's runtime, the BEAM, solves the "stop the world" GC issue <sup>5</sup> as well. 
Clojure does not itself solve GC problems like Elixir. But structuring a Clojure 
application as a series of services communicating via a messaging service 
(such as Apache Storm or RabbitMQ) helps to keep GC under control.

I then saw a SICP in Clojure study group starting. I joined at once! This was an
opportunity to study SICP and learn Clojure. And even better, I learnt that there
were jobs for Clojure programmers. This powerful, but obscure language I first 
discovered 15 years ago was now the future.

Move forward to 2021. I have some spare time to hack on SICP again. This repo 
contains the code I wrote in 2014-2015. Often it just had Clojure code copied 
and pasted from the REPL. I was solving problems, not writing an application.
Some of the code is very poor Clojure - which is to be expected as
I was just starting to learn the language.

I have cleaned it up somewhat. The code for rendering the Henderson Picture 
Language has been split out into a standalone 
[library](https://github.com/rachbowyer/henderson).

A bigger challenge is whether to try to follow the style of the SICP code as
closely as possible or make the code more idiomatically Clojure. Generally I
have stuck to the approach in SICP as using some of the more advanced features
of Clojure detracts from the exercises. For example, I have generally stuck to 
using linked lists rather than say using Clojure's persistent hashmap. 

At one point I had hoped to read the whole of SICP and work every exercise! But
time is finite and there are many other interesting topics in Maths, 
Computer Science and AI. I have also already covered topics such as lazy 
streams and Huffman encoding in Scala. So instead I will pick and choose 
the topics and exercises.

Maybe I will be finished in another 20 years. I am certain that SICP will still
be relevant to software engineering.





_Rachel Bowyer_<br>
_March 2021_
<hr>
<sup>1</sup> I have learnt since my time at university that Lorenzo Church was 
looking at defining computability and wanted to add integers to a language 
(lambda calculus) that only supported function definition and application. With 
this context they move from being "pointless" to beautiful!


<sup>2</sup> I was wrong again. Paul Graham was happily building a multi-million
pound internet startup, ViaWeb, in Common Lisp at this point.

<sup>3</sup> Well concurrency still remains challenging. But in Clojure and Elixir
concurrency is under control in a way that isn't in any reasonably sized Java 5
apps.

<sup>4</sup> For most applications just persistent data structures and atoms get
you there. More complicated apps can use Software Transactional Memory or
CoreIO. There are also non-blocking Java concurrency data structures such as 
the ConcurrentHashMap.

<sup>5</sup> BEAM supports hundreds of lightweight processes. 
Each process has its own garbage collector. So the maximum GC for any one
process is limited. In fact BEAM was designed to run telephone switches.



