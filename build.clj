(ns build
  (:require [clojure.tools.build.api :as b]))

(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))

(defn uberjar [_]
  (b/delete {:path "target"})
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  ;; This fails:
                  :ns-compile '[foo bar]
                  ;; This (or the default setting) succeeds:
                  ;; :ns-compile '[bar foo]
                  :class-dir class-dir})
  (b/uber {:class-dir class-dir
           :uber-file "uber.jar"
           :basis basis
           :main 'foo}))
