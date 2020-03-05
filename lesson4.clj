(ns store.lesson4
  (:require [store.db :as s.db]
            [store.logic :as s.logic]))

(println (s.db/all-orders))
;(println "RUNNING")
;(println (s.logic/summary-per-user (s.db/all-orders)))

(let [orders (s.db/all-orders)
      summary (s.logic/summary-per-user (s.db/all-orders))]
  (println "Summary" summary)
  (println "Sorted" (sort-by :total-price summary))
  (println "Sorted in Reverse" (reverse (sort-by :total-price summary)))
  (println "Sorted by ID" (sort-by :user-id summary))
  (println (get-in orders [0 :items :backpack :quantity])))

(defn summary-per-user-sorted
  [orders]
  (->> orders
       s.logic/summary-per-user
       (sort-by :total-price)
       reverse))

(let [orders (s.db/all-orders)
      summary (summary-per-user-sorted orders)]
  (println "Summary" summary)
  (println "First" (first summary))
  (println "Second" (second summary))
  (println "Rest" (rest summary))
  (println "Total" (count summary))
  (println "Class" (class summary))
  (println "nth 1" (nth summary 1))
  (println "get 1" (get summary 1))
  (println "take" (take 2 summary))
  )

(defn top-2
  [summary]
  (take 2 summary))

(let [orders (s.db/all-orders)
      summary (summary-per-user-sorted orders)]
  (println "Summary" summary)
  (println "take" (top-2 summary))
  )

(let [orders (s.db/all-orders)
      summary (summary-per-user-sorted orders)]
  (println "Filter > 500 ->" (filter #(> (:total-price %) 500) summary))
  (println "Filter NOT EMPTY > 500 ->" (not (empty? (filter #(> (:total-price %) 500) summary))))
  (println "Some > 500 ->" (some #(> (:total-price %) 500) summary))
  )