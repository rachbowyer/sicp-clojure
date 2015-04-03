;; Example 2.2.4 - A Picture Language

(ns sicp-mailonline.examples.2-2-4
  (:require [sicp-mailonline.exercises.2-46 :refer [add-vect scale-vect xcor-vect ycor-vect]]
            [sicp-mailonline.exercises.2-47 :refer [origin-frame edg1-frame edge2-frame]]
            [sicp-mailonline.exercises.2-48 :refer [start-segment end-segment]]
            [sicp-mailonline.exercises.2-23 :refer [for-each-a]
                                            :rename {for-each-a for-each}]))

(declare beside)
(declare below)
(declare flip-vert)
(declare flip-horiz)
(declare up-split)
(declare draw-line)

(defn flipped-pairs [painter]
  (let [painter2 (beside painter (flip-vert painter))]
    (below painter2 painter2)))

(defn right-split [painter n]
  (if (zero? n)
    painter
    (let [smaller (right-split painter (dec n))]
      (beside painter (below smaller smaller)))))

(defn corner-split [painter n]
  (if (zero? n)
    painter
    (let [up (up-split painter (dec n))
          right (right-split painter (dec n))
          top-left (beside up up)
          bottom-right (below right right)
          corner (corner-split painter (dec n))]
      (beside (below painter top-left)
              (below bottom-right corner)))))

(defn square-limit [painter n]
  (let [quarter (corner-split painter n)
        half (beside (flip-horiz quarter) quarter)]
    (below (flip-vert half) half)))

(defn frame-coord-map [frame]
  (fn [v]
    (add-vect
     (origin-frame frame)
     (add-vect (scale-vect (xcor-vect v)
                           (edge1-frame frame))
               (scale-vect (ycor-vect v)
                           (edge2-frame frame))))))

(defn segments->painter [segment-list]
  (fn [frame]
    (for-each (fn [segment]
                (draw-line
                 ((frame-coord-map frame) (start-segment segment))
                 ((frame-coord-map frame) (end-segment segment))))
              segment-list)))