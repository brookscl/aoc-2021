(in-ns 'aoc-2021.core)

(defn parse
  "Convert a text file into a rows of integer vectors"
  [string]
  (map #(str->int % )
       (clojure.string/split string #"\n")))

(defn deeper
  [[l1 l2]]
  (if (> l2 l1) 1 0))

(defn count-increasing
  "Count increasing depths in specified file"
  [depth-file]
  (reduce + (map deeper (partition 2 1 (parse (slurp depth-file)))
  )))
