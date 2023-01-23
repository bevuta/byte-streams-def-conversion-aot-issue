(ns bar
  (:require [clj-commons.byte-streams :as bs]))

(deftype Qux [])

(bs/def-conversion [Qux String] [_ _] "qux")

(defn qux []
  (bs/to-string (Qux.)))
