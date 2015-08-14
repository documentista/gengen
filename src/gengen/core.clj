(ns gengen.core

    (:require
            [com.gfredericks.test.chuck :as chuck]
            [com.gfredericks.test.chuck.generators :as gen']
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(def int-vector (gen/vector (gen/fmap #(+ 1 %) gen/pos-int)))


;; regexes from regular-expressions.info
(def email-regex "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$")

(def postal-code-regex "[0-9]")

(defn get-int-vector
  [size]
  (gen/sample int-vector size))

(defn chuck-sample
  []
  (gen/sample (gen'/string-from-regex #"([☃-♥]{3}|B(A|OO)M)*")))

(defn gen-emails
  [sample-size]
  (gen/sample (gen'/string-from-regex #"[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}")))

(defn gen-postal-codes
  [sample-size]
  (gen/sample (gen'/string-from-regex #"[0-9]{5}(-[0-9]{4})?") sample-size))

