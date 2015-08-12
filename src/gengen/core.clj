(ns gengen.core

    (:require
            [com.gfredericks.test.chuck :as chuck]
            [com.gfredericks.test.chuck.generators :as gen']
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(def int-vector (gen/vector (gen/fmap #(+ 1 %) gen/pos-int)))

(defn get-int-vector
  [size]
  (gen/sample int-vector size))

(defn chuck-sample
  []
  (gen/sample (gen'/string-from-regex #"([☃-♥]{3}|B(A|OO)M)*")))

