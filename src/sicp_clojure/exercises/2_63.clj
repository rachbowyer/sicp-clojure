(ns sicp-clojure.exercises.2-63
  (:require [keirin.core :as k]))

;; tree->list-1 calls append on every node. Append scans all the entries
;; beneath the node in the tree. So should be O(n^2)

;; tree->list-2 calls cons once for every node (but not append). Should be
;; O(n)
;;

(def biggest-num 500)

;;;; Simple Clojure implementation of a tree

(def get-entry first)

(def get-left-branch second)

(def get-right-branch #(nth % 2))

(defn create-node [value left-branch right-branch]
  (list value left-branch right-branch))

(defn append-to-tree
  "Each node is a list '(entry left-branch right-branch)"
  [node entry]
  (cond
    (nil? node)
    (create-node entry nil nil)

    (< entry (get-entry node))
    (create-node
      (get-entry node)
      (append-to-tree (get-left-branch node) entry)
      (get-right-branch node))

    :else
    (create-node
      (get-entry node)
      (get-left-branch node)
      (append-to-tree (get-right-branch node) entry))))

(defn create-big-tree [size]
  (->> (take size (repeatedly #(rand-int biggest-num)))
       (reduce append-to-tree nil)))

(defn tree->list-1
  "In order traversal of tree"
  [node]
  (if (nil? node)
    '()
      (doall (concat
        (tree->list-1 (get-left-branch node))
        (cons (get-entry node)
              (tree->list-1 (get-right-branch node)))))))

(defn tree->list-2
  [tree]
  (letfn [(copy-to-list [node result-list]
          (if (nil? node)
            result-list
            (copy-to-list
              (get-left-branch node)
              (cons (get-entry node)
                    (copy-to-list
                      (get-right-branch node)
                      result-list)))))]
    (copy-to-list tree '())))


(defn test-performance []
  (println "Constructing tree with 100,000 nodes")
  (let [tree (create-big-tree 100000)]
    (println "Benchmarking tree->list-1")
    (k/quick-bench (doall (tree->list-1 tree)))

    (println "Benchmarking tree->list-2")
    (k/quick-bench (doall (tree->list-2 tree)))))


;;
;; Testing but keeping concat lazy until the final result is needed
;;

; Constructing tree with 100,000 nodes
; Benchmarking tree->list-1
; Time taken (median) 40.77 ms
; Mean absolute deviation (MADS)  105.06 µs
; Benchmarking tree->list-2
; Time taken (median) 7.96 ms
; Mean absolute deviation (MADS)  30.09 µs

; Constructing tree with 1,000,000 nodes
; Benchmarking tree->list-1
; Time taken (median) 470.07 ms
; Mean absolute deviation (MADS)  705.62 µs
; Benchmarking tree->list-2
; Time taken (median) 83.50 ms
; Mean absolute deviation (MADS)  188.12 µs


;;
;; Testing by making concat non-lazy with doall
;;

;Constructing tree with 100,000 nodes
;Benchmarking tree->list-1
;Time taken (median) 248.26 ms
;Mean absolute deviation (MADS)  239.50 µs
;Benchmarking tree->list-2
;Time taken (median) 7.99 ms
;Mean absolute deviation (MADS)  22.63 µs


;Constructing tree with 1,000,000 nodes
;Benchmarking tree->list-1
;Time taken (median) 17.12 seconds
;Mean absolute deviation (MADS)  4.27 ms
;Benchmarking tree->list-2
;Time taken (median) 86.88 ms
;Mean absolute deviation (MADS)  643.60 µs




;; Turns out that in a language like Clojure it is very hard to accurately
;; benchmark code. Simple (time) commands in the REPL are completely inaccurate
;; as dynamic compilation and garbage collection messes up the times.
;; The only way to get a reasonable accurate time is to use a library such as
;; keirin which I designed for the job (benchmarking functions to verify big O
;; performance for Clojure: The Essential Reference)
;;
;; My initial results were that tree->list-2 was indeed faster, but only faster
;; by a constant linear ratio. I was confused at first, then realised that
;; Clojure lists are lazy and the pathological behaviour was probably being
;; optimised out.
;;
;; I then changed the function to force the list each time concat was run. This
;; then gave the expected quadratic O(n^2) behaviour
