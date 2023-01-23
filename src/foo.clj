(ns foo
  (:gen-class)
  (:require bar))

(defn -main []
  (println (bar/qux)))
