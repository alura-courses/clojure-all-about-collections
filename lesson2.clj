(ns store.lesson2)

;["daniel" "william" "carl" "paul" "lucy" "anna"]

(defn my-counting
  [total-so-far elements]
  (recur (inc total-so-far) (rest elements))
)

;(println (my-counting 0 ["daniel" "william" "carl" "paul" "lucy" "anna"]))

(defn my-counting
  [total-so-far elements]
  (if (next elements)
    (recur (inc total-so-far) (next elements))
    (inc total-so-far)))

(println (my-counting 0 ["daniel" "william" "carl" "paul" "lucy" "anna"]))
(println (my-counting 0 []))

(defn my-counting
  [total-so-far elements]
  (if (seq elements)
    (recur (inc total-so-far) (next elements))
    total-so-far))

(println (my-counting 0 ["daniel" "william" "carl" "paul" "lucy" "anna"]))
(println (my-counting 0 []))


(defn my-function
  ([param1] (println param1))

  ([param1 param2] (println param1 param2))
  )

(my-function 17)
(my-function 18 19)

(defn my-counting
  ([elements]
   (my-counting 0 elements))

  ([total-so-far elements]
  (if (seq elements)
    (recur (inc total-so-far) (next elements))
    total-so-far)))

(println (my-counting 0 ["daniel" "william" "carl" "paul" "lucy" "anna"]))
(println (my-counting 0 []))
(println (my-counting ["daniel" "william" "carl" "paul" "lucy" "anna"]))
(println (my-counting []))

(println "MY COUNTING2")
(defn my-counting2
  [elements]
  (println "before the loop")
  (loop
    [total-so-far 0
     remaining-elements elements]

    (if (seq remaining-elements)
      (recur (inc total-so-far) (next remaining-elements))
      total-so-far))
  )

(println (my-counting2 ["daniel" "william" "carl" "paul" "lucy" "anna"]))
(println (my-counting2 []))
