(ns store.lesson1)

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


(println "\n\n\nMY MAP")
(defn my-map
  [function sequence]
  (let [first-element (first sequence)]
    (if first-element
    (function first-element)
    (my-map function (rest sequence))))
  )

(my-map println ["daniel" "william" "carl" "paul" "lucy" "anna"])

(println "\n\n\nMY MAP")
(defn my-map
  [function sequence]
  (let [first-element (first sequence)]
    (if first-element
      (do
        (function first-element)
        (my-map function (rest sequence)))))
  )

(my-map println ["daniel" false "carl" "paul" "lucy" "anna"])

(println "\n\n\nMY MAP STOPPING FOR NULL")
(defn my-map
  [function sequence]
  (let [first-element (first sequence)]
    (if (not (nil? first-element))
      (do
        (function first-element)
        (my-map function (rest sequence)))))
  )

;(my-map println ["daniel" false "carl" "paul" "lucy" "anna"])
;(my-map println [])
;(my-map println nil)
;(my-map println (range 100000))

(println "\n\n\nMY MAP FOR RECUR")
(defn my-map
  [function sequence]
  (let [first-element (first sequence)]
    (if (not (nil? first-element))
      (do
        (function first-element)
        (recur function (rest sequence)))))
  )

;(my-map println ["daniel" false "carl" "paul" "lucy" "anna"])
;(my-map println [])
;(my-map println nil)
;(my-map println (range 100000))

(println "\n\n\nMY MAP FOR RECUR")
(defn my-map
  [function sequence]
  (let [first-element (first sequence)]
    (if (not (nil? first-element))
      (do
        (recur function (rest sequence))
        (function first-element)
        )))
  )

;(my-map println ["daniel" false "carl" "paul" "lucy" "anna"])
;(my-map println [])
;(my-map println nil)
(my-map println (range 100000))