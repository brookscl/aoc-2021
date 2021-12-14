(in-ns 'aoc-2021.core)

(defn parse-instructions
  [string]
  (map #(clojure.string/split % #"\s+")
       (clojure.string/split string #"\n")))

(defn move
  [[x y aim] [direction str-amount]]
  (let [amount (str->int str-amount)]
    (case direction
      "forward" [(+ x amount) y]
      "up" [x (- y amount)]
      "down" [x (+ y amount)]))
  )

(defn aim-move
  [[x y aim] [direction str-amount]]
  (let [amount (str->int str-amount)]
    (println x y aim "moving" direction str-amount)
    (case direction
      "forward" [(+ x amount) (+ y (* aim amount)) aim]
      "up" [x y (- aim amount)]
      "down" [x y (+ aim amount)]))
  )

(defn travel
  ([[x y aim] instructions]
   (travel [x y aim] instructions move))
  ([[x y aim] instructions move-fn]
   (if (seq instructions)
     (recur (move-fn [x y aim] (first instructions)) (rest instructions) move-fn)
     (* x y)
     ))
  )

;(travel [0 0 0] (parse-instructions (slurp "day2-test.txt")))