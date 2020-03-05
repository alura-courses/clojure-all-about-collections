(ns store.lesson3
  (:require [store.db :as s.db]))

;(println (group-by :user (s.db/all-orders)))

(defn my-grouping
  [element]
  ;(println "element" element)
  (:user element))

;(println (group-by my-grouping (s.db/all-orders)))

; {15 [x, y, z]
; {1 []
; {10 [k]
; {20 []

;(println (map count (vals (group-by :user (s.db/all-orders)))))

;
(->> (s.db/all-orders)
     (group-by :user)
     vals
     (map count)
     ;println
     )

(defn counts-total-of-orders-per-user
  [[user orders]]
  [user (count orders)]
  )

(->> (s.db/all-orders)
     (group-by :user)
     (map counts-total-of-orders-per-user)
     println)

  (defn total-price-per-item
    [[_ details]]
    (* (get details :quantity 0) (get details :price-per-unit 0)))

(defn total-price-per-order
  [order]
  (->> order
       (map total-price-per-item)
       (reduce +))
  ;(reduce + (map total-price-per-item order))
  )

(defn total-price-per-user
  [orders]
  (->> orders
       (map :items)
       (map total-price-per-order)
       (reduce +)))

(defn counts-orders-and-total-price-per-user
  [[user orders]]
  {:user-id user
   :total-of-orders (count orders)
   :total-price (total-price-per-user orders)}
  )

(->> (s.db/all-orders)
     (group-by :user)
     (map counts-orders-and-total-price-per-user)
     println)