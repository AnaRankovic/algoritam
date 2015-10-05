(ns algoritam.pirson
    (:require [algoritam.models.db :as db]))

;Broj filmova koji su oba kriticara ocenila
(def n (atom 0))

(defn brojZajednickihOcena [x1 x2]
  (if (and (not= nil x1) (not= nil x2))      
    (swap! n inc)))

(defn sumaZajednickihOcena [kriticar1 kriticar2]
  (brojZajednickihOcena (algoritam.models.db/vrati-Lady_in_the_Water kriticar1) (algoritam.models.db/vrati-Lady_in_the_Water kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar1) (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Just_My_Luck kriticar1) (algoritam.models.db/vrati-Just_My_Luck kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-Superman_Returns kriticar1) (algoritam.models.db/vrati-Superman_Returns kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-You_Me_and_Dupree kriticar1) (algoritam.models.db/vrati-You_Me_and_Dupree kriticar2))
  (brojZajednickihOcena (algoritam.models.db/vrati-The_Night_Listener kriticar1) (algoritam.models.db/vrati-The_Night_Listener kriticar2))
  @n)

;Suma svih ocena za jednog kriticara
(def s1 (atom 0))

(defn suma [x]
  (if (not= x nil)
    (swap! s1 (fn [n] (+ n x)))))

(defn sumaOcenaZaJednogKriticara [kriticar]
  (suma (algoritam.models.db/vrati-Lady_in_the_Water kriticar))
  (suma (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar))
  (suma (algoritam.models.db/vrati-Just_My_Luck kriticar))
  (suma (algoritam.models.db/vrati-Superman_Returns kriticar))
  (suma (algoritam.models.db/vrati-You_Me_and_Dupree kriticar))
  (suma (algoritam.models.db/vrati-The_Night_Listener kriticar))
  @s1)

;Suma kvadrata svih ocena za jednog kriticara
(def s2 (atom 0))

(defn sumaKvadrata [x]
  (if (not= x nil)
    (swap! s2 (fn [n] (+ n (Math/pow x 2))))))

(defn sumaKvadrataOcenaZaJednogKriticara [kriticar]
  (sumaKvadrata (algoritam.models.db/vrati-Lady_in_the_Water kriticar))
  (sumaKvadrata (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar))
  (sumaKvadrata (algoritam.models.db/vrati-Just_My_Luck kriticar))
  (sumaKvadrata (algoritam.models.db/vrati-Superman_Returns kriticar))
  (sumaKvadrata (algoritam.models.db/vrati-You_Me_and_Dupree kriticar))
  (sumaKvadrata (algoritam.models.db/vrati-The_Night_Listener kriticar))
  @s2)

;Suma proizvoda ocena k1 i k2 za svaki film
(def s3 (atom 0))

(defn sumaProizvoda [x1 x2]
  (if (and (not= nil x1) (not= nil x2))      
    (swap! s3 (fn [n] (+ n (* x1 x2))))))

(defn sumaProizvodaOcena [kriticar1, kriticar2]
  (sumaProizvoda (algoritam.models.db/vrati-Lady_in_the_Water kriticar1) (algoritam.models.db/vrati-Lady_in_the_Water kriticar2))
  (sumaProizvoda (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar1) (algoritam.models.db/vrati-Snakes_on_a_Plane kriticar2))
  (sumaProizvoda (algoritam.models.db/vrati-Just_My_Luck kriticar1) (algoritam.models.db/vrati-Just_My_Luck kriticar2))
  (sumaProizvoda (algoritam.models.db/vrati-Superman_Returns kriticar1) (algoritam.models.db/vrati-Superman_Returns kriticar2))
  (sumaProizvoda (algoritam.models.db/vrati-You_Me_and_Dupree kriticar1) (algoritam.models.db/vrati-You_Me_and_Dupree kriticar2))
  (sumaProizvoda (algoritam.models.db/vrati-The_Night_Listener kriticar1) (algoritam.models.db/vrati-The_Night_Listener kriticar2))
  @s3)

;num
(defn num [kriticar1 kriticar2]
  (- (sumaProizvodaOcena kriticar1 kriticar2) (/ (* (sumaOcenaZaJednogKriticara kriticar1) (sumaOcenaZaJednogKriticara kriticar2)) (sumaZajednickihOcena kriticar1 kriticar2))))

;den
(defn den [kriticar1 kriticar2]
  (Math/sqrt (* (- (sumaKvadrataOcenaZaJednogKriticara kriticar1) (/ (Math/pow (sumaOcenaZaJednogKriticara kriticar1) 2) (sumaZajednickihOcena kriticar1 kriticar2)))
                (- (sumaKvadrataOcenaZaJednogKriticara kriticar2) (/ (Math/pow (sumaOcenaZaJednogKriticara kriticar2) 2) (sumaZajednickihOcena kriticar1 kriticar2))))))

;Pirsonov koeficijent
(defn ρ [kriticar1 kriticar2]
  (if (= (den kriticar1 kriticar2) 0)
    0
    (/ (num kriticar1 kriticar2) (den kriticar1 kriticar2))))