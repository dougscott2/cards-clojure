(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

(def flush-test-true #{{:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}})

(def flush-test-false #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}})
(def four-of-a-kind-true #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :hearts
               :rank 2}})
(def four-of-a-kind-false #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :hearts
               :rank 3}})
(def three-of-a-kind-true #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :hearts
               :rank 3}})
(def three-of-a-kind-false #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 4}
              {:suit :spades
               :rank 3}
              {:suit :hearts
               :rank 3}})
(def straight-flush-true #{{:suit :diamonds
                              :rank 2}
                             {:suit :diamonds
                              :rank 3}
                             {:suit :diamonds
                              :rank 4}
                             {:suit :diamonds
                              :rank 5}})
(def straight-flush-false #{{:suit :clubs
                            :rank 2}
                           {:suit :diamonds
                            :rank 3}
                           {:suit :diamonds
                            :rank 4}
                           {:suit :diamonds
                            :rank 5}})

(def two-pair-true #{{:suit :diamonds
                            :rank 2}
                           {:suit :clubs
                            :rank 2}
                           {:suit :diamonds
                            :rank 4}
                           {:suit :hearts
                            :rank 4}})
(def two-pair-false #{{:suit :clubs
                             :rank 2}
                            {:suit :diamonds
                             :rank 2}
                            {:suit :diamonds
                             :rank 4}
                            {:suit :diamonds
                             :rank 5}})




(deftest flush?-test
  (testing "flush? returns true if hand is a flush"
    (is (= true (flush? flush-test-true)))
    (is (= false (flush? flush-test-false)))))
(deftest four-of-a-kind?-test
  (testing "Four of a kind? Retruns true if hand is four of a kind"
    (is (= true (four-of-a-kind? four-of-a-kind-true)))
    (is (= false (four-of-a-kind? four-of-a-kind-false)))))

(deftest three-of-a-kind?-test
  (testing "3 of a kind? returns true if hand is 3 of a kind"
    (is (= true (three-of-a-kind? three-of-a-kind-true)))
    (is (= false (three-of-a-kind? three-of-a-kind-false)))))


(deftest straight?-test
  (testing "Testing straights? if straigh return true"
    (is (= true (straight? straight-flush-true)))
    ))
(deftest straigh-flush?-test
  (testing "Testing straigh flush. if is straigh flush return true"
    (is (= true (straight-flush? straight-flush-true)))
    (is (= false (straight-flush? straight-flush-false)))))
(deftest two-pair-test
  (testing "testing two-pair, return true if two-pair"
    (is (= true (two-pairs? two-pair-true)))
    (is (= false (two-pairs? two-pair-false)))))







