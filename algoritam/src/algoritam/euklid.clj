(ns algoritam.euklid
    (:require [algoritam.models.db :as db]))

(def suma (atom 0.0))

(defn sumaKvadrataRazlike [x1 x2]
  (if (and (not= nil x1) (not= nil x2))      
     (swap! suma (fn [n] (+ n (Math/pow (- x1 x2) 2))))))
     
(defn euklid [kriticar1, kriticar2]
  (sumaKvadrataRazlike (algoritam.models.db/vrati-Lady_in_the_Water kriticar1) (algoritam.models.db/vrati-Lady_in_the_Water kriticar2))
  (sumaKvadrataRazlike (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar1) (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar2))
  (sumaKvadrataRazlike (algoritam.models.db/vrati-Just_My_Luck kriticar1) (algoritam.models.db/vrati-Just_My_Luck kriticar2))
  (sumaKvadrataRazlike (algoritam.models.db/vrati-Superman_Returns kriticar1) (algoritam.models.db/vrati-Superman_Returns kriticar2))
  (sumaKvadrataRazlike (algoritam.models.db/vrati-You_Me_and_Dupree kriticar1) (algoritam.models.db/vrati-You_Me_and_Dupree kriticar2))
  (sumaKvadrataRazlike (algoritam.models.db/vrati-The_Night_Listener kriticar1) (algoritam.models.db/vrati-The_Night_Listener kriticar2))
  (/ 1 (+ 1 (Math/sqrt @suma))))

(def vrednosti (atom {}))

(defn najslicnijiKriticar []
  (key (apply min-key val @vrednosti)))

(defn uporediSaOstalimKriticarima [Name]
        (for [i (range (algoritam.models.db/vrati-broj-redova-u-bazi))]
          (swap! vrednosti assoc (algoritam.models.db/OOO Name i) (euklid Name (algoritam.models.db/OOO Name i)))))