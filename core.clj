(ns store.core)

;["daniel" "william" "carl" "paul" "lucy" "anna"]

(map println ["daniel" "william" "carl" "paul" "lucy" "anna"])

;["daniel" "william" "carl" "paul" "lucy" "anna"]
;["william" "carl" "paul" "lucy" "anna"]
;["carl" "paul" "lucy" "anna"]
;["paul" "lucy" "anna"]
;...
;[]

(println (first ["daniel" "william" "carl" "paul" "lucy" "anna"]))

(println (rest ["daniel" "william" "carl" "paul" "lucy" "anna"]))

(println (next ["daniel" "william" "carl" "paul" "lucy" "anna"]))

(println (rest []))

(println (next []))

(println (seq []))
(println (seq [1 2 3 17]))

(println "\n\n\nMY MAP")
(defn my-map
  [function sequence]
  (let [first-element (first sequence)]
    (function first-element)
    (my-map function (rest sequence)))
  )

;(my-map println ["daniel" "william" "carl" "paul" "lucy" "anna"])

(println (rest []))


