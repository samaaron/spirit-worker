(ns spirit-worker
  (:import (java.util.concurrent LinkedBlockingQueue)))

(defrecord Spirit [queue worker])

(defn spirit
  "Create a new spirit that inhabits its own separate thread"
  []
  (let [queue (LinkedBlockingQueue.)
        work #(loop [job (.take queue)]
                (apply job [])
                (recur (.take queue)))
        worker (Thread. work)]
    (.start worker)
    (Spirit. queue worker)))

(defn elicit
  "Send an argless fn job (thunk) to the spirit for evaluation on a separate thread"
  [spirit job]
  (.put (spirit :queue) job))
