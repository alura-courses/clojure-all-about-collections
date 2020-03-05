(ns store.lesson5
  (:require [store.db :as s.db]
            [store.logic :as s.logic]))

(defn spent-a-lot?
  [user-info]
  (println "spent-a-lot?" (:user-id user-info))
  (> (:total-price user-info) 500)
  )

(let [orders (s.db/all-orders)
      summary (s.logic/summary-per-user (s.db/all-orders))]
  (println "keep" (keep spent-a-lot? summary))
  (println "filter" (filter spent-a-lot? summary))
  )

(println "ISOLATING....")
(println (range 10))
(println (take 2 (range 100000000000000)))
(println "ISOLATING 2....")
(let [sequence (range 100000000000000)]
  (println (take 2 sequence))
  (println (take 2 sequence))
  )

(defn filter1
  [x]
  (println "filter1" x)
  x)

(defn filter2
  [x]
  (println "filter2" x)
  x)

;(println (map filter2 (map filter1 (range 10))))
(println "\n\nRUNNING")
(->> '(1 2 3 6 8 5 9 9 4 1 2 6 5 1 1 2 3 6 8 5 9 9 4 1 2 6 5 11 2 3 6 8 5 9 9 4 1 2 6 5 11 2 3 6 8 5 9 9 4 1 2 6 5 11 2 3 6 8 5 9 9 4 1 2 6 5 1)
     (map filter1)
     (map filter2)
     println)