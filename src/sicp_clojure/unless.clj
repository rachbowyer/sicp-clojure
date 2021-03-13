(ns sicp-clojure.unless
  "Clojure is generally a strict (applicative order/call by value) language.
   However, the stream library is lazy. Also macros are lazy
   (normal order/call by name) so can be used where laziness is required.
   Reason is that macro parameters are the AST of the inputs unevaluated")

(defmacro unless [p then-a else-b]
  (if p else-b then-a))

