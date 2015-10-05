(ns algoritam.pirson
    (:require [algoritam.models.db :as db]))

(def n (atom 0))

(defn brojZajednickihOcena [x1 x2]
  (if (and (not= nil x1) (not= nil x2))      
    (swap! n inc)))

(defn sumaZajednickihOcena [kriticar1, kriticar2]
  (brojZajednickihOcena (algoritam.models.db/vrati-Lady_in_the_Water kriticar1) (algoritam.models.db/vrati-Lady_in_the_Water kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar1) (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Just_My_Luck kriticar1) (algoritam.models.db/vrati-Just_My_Luck kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Superman_Returns kriticar1) (algoritam.models.db/vrati-Superman_Returns kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-You_Me_and_Dupree kriticar1) (algoritam.models.db/vrati-You_Me_and_Dupree kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-The_Night_Listener kriticar1) (algoritam.models.db/vrati-The_Night_Listener kriticar2))
  @n)