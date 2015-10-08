(ns algoritam.pirson
     (:require [algoritam.models.db :as db]))

(def s1 (atom 0))
(def s2 (atom 0))

(defn suma1 [x]
  (if (not= x nil)
    (swap! s1 (fn [n] (+ n x)))))

(defn suma2 [x]
  (if (not= x nil)
    (swap! s2 (fn [n] (+ n x)))))

(def n (atom 0))

(def sKvadrat1 (atom 0))

(defn sumaKvadrata1 [x]
  (if (not= x nil)
    (swap! sKvadrat1 (fn [n] (+ n (Math/pow x 2))))))

(def sKvadrat2 (atom 0))

(defn sumaKvadrata2 [x]
  (if (not= x nil)
    (swap! sKvadrat2 (fn [n] (+ n (Math/pow x 2))))))

(def sXputaY (atom 0)
  )

(defn sumaXputaY [x y]
(if (and (not= nil x) (not= nil y))
  (swap! sXputaY (fn [n] (+ n (* x y))))))

(defn svezivododaj [x1 x2]
  (swap! n inc)
  (suma1 x1)
  (suma2 x2)
  (sumaKvadrata1 x1)
  (sumaKvadrata2 x2)
  (sumaXputaY x1 x2))

(defn brojZajednickihOcena [x1 x2]
  (if (and (not= nil x1) (not= nil x2))      
    (svezivododaj x1 x2)))

(defn resetAll []
  (reset! n 0)
  (reset! s1 0)
  (reset! s2 0)
  (reset! sKvadrat1 0)
  (reset! sKvadrat2 0)
  (reset! sXputaY 0)
  )

(defn pirson []
  (/ (- (* @n @sXputaY) (* @s1 @s2)) (Math/sqrt (* (- (* @n @sKvadrat1) (Math/pow @s1 2)) (- (* @n @sKvadrat2) (Math/pow @s2 2))))))

(def vrednosti (atom {}))

(defn sumaZajednickihOcena [kriticar1 kriticar2]
  (brojZajednickihOcena (algoritam.models.db/vrati-Lady_in_the_Water kriticar1) (algoritam.models.db/vrati-Lady_in_the_Water kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar1) (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Just_My_Luck kriticar1) (algoritam.models.db/vrati-Just_My_Luck kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Superman_Returns kriticar1) (algoritam.models.db/vrati-Superman_Returns kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-You_Me_and_Dupree kriticar1) (algoritam.models.db/vrati-You_Me_and_Dupree kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-The_Night_Listener kriticar1) (algoritam.models.db/vrati-The_Night_Listener kriticar2))
  (pirson))

(defn najslicnijiKriticar []
  (key (apply max-key val @vrednosti)))

(defn uporediSaOstalimKriticarima [Name]
        (for [i (range (algoritam.models.db/vrati-broj-redova-u-bazi))]
          (swap! vrednosti assoc (algoritam.models.db/OOO Name i) (sumaZajednickihOcena Name (algoritam.models.db/OOO Name i)))))