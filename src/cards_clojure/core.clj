(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])
(def ranks (range 1 14))                                    ;range is magic and will auto fill a range
(def rank-names {1  :ace
                 11 :jack
                 12 :queen
                 13 :king})
(defn create-deck []
  (set (for [suit suits
             rank ranks]
         {:suit suit
          :rank (get rank-names rank rank)})))

(defn create-hands [deck]
  (set (for [c1 deck
             c2 (disj deck c1)
             c3 (disj deck c1 c2)
             c4 (disj deck c1 c2 c3)]
         #{c1 c2 c3 c4})))

(defn flush? [hand]
  (= 1 (count (set (map :suit hand))))
  )                                                         ;comment to commit

; shoutout to haaja who's github showed me frequencies
(defn four-of-a-kind? [hand]
  (== (apply max (vals (frequencies (map :rank hand)))) 4)) ;rewritten to match 3 of a kind if we decide to use 5 card hands
;gets the frequencies of the hand if the same rank is used 4 times then isFourOfAKind

(defn three-of-a-kind? [hand]
  (== (apply max (vals (frequencies (map :rank hand)))) 3)) ;checks via frequencies to see if the max frequency is 3

(defn straight? [hand]
  (let [sorted (sort (map :rank hand))
        smallest (first sorted)                             ;; sorts set by rank and pulls first card out
        ;(sort (replace {14 1} sorted))
        ;alt-smallest (first alt)
        ]                                                   ;makes alternate map and pulls out first card
    (= sorted (range smallest (+ smallest 4)))))            ;checks range to equal smallest card to largest being smallest + 4

  (defn straight-flush? [hand]
    (and
      (straight? hand)
      (flush? hand)))

  (defn two-pairs? [hand]
    (or
      (= 2 (get (frequencies (vals (frequencies (map :rank hand)))) 2)) ;frequencies pulls the number of times an item is in a set
      #_(= 1 (get (frequencies (vals (frequencies (map :rank hand)))) 4)))) ;so by pull if the frequencies pulled = 2 ever, it is a pair
  ; if you get two sets of two then you have two pair




  (defn -main [& args]
    (time (let [deck (create-deck)
                hands (create-hands deck)
                hands (filter flush? hands)]
            (println (count hands))))
    )
