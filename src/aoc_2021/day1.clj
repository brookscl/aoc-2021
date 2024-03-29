(in-ns 'aoc-2021.core)

(defn parse
  "Convert a text file into a rows of integer vectors"
  [string]
  (map #(str->int % )
       (clojure.string/split string #"\n")))

(defn deeper?
  [[l1 l2]]
  (> l2 l1))

(defn count-increasing
  [depths]
  (count (filter deeper? (partition 2 1 depths))))

(defn count-increasing-single
  "Count increasing depths in specified file"
  [depth-file]
  (count-increasing (parse (slurp depth-file))))

(defn count-sliding-window-increasing
  [depth-file]
  (count-increasing (map #(reduce + %) (partition 3 1 (parse (slurp depth-file))))))